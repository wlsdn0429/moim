package project.moim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.moim.domain.Moim;

import java.util.Optional;

public interface MoimRepository extends JpaRepository<Moim, Long> {
    Optional<Moim> findById(Long id);
}
