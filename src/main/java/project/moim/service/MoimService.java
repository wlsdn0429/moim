package project.moim.service;

import project.moim.domain.Moim;
import java.util.List;

public interface MoimService {
    Moim createMoim(Moim moim);
    
    Moim getGroupMoim(Long id);

    List<Moim> getAllMoims();

    //void deletePerson(Long id);
}
