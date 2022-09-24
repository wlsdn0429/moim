package project.moim.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BoardDto {

    private int moimId;

    private String name;

    private int num;

    private String region;

    private String objectives;

    private int memcnt;

    private int fullmemcnt;

    private String filePath;
}
