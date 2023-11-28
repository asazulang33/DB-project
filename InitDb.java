package jpaDB.mapping;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jpaDB.mapping.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        GenreStatus MOVIE = GenreStatus.MOVIE;
        GenreStatus DRAMA = GenreStatus.DRAMA;
        GenreStatus BOOK = GenreStatus.BOOK;

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
            Location location1 = Location.createLoc("학교", "경기도 수원시", "권선구", "서수원로589");
            em.persist(location1);
            Location location2 = Location.createLoc("영화관", "경기도 남양주시", "조안면", "능내리 50");
            em.persist(location2);
            Location location3 = Location.createLoc("드라마 세트장", "경기 남양주시", "별내면", "청학로68번길 40");
            em.persist(location3);

            // 작품 생성 및 저장
            createArt("입시", 2018, DRAMA, Arrays.asList(actor1, actor2), Arrays.asList(location1, location2));
            createArt("영화", 2020, DRAMA, Arrays.asList(actor2, actor3), Arrays.asList(location2));
            createArt("라면", 2018, MOVIE, Arrays.asList(actor3), Arrays.asList(location1));
            createArt("꽃보다 남자", 2016, DRAMA, Arrays.asList(actor1, actor2, actor3), Arrays.asList(location3));
        }


        // 작품생성 : 작품명, 연도, 장르, 배우들, 촬영장소들
        private void createArt(String name, Integer year, GenreStatus genreStatus, List<Actor> actors, List<Location> locations) {
            List<Filmed> filmedList = locations.stream()
                    .map(Filmed::createFilmed)
                    .collect(Collectors.toList());
            filmedList.forEach(em::persist);

            Art art = Art.createArt(name, year, filmedList, actors, genreStatus);
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
