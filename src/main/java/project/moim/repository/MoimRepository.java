package project.moim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.moim.domain.Moim;
import project.moim.domain.MoimJoin;

public interface MoimRepository extends JpaRepository<Moim, Long> {
    Moim findBynum(int num);
}
