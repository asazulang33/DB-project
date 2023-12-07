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

    private String CTPRVN_NM;
    private String SIGNGU_NM;
    private String Specific_Addr_NM;

    private LocalDateTime Last_modified_date;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Filmed> filmedList = new ArrayList<>();

    public static Location createLoc(String name, String CTPRVN_NM, String SIGNGU_NM, String Specific_Addr_N) {
        Location location = new Location();
        location.setLoc_name(name);
        location.setCTPRVN_NM(CTPRVN_NM);
        location.setSIGNGU_NM(SIGNGU_NM);
        location.setSpecific_Addr_NM(Specific_Addr_N);
        location.setLast_modified_date(LocalDateTime.now());
        return location;
    }
}
