package jpaDB.mapping.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Genre {

    @Id @GeneratedValue
    @Column(name = "g_id")
    private Long id;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private List<Art> art = new ArrayList<>();

    private String genreName;

    public static Genre createGenre(String genreName) {
        Genre genre = new Genre();
        genre.setGenreName(genreName);
        return genre;
    }
}
