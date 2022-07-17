package project.moim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.moim.domain.MoimJoin;
import project.moim.domain.User;

import java.util.ArrayList;
import java.util.Optional;

public interface MoimJoinRepository extends JpaRepository<MoimJoin, Long> {
    ArrayList<MoimJoin> findBymemberId(Long kakaoId);
}
