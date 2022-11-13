package project.moim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.moim.domain.MoimJoin;
import project.moim.domain.User;
import project.moim.repository.MoimJoinRepository;
import project.moim.repository.UserRepository;

import java.util.ArrayList;

@Service
public class MoimJoinServiceImp implements MoimJoinService{
    private final UserRepository userRepository;
    private final MoimJoinRepository moimJoinRepository;

    @Autowired
    public MoimJoinServiceImp(UserRepository userRepository, MoimJoinRepository moimJoinRepository) {
        this.userRepository = userRepository;
        this.moimJoinRepository = moimJoinRepository;
    }
    @Override
    public User getUserInfo(Long kakaoId){
        User user = userRepository.findByKakaoId(kakaoId).orElse(null);
        return user;
    }
    @Override
    public ArrayList<MoimJoin> getGroups(Long id){
        ArrayList<MoimJoin> moimJoins = moimJoinRepository.findBymemberId(id);
       return moimJoins;
    }
}