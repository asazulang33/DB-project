package jpaDB.mapping.repository;

import jakarta.persistence.EntityManager;
import jpaDB.mapping.domain.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class ActorRepository {

    private final EntityManager em;

    public void save(Actor actor) {
        if (actor.getId() == null) {
            em.persist(actor);
        } else {
            em.merge(actor);
        }
    }

    public Actor findOne(Long id) {
        return em.find(Actor.class, id);
    }

    public List<Actor> findAll() {
        return em.createQuery("select ac from Actor ac", Actor.class).getResultList();
    }

    public List<Actor> findByName(String Act_name) {
        return em.createQuery("select ac from Actor ac where ac.Act_name = :Act_name")
                .setParameter("Act_name", Act_name)
                .getResultList();
    }
}

