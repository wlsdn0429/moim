package project.moim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.moim.domain.posts.Moim;
import project.moim.domain.posts.MoimRepository;

@Service
public class MoimServiceImp implements MoimService {
    @Autowired // 1
    private MoimRepository moimRepository;

    @Override
    public Moim createMoim(Moim moim) {
        return moimRepository.save(moim); // 2
    }

/*    @Override
    public void deletePerson(Long id) {
        personRepository.delete(id); // 3
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll(); // 4
    }*/
}
