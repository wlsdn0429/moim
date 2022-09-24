package project.moim.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDto {
    private Long id;
    private String origFilename;
    private String filename;
    private String filePath;

    @Builder
    public FileDto(String origFilename, String filename, String filePath) {
        this.origFilename = origFilename;
        this.filename = filename;
        this.filePath = filePath;
    }
}
