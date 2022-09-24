package project.moim.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoimDto {

    private int moimId;

    private String name;

    private int num;

    private String region;

    private String objectives;

    private int memcnt;

    private int fullmemcnt;

    private Long fileId;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

//    public MoimRoom toEntity() {
//        MoimRoom build = MoimRoom.builder()
//                .name(name)
//                .region(region)
//                .objectives(objectives)
//                .build();
//        return build;
//    }
    @Builder
    public MoimDto(String name, String region, String objectives, int fullmemcnt, Long fileId, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.name = name;
        this.region = region;
        this.objectives = objectives;
        this.fullmemcnt = fullmemcnt;
        this.fileId = fileId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}

