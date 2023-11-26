package jpaDB.mapping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Actor {

    @Id
    @GeneratedValue
    @Column(name = "Actor_id")
    private Long id;

    private String Act_name;

    private String Sex;

    @OneToMany(mappedBy = "actor")
    private List<Participates> participates = new ArrayList<>();

}
