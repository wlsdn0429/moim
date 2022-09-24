package project.moim.service;

import org.springframework.stereotype.Service;
import project.moim.domain.sFile;
import project.moim.repository.BoardFileRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FileService {
    private BoardFileRepository boardFileRepository;

    public FileService(BoardFileRepository boardFileRepository) {
        this.boardFileRepository = boardFileRepository;
    }

    @Transactional
    public void saveFile(sFile file) {boardFileRepository.save(file);
    }

//    @Transactional
//    public FileDto getFile(Long id) {
//        File file = fileRepository.findById(id).get();
//
//        FileDto fileDto = FileDto.builder()
//                .origFilename(file.getOrigFilename())
//                .filename(file.getFilename())
//                .filePath(file.getFilePath())
//                .build();
//        return fileDto;
//    }
    @Transactional
    public List<sFile> selectAllFile(){
        List<sFile> fileList = boardFileRepository.findAll();
        return fileList;
    }

}