package jpaDB.mapping.service;

import jpaDB.mapping.domain.Actor;
import jpaDB.mapping.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    @Transactional
    public void saveActor(Actor actor) {
        actorRepository.save(actor);
    }

    public Actor findActor(Long ActorId) {
        return actorRepository.findOne(ActorId);
    }

    public List<Actor> findAllActor() {
        return actorRepository.findAll();
    }

    public List<Actor> findByActorName(String ActorName) {
        return actorRepository.findByName(ActorName);
    }
}
