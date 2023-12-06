package jpaDB.mapping.repository;

import jpaDB.mapping.domain.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArtSearch {

    private String artName;         // 작품명
    private Genre genre;  // Movie, Drama, Book

}
