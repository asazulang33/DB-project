package jpaDB.mapping.repository;

import jakarta.persistence.EntityManager;
import jpaDB.mapping.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepository {

    private final EntityManager em;

    public List<Genre> findAll() {
        return em.createQuery("select g from Genre g", Genre.class).getResultList();
    }

    public void setArtSearchGenre(ArtSearch artSearch, String genreStatus) {
        if (genreStatus != null && !genreStatus.isEmpty()) {
            Genre genre = em.createQuery("select g from Genre g where g.genreName = :genreName", Genre.class)
                    .setParameter("genreName", genreStatus)
                    .getSingleResult();
            artSearch.setGenre(genre);
        }
    }
}
