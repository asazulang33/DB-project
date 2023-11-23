package jpaDB.mapping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "Loc_id")
    private Long id;

    private String Loc_name;

    @Embedded
    private Address address;

    private LocalDateTime Last_modified_date;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Filmed> filmedList = new ArrayList<>();

}
