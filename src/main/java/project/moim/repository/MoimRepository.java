package project.moim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import project.moim.domain.MoimRoom;

import java.util.List;

public interface MoimRepository extends JpaRepository<MoimRoom, Integer> {

    MoimRoom findBynum(int num);
    List<MoimRoom> findAll();
    MoimRoom findById(int id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE MoimRoom m SET m.objectives = ?1, m.name = ?2, m.region = ?3, m.fullmemcnt = ?4, m.moimpicture = ?5 where seq = ?6 ")
    void updateMoimRoom(String objectives, String name, String region, int fullmemcnt, String moimpicture, int seq);
}
