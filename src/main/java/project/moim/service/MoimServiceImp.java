package project.moim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.moim.domain.posts.Moim;
import project.moim.domain.posts.MoimRepository;

import java.util.List;

@Service
public class MoimServiceImp implements MoimService {
    @Autowired // 1
    private MoimRepository moimRepository;

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
