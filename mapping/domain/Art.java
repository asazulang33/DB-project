package jpaDB.mapping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Art {

    @Id
    @GeneratedValue
    @Column(name = "A_id")
    private Long id;            // id

    private String Name;        // 작품명

    private Integer Year;       // 연도

    @JsonIgnore
    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL)
    private List<Filmed> filmedList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL)
    private List<Participates> participates = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "g_id")
    private Genre genre;

    // 연관관계 메서드
    public void addFilmed(Filmed filmed) {
        filmedList.add(filmed);
        filmed.setArt(this);
    }

    public void addParticipates(Participates participate) {
        participates.add(participate);
        participate.setArt(this);
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
        genre.getArt().add(this);
    }

    // 비즈니스 로직
    public static Art createArt(String artName, Integer year, List<Filmed> filmedList, List<Actor> actors, Genre genre) {
        Art art = new Art();
        art.setName(artName);
        art.setYear(year);
        art.setGenre(genre);

        for (Filmed filmed : filmedList) {
            art.addFilmed(filmed);
        }

        for (Actor actor : actors) {
            Participates participates = Participates.createParticipate(actor);
            art.addParticipates(participates);
        }

        return art;
    }
}
