package jpaDB.mapping.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jpaDB.mapping.domain.Art;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
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
        boolean Condition = true;

        // 장르 상태로 검색
        if (artSearch.getGenreStatus() != null) {
            if (Condition) {
                jpql += " where";
                Condition = false;
            } else {
                jpql += " and";
            }
            jpql += " a.genreStatus = :genreStatus";
        }

        // 작품명으로 검색
        if (StringUtils.hasText(artSearch.getArtName())) {
            if (Condition) {
                jpql += " where";
                Condition = false;
            } else {
                jpql += " and";
            }
            jpql += " a.Name like :artName";
        }

        // 쿼리 생성, 결과 : 1000개
        TypedQuery<Art> query = em.createQuery(jpql, Art.class)
                .setMaxResults(1000);

        // 파라미터 설정
        if (artSearch.getGenreStatus() != null) {
            query = query.setParameter("genreStatus", artSearch.getGenreStatus());
        }
        if (StringUtils.hasText(artSearch.getArtName())) {
            query = query.setParameter("artName", "%" + artSearch.getArtName() + "%");
        }

        return query.getResultList();
    }

    // 페이징 처리를 위한 메소드 추가
    public Page<Art> findAll(Pageable pageable) {
        TypedQuery<Art> query = em.createQuery("select a from Art a", Art.class);
        int totalRows = query.getResultList().size();
        List<Art> results = query.setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        return new PageImpl<>(results, pageable, totalRows);
    }
}
