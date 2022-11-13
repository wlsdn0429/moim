package project.moim.domain.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
@Entity
public class Moim extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="moim_id")
    private Long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column(name="max_num")
    private int num;

    @NotNull
    @Column
    private String region;

    @NotNull
    @Column
    private String objectives;
}
