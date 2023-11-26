package jpaDB.mapping.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jpaDB.mapping.domain.Art;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArtRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Art art) {
        em.persist(art);
    }

    public Art findOne(Long id) {
        return em.find(Art.class, id);
    }

    public List<Art> findAllArts() {
        return em.createQuery("select a from Art a", Art.class).getResultList();
    }

    public List<Art> findAll(ArtSearch artSearch) {

        String jpql = "select a from Art a join a.Participates p";
        boolean isFirstCondition = true;

        //주문 상태 검색
        if (artSearch.getGenreStatus() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " a.genreStatus = :genreStatus";
        }

        //회원 이름 검색
        if (StringUtils.hasText(artSearch.getArtName())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " p.actor.name like :actor.name";
        }

        TypedQuery<Art> query = em.createQuery(jpql, Art.class)
                .setMaxResults(1000);

        if (artSearch.getGenreStatus() != null) {
            query = query.setParameter("genreStatus", artSearch.getGenreStatus());
        }
        if (StringUtils.hasText(artSearch.getArtName())) {
            query = query.setParameter("artName", artSearch.getArtName());
        }

        return query.getResultList();
    }
}
