package project.moim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.moim.domain.Moim;
import project.moim.repository.MoimRepository;
import project.moim.repository.UserRepository;

import java.util.List;

@Service
public class MoimServiceImp implements MoimService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MoimRepository moimRepository;
//    @Autowired
//    public MoimServiceImp(UserRepository userRepository, MoimRepository moimRepository) {
//        this.userRepository = userRepository;
//        this.moimRepository = moimRepository;
//    }

    @Override
    public Moim getGroupMoim(Long id){
            return moimRepository.findById(id).get();
    }
    
    @Override
    public Moim createMoim(Moim moim) {
        return moimRepository.save(moim); // C
    }

    @Override
    public List<Moim> getAllMoims() {
        return moimRepository.findAll(); // R
    }

    /*    @Override
    public void deletePerson(Long id) {
        personRepository.delete(id); // D
    }*/
}
