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
        GenreStatus ANIMATION = GenreStatus.ANIMATION;
        GenreStatus MUSIC = GenreStatus.MUSIC;

        public void dbInit() {
            System.out.println("Init" + this.getClass());

            // 배우 생성 및 저장
            Actor actor1 = createActor("송강호", "남자");
            em.persist(actor1);
            Actor actor2 = createActor("이선균", "남자");
            em.persist(actor2);
            Actor actor3 = createActor("조여정", "여자");
            em.persist(actor3);
            Actor actor4 = createActor("최우식", "남자");
            em.persist(actor4);
            Actor actor5 = createActor("박소담", "여자");
            em.persist(actor5);
            Actor actor6 = createActor("장혜진", "여자");
            em.persist(actor6);
            Actor actor7 = createActor("이정은", "여자");
            em.persist(actor7);
            Actor actor8 = createActor("최민수", "남자");
            em.persist(actor8);
            Actor actor9 = createActor("고현정", "여자");
            em.persist(actor9);
            Actor actor10 = createActor("박상원", "남자");
            em.persist(actor10);
            Actor actor11 = createActor("이정재", "남자");
            em.persist(actor11);
            Actor actor12 = createActor("류승룡", "남자");
            em.persist(actor12);
            Actor actor13 = createActor("이하늬", "여자");
            em.persist(actor13);
            Actor actor14 = createActor("진선규", "남자");
            em.persist(actor14);
            Actor actor15 = createActor("이동휘", "남자");
            em.persist(actor15);
            Actor actor16 = createActor("공명", "남자");
            em.persist(actor16);
            Actor actor17 = createActor("공유", "남자");
            em.persist(actor17);
            Actor actor18 = createActor("김고은", "여자");
            em.persist(actor18);
            Actor actor19 = createActor("이동욱", "남자");
            em.persist(actor19);
            Actor actor20 = createActor("유인나", "여자");
            em.persist(actor20);
            Actor actor21 = createActor("육성재", "남자");
            em.persist(actor21);
            Actor actor22 = createActor("박해수", "남자");
            em.persist(actor22);
            Actor actor23 = createActor("위하준", "남자");
            em.persist(actor23);
            Actor actor24 = createActor("오영수", "남자");
            em.persist(actor24);
            Actor actor25 = createActor("정호연", "여자");
            em.persist(actor25);



            // 장소 생성 및 저장
            // 이하 기생충
            Location location1 = Location.createLoc("스카이피자(피자시대)", "서울시", "동작구", "노량진로6길 86");
            em.persist(location1);
            Location location2 = Location.createLoc("돼지쌀슈퍼(우리슈퍼)", "서울시", "마포구", "손기정로 32");
            em.persist(location2);
            Location location3 = Location.createLoc("자하문터널 계단", "서울시", "종로구", "부암동 자하문로 219");
            em.persist(location3);
            Location location4 = Location.createLoc("박 사장 동네", "서울시", "성북구", "선잠로7길 52");
            em.persist(location4);
            Location location5 = Location.createLoc("고양 아쿠아 특수촬영 스튜디오(기택 가족 반지하집)", "경기도 고양시", "덕양구", "통일로396번길 250");
            em.persist(location5);
            Location location6 = Location.createLoc("전주영화종합촬영소(박 사장 집)", "전라북도 전주시", "완산구", "원상림길 125-14");
            em.persist(location6);
            //이하 모래시계
            Location location7 = Location.createLoc("정동진역", "강원도 강릉시", "강동면", "정동역길 17");
            em.persist(location7);
            //이하 극한직업&도깨비
            Location location8 = Location.createLoc("배다리 헌책방거리", "인천광역시", "동구", "중앙로 2");
            em.persist(location8);
            Location location9 = Location.createLoc("덕성여자대학 종로캠퍼스", "서울특별시", "종로구", "종로1.2.3.4가동");
            em.persist(location9);
            //이하 오징어게임
            Location location10 = Location.createLoc("팔도건어물", "서울특별시", "도봉구", "삼양로154길 36");
            em.persist(location10);
            Location location11 = Location.createLoc("신성공조시스템(자판기)", "서울특별시", "도봉구", "우이천로48길 9");
            em.persist(location11);
            Location location12 = Location.createLoc("휴먼(붕어빵집)", "서울특별시", "도봉구", "노해로70길 81");
            em.persist(location12);
            //임의 데이터
            Location location13 = Location.createLoc("아주대학교", "경기도 수원시", "영통구", "월드컵로 206");
            em.persist(location13);


            // 작품 생성 및 저장
            createArt("기생충", 2019, MOVIE, Arrays.asList(actor1, actor2, actor3, actor4, actor5, actor6, actor7),
                    Arrays.asList(location1, location2, location3, location4, location5, location6));
            createArt("모래시계", 2020, DRAMA, Arrays.asList(actor8, actor9, actor10, actor11),
                    Arrays.asList(location7));
            createArt("극한직업", 2019, MOVIE, Arrays.asList(actor12, actor13, actor14, actor15, actor16),
                    Arrays.asList(location8));
            createArt("도깨비", 2016, DRAMA, Arrays.asList(actor17, actor18, actor19, actor20, actor21),
                    Arrays.asList(location8, location9));
            createArt("오징어 게임", 2020, DRAMA, Arrays.asList(actor11, actor22, actor23, actor24, actor25),
                    Arrays.asList(location10, location11, location12));
            createArt("지옥의 과제", 2023, ANIMATION, Arrays.asList(actor25), Arrays.asList(location13));
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
