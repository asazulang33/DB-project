package jpaDB.mapping.repository;

import jpaDB.mapping.domain.GenreStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArtSearch {

    private String artName;         // 작품명
    private GenreStatus genreStatus;  // Movie, Drama, Book
}
