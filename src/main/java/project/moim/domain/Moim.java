package project.moim.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Setter
@Entity
public class Moim {
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