package jpaDB.mapping.domain;

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

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL)
    private List<Filmed> filmedList = new ArrayList<>();

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL)
    private List<Participates> participates = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;        // 장르 : 영화, 드라마

    @Enumerated(EnumType.STRING)
    private GenreState genreState;

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
        genre.setArt(this);
    }
}
