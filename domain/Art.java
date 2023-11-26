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

    @Enumerated(EnumType.STRING)
    private GenreStatus genreStatus;

    // 연관관계 메서드
    public void addFilmed(Filmed filmed) {
        filmedList.add(filmed);
        filmed.setArt(this);
    }

    public void addParticipates(Participates participate) {
        participates.add(participate);
        participate.setArt(this);
    }

    public static Art createArtDrama(String artName, Integer year, Filmed filmed, List<Actor> actors) {
        Art art = new Art();
        art.setName(artName);
        art.setYear(year);
        art.addFilmed(filmed);
        art.setGenreStatus(GenreStatus.DRAMA);

        for (Actor actor : actors) {
            Participates participates = Participates.createParticipate(actor);
            art.addParticipates(participates);
        }

        return art;
    }

    public static Art createArtMovie(String artName, Integer year, Filmed filmed, List<Actor> actors) {
        Art art = new Art();
        art.setName(artName);
        art.setYear(year);
        art.addFilmed(filmed);
        art.setGenreStatus(GenreStatus.MOVIE);

        for (Actor actor : actors) {
            Participates participates = Participates.createParticipate(actor);
            art.addParticipates(participates);
        }

        return art;
    }

    public static Art createArtBook(String artName, Integer year, Filmed filmed, List<Actor> actors) {
        Art art = new Art();
        art.setName(artName);
        art.setYear(year);
        art.addFilmed(filmed);
        art.setGenreStatus(GenreStatus.BOOK);

        for (Actor actor : actors) {
            Participates participates = Participates.createParticipate(actor);
            art.addParticipates(participates);
        }

        return art;
    }
}
