package jpaDB.mapping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Filmed {

    @Id
    @GeneratedValue
    @Column(name = "Film_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "A_id")
    private Art art;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Loc_id")
    private Location location;

    public static Filmed createFilmed(Location location) {
        Filmed filmed = new Filmed();
        filmed.setLocation(location);

        return filmed;
    }

}
