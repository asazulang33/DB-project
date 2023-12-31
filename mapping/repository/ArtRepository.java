package jpaDB.mapping.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jpaDB.mapping.domain.Art;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class ArtRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Art art) {
        em.persist(art);
    }

    // Art의 PK를 통해 작품을 찾는 로직
    public Art findOne(Long id) {
        return em.find(Art.class, id);
    }

    // 모든 작품 정보를 찾아오는 로직
    public List<Art> findAllArts() {
        return em.createQuery("select a from Art a", Art.class).getResultList();
    }

    // 작품명, 장르를 기반으로 찾아내는 로직
    public List<Art> findAll(ArtSearch artSearch) {
        String jpql = "select a from Art a";
        boolean condition = true;

        // 장르 검색
        if (artSearch.getGenre() != null && StringUtils.hasText(artSearch.getGenre().getGenreName())) {
            if (condition) {
                jpql += " where";
                condition = false;
            } else {
                jpql += " and";
            }
            jpql += " a.genre.genreName = :genreName";
        }

        // 작품명 검색
        if (StringUtils.hasText(artSearch.getArtName())) {
            if (condition) {
                jpql += " where";
                condition = false;
            } else {
                jpql += " and";
            }
            jpql += " a.Name like :artName";
        }

        // 쿼리 생성
        TypedQuery<Art> query = em.createQuery(jpql, Art.class);

        // 파라미터 설정
        if (artSearch.getGenre() != null && StringUtils.hasText(artSearch.getGenre().getGenreName())) {
            query = query.setParameter("genreName", artSearch.getGenre().getGenreName());
        }
        if (StringUtils.hasText(artSearch.getArtName())) {
            query = query.setParameter("artName", "%" + artSearch.getArtName() + "%");
        }

        return query.getResultList();
    }

    // 페이징 기능 및 작품 검색 기능
    public Page<Art> findArtsPage(ArtSearch artSearch, Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Art> cq = cb.createQuery(Art.class);
        Root<Art> art = cq.from(Art.class);

        List<Predicate> predicates = new ArrayList<>();

        // 필터링 조건 추가
        if (artSearch.getGenre() != null && StringUtils.hasText(artSearch.getGenre().getGenreName())) {
            predicates.add(cb.equal(art.get("genre").get("genreName"), artSearch.getGenre().getGenreName()));
        }

        if (StringUtils.hasText(artSearch.getArtName())) {
            predicates.add(cb.like(art.get("Name"), "%" + artSearch.getArtName() + "%"));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Art> query = em.createQuery(cq);
        int totalRows = query.getResultList().size();
        List<Art> results = query.setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        return new PageImpl<>(results, pageable, totalRows);
    }
}