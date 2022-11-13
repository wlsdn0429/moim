package project.moim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.moim.domain.MoimJoin;

import java.util.ArrayList;
public interface MoimJoinRepository extends JpaRepository<MoimJoin, Long> {
    ArrayList<MoimJoin> findBymemberId(Long kakaoId);
}