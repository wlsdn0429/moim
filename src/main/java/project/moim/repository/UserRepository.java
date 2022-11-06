package project.moim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.moim.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByKakaoId(Long kakaoId);
}