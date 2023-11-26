package jpaDB.mapping;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jpaDB.mapping.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit() {
            System.out.println("Init" + this.getClass());

            // 배우 생성 및 저장
            Actor actor1 = createActor("김동회", "남자");
            em.persist(actor1);
            Actor actor2 = createActor("이민철", "여자");
            em.persist(actor2);
            Actor actor3 = createActor("김철수", "남자");
            em.persist(actor3);

            // 장소 생성 및 저장
            Location location1 = Location.createLoc("학교", "수원시", "권선구", "금곡동 홈플러스");
            em.persist(location1);
            Location location2 = Location.createLoc("영화관", "수원시", "권선구", "금곡동 롯데시네마");
            em.persist(location2);

            // 작품 생성 및 저장
            createAndPersistArt("입시", 2018, Arrays.asList(actor1, actor2), location1);
            createAndPersistArt("영화", 2020, Arrays.asList(actor2, actor3), location2);
            createAndPersistArt("라면", 2018, Arrays.asList(actor3), location1);
        }

        private void createAndPersistArt(String name, Integer year, List<Actor> actors, Location location) {
            Filmed filmed = Filmed.createFilmed(location);
            em.persist(filmed);

            Art art = Art.createArtMovie(name, year, filmed, actors);
            em.persist(art);
        }

        private Actor createActor(String name, String sex) {
            Actor actor = new Actor();
            actor.setAct_name(name);
            actor.setSex(sex);
            return actor;
        }
    }
}
