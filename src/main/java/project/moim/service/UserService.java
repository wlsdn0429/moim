package project.moim.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.moim.domain.User;
import project.moim.domain.UserRole;
import project.moim.repository.UserRepository;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,  AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void kakaoLogin(HashMap<String, Object> userInfo) {
        // 카카오 OAuth2 를 통해 카카오 사용자 정보 조회
//        System.out.println("kakaoLogin!!!!!!!!!!!!!!!!!!");
//        HashMap<String, Object> userInfo = new HashMap<>();
//        userInfo = kakaoOAuth2.kakaogetUserInfo(authorizedCode);
        Long kakaoId = (Long) userInfo.get("id");
        String nickname = (String) userInfo.get("nickname");
        String email = (String) userInfo.get("email");
        String age_range = (String) userInfo.get("age_range");
        String birthday = (String) userInfo.get("birthday");
        String gender = (String) userInfo.get("gender");
        String profile_image = (String) userInfo.get("profile_image");
//        System.out.println(kakaoId + nickname + email  + "!!!!!");
//        System.out.println("!!!!!!!!!!!");
        // 우리 DB 에서 회원 Id 와 패스워드
        // 회원 Id = 카카오 nickname
        String username = nickname;
        // 패스워드 = 카카오 Id + ADMIN TOKEN
        String password = kakaoId + ADMIN_TOKEN;

        System.out.println("1!!!!!!!!!!!");
        // DB 에 중복된 Kakao Id 가 있는지 확인
        User kakaoUser = userRepository.findByKakaoId(kakaoId).orElse(null);

        System.out.println("2!!!!!!!!!!!");
        // 카카오 정보로 회원가입
        if (kakaoUser == null) {
            System.out.println("3!!!!!!!!!!!");
            // 패스워드 인코딩
            String encodedPassword = passwordEncoder.encode(password);
            System.out.println("encodedPassword : " + encodedPassword);
            // ROLE = 사용자
            UserRole role = UserRole.USER;
            System.out.println("5!!!!!!!!!!!");
            //kakaoUser = new User(email, encodedPassword, nickname, role, kakaoId);
//            kakaoUser = new User(nickname, encodedPassword, email, role, kakaoId);
            User newUser = new User(nickname, encodedPassword, email, role, kakaoId, birthday, age_range, gender, profile_image);
            System.out.println("!!!!!!!!!!!");
            userRepository.save(newUser);
            System.out.println("!!!!!!!!!!!");
        }

        // 로그인 처리
        Authentication kakaoUsernamePassword = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(kakaoUsernamePassword);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public User getUserInfo(Long kakaoId){
        User user = userRepository.findByKakaoId(kakaoId).orElse(null);

        return user;
    }
}