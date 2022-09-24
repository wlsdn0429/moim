package project.moim.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.moim.domain.MoimRoom;
import project.moim.domain.MoimJoin;
import project.moim.repository.MoimJoinRepository;
import project.moim.repository.MoimRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MoimService {
    private final MoimRepository moimRepository;
    private final MoimJoinRepository moimJoinRepository;

    @Autowired
    public MoimService(MoimJoinRepository moimJoinRepository, MoimRepository moimRepository) {
        this.moimJoinRepository = moimJoinRepository;
        this.moimRepository = moimRepository;
    }
    public ArrayList<MoimJoin> getGroups(Long id){
        ArrayList<MoimJoin> moimJoins = moimJoinRepository.findBymemberId(id);
        return moimJoins;
    }
    public MoimRoom getGroupMoim(int id){
        MoimRoom moimRoom = moimRepository.findBynum(id);
        return moimRoom;
    }
    public List<MoimRoom> selectAllMoim(){
        List<MoimRoom> moimRoom = moimRepository.findAll();
        return moimRoom;
    }
    public void deleteMoim(int id){
        moimRepository.deleteById(id);
    }
//    @Transactional
//    public void savePost(MoimRoom moim) {
//        moimRepository.save(moim);
//    }

    @Transactional
    public List<MoimRoom> board() {
        return moimRepository.findAll();
    }


    @Transactional
    public MoimRoom saveMoim(MoimRoom moimRoom) {
        return moimRepository.save(moimRoom);
    }

    @Transactional
    public void updateMoim(MoimRoom moim, int seq) {
        moimRepository.updateMoimRoom(moim.getObjectives(), moim.getName(),moim.getRegion(),moim.getFullmemcnt(), moim.getMoimpicture(), seq);
    }
    @Transactional
    public MoimRoom selectMoim(int seq) {
        return moimRepository.findById(seq);
    }
}
