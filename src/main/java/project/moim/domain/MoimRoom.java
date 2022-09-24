package project.moim.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
public class MoimRoom {

    @Id
    @Column(name="seq")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column(name="name")
    private String name;

    @Column(nullable = true)
    private int num;

    @Column(nullable = true)
    private String region;

    @Column(nullable = true)
    private String objectives;

    @Column(nullable = true)
    private int memcnt;

    @Column(nullable = true)
    private int fullmemcnt;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column(nullable = true)
    private String moimpicture;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // (1)
    @JoinColumn(name="moim_id")
    private Collection<sFile> sFile;

    public MoimRoom(){}

    public MoimRoom(int seq, String name, int num, String region, String objectives, int memcnt, int fullmemcnt, Collection<sFile> sFile, String moimpicture) {
        this.seq = seq;
        this.name = name;
        this.num = num;
        this.region = region;
        this.objectives = objectives;
        this.memcnt = memcnt;
        this.fullmemcnt = fullmemcnt;
        this.sFile = sFile;
        this.moimpicture = moimpicture;
    }

    public void addFile(sFile p){
        if( sFile == null ){
            sFile = new ArrayList<sFile>();
        }
        sFile.add(p);
    }

}
