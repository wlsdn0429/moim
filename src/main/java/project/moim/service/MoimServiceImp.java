package project.moim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.moim.domain.Moim;
import project.moim.repository.MoimRepository;
import project.moim.repository.UserRepository;

import java.util.Optional;

@Service
public class MoimServiceImp implements MoimService {
    private final UserRepository userRepository;
    private final MoimRepository moimRepository;

    @Autowired
    public MoimServiceImp(UserRepository userRepository, MoimRepository moimRepository) {
        this.userRepository = userRepository;
        this.moimRepository = moimRepository;
    }
    @Override
    public Moim getGroupMoim(Long id){
        Optional<Moim> moim = moimRepository.findById(id);
            return moim.get();
    }
}