package project.moim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.moim.domain.sFile;

public interface BoardFileRepository extends JpaRepository<sFile, Integer> {
}
