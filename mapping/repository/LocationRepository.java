package jpaDB.mapping.repository;

import jakarta.persistence.EntityManager;
import jpaDB.mapping.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LocationRepository {

    private final EntityManager em;

    public void save(Location location) {
        if (location.getId() == null) {
            em.persist(location);
        }
        else {
            em.merge(location);
        }
    }

    public Location findOne(Long id) {
        return em.find(Location.class, id);
    }

    public List<Location> findAll() {
        return em.createQuery("select l from Location l", Location.class).getResultList();
    }
}
