package jpaDB.mapping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Filmed {

    @Id
    @GeneratedValue
    @Column(name = "Loc_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "A_id")
    private Art art;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Loc_id")
    private Location location;

}
