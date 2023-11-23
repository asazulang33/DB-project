package jpaDB.mapping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Genre {

    @Id
    @GeneratedValue
    @Column(name = "G_id")
    private Long id;

    private String Class;

    @OneToOne(mappedBy = "genre", fetch = FetchType.LAZY)
    private Art art;
}
