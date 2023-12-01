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
            Actor actor26 = createActor("남궁민", "남자");
            em.persist(actor26);
            Actor actor27 = createActor("신혜선", "여자");
            em.persist(actor27);
            Actor actor28 = createActor("안보현", "남자");
            em.persist(actor28);
            Actor actor29 = createActor("하윤경", "여자");
            em.persist(actor29);
            Actor actor30 = createActor("안동구", "여자");
            em.persist(actor30);
            Actor actor31 = createActor("이채민", "남자");
            em.persist(actor31);
            Actor actor32 = createActor("차청화", "여자");
            em.persist(actor32);
            Actor actor33 = createActor("이보영", "여자");
            em.persist(actor33);
            Actor actor34 = createActor("이요원", "여자");
            em.persist(actor34);
            Actor actor35 = createActor("엄태웅", "남자");
            em.persist(actor35);
            Actor actor36 = createActor("김남길", "남자");
            em.persist(actor36);
            Actor actor37 = createActor("조인성", "남자");
            em.persist(actor37);
            Actor actor38 = createActor("공효진", "여자");
            em.persist(actor38);
            Actor actor39 = createActor("이성경", "여자");
            em.persist(actor39);
            Actor actor40 = createActor("이광수", "남자");
            em.persist(actor40);
            Actor actor41 = createActor("성동일", "남자");
            em.persist(actor41);
            Actor actor42 = createActor("차화연", "여자");
            em.persist(actor42);
            Actor actor43 = createActor("김미경", "여자");
            em.persist(actor43);
            Actor actor44 = createActor("박보영", "여자");
            em.persist(actor44);
            Actor actor45 = createActor("박서준", "남자");
            em.persist(actor45);
            Actor actor46 = createActor("김다미", "여자");
            em.persist(actor46);
            Actor actor47 = createActor("엄정화", "여자");
            em.persist(actor47);
            Actor actor48 = createActor("조정석", "남자");
            em.persist(actor48);
            Actor actor49 = createActor("이덕화", "남자");
            em.persist(actor49);
            Actor actor50 = createActor("김혜수", "여자");
            em.persist(actor50);
            Actor actor51 = createActor("서현", "여자");
            em.persist(actor51);
            Actor actor52 = createActor("강하늘", "남자");
            em.persist(actor52);
            Actor actor53 = createActor("김지석", "남자");
            em.persist(actor53);
            Actor actor54 = createActor("염혜란", "여자");
            em.persist(actor54);
            Actor actor55 = createActor("오정세", "남자");
            em.persist(actor55);

            // 뉴진스
            Actor actor56 = createActor("하니", "여자");
            em.persist(actor56);
            Actor actor57 = createActor("해린", "여자");
            em.persist(actor57);
            Actor actor58 = createActor("민지", "여자");
            em.persist(actor58);
            Actor actor59 = createActor("다니엘", "여자");
            em.persist(actor59);

            //변신로봇 또봇
            Actor actor60 = createActor("차하나", "남자");
            em.persist(actor60);
            Actor actor61 = createActor("차두리", "남자");
            em.persist(actor61);

            // 호텔 델루나
            Actor actor62 = createActor("이지은", "여자");
            em.persist(actor62);
            Actor actor63 = createActor("여진구", "남자");
            em.persist(actor63);
            Actor actor64 = createActor("이도현", "남자");
            em.persist(actor64);
            Actor actor65 = createActor("김수현", "남자");
            em.persist(actor65);


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

            // 영화 및 드라마
            Location location13 = Location.createLoc("비둘기산폭포", "경기도 포천시", "영북면", "대회산리 415-2");
            em.persist(location13);
            Location location14 = Location.createLoc("에코테마파크 대구숲", "대구", "달성군 가창면", "가창로 1003");
            em.persist(location14);
            Location location15 = Location.createLoc("안압지", "인천", "중구", "왕산마리나길 143");
            em.persist(location15);
            Location location16 = Location.createLoc("왕산마리나항", "대구", "달성군 가창면", "가창로 1003");
            em.persist(location16);
            Location location17 = Location.createLoc("군헌갯발체험학습장", "충남 보령시", "신흑동", "해안로 607-5");
            em.persist(location17);
            Location location18 = Location.createLoc("채석강", "전북", "부안군 변산면", "채석강길 32");
            em.persist(location18);
            Location location19 = Location.createLoc("일산호수공원", "경기 고양시", "일산동구", "호수로 595");
            em.persist(location19);
            Location location20 = Location.createLoc("제주섭지코지", "제주도", "서귀포시", "섭지코지로 262");
            em.persist(location20);
            Location location21 = Location.createLoc("다도해해상국립공원", "전남", "완도군 완도읍", "개포로62번길 17-13");
            em.persist(location21);
            Location location22 = Location.createLoc("대한성공회내동교회", "인천광역시", "중구", "개항로45번길 21-32");
            em.persist(location22);
            Location location23 = Location.createLoc("화인산림욕장", "충북", "옥천군 안남면", "안남로 151-66");
            em.persist(location23);
            Location location24 = Location.createLoc("운탄고도", "강원", "영월군 영월읍", "청령포로 126-3");
            em.persist(location24);

            // 동백꽃 필 무렵
            Location location25 = Location.createLoc("구룡포일본인가옥거리", "경북 포항시", "남구", "구룡포읍 구룡포리");
            em.persist(location25);
            Location location26 = Location.createLoc("구룡포항", "경북 포항시", "남구", "구룡포읍 호미로 222-1");
            em.persist(location26);
            Location location27 = Location.createLoc("아라 예술촌", "경북 포항시", "남구", "구룡포읍 용주로7번길 30");
            em.persist(location27);
            Location location28 = Location.createLoc("대보항", "경북 포항시" , "남구", "호미곶면 구만길 279-8");
            em.persist(location28);

            // 뉴진스 - Ditto 뮤비 촬영지
            Location location29 = Location.createLoc("계성중고등학교", "대구" , "중구", "대신동 277-1");
            em.persist(location29);
            Location location30 = Location.createLoc("청라언덕(관광명소)", "대구" , "중구", "달구벌대로 2029");
            em.persist(location30);

            // 변신 로봇 또봇
            Location location31= Location.createLoc("구로경찰서", "서울" , "구로구", "가마산로 235");
            em.persist(location31);

            //호텔 델루나
            Location location32 = Location.createLoc("목포근대역사관 1관", "전남" , "목포시", "영산로29번길 6");
            em.persist(location32);
            Location location33 = Location.createLoc("파라다이스시티(호텔)", "인천" , "중구", "영종해안남로321번길 186");
            em.persist(location33);
            Location location34 = Location.createLoc("망상해변(해수욕장)", "강원특별자치도" , "동해시", "동해대로 6270-10");
            em.persist(location34);
            Location location35 = Location.createLoc("한국보건대학교(폐교,사유지)", "경상북도" , "김천시", "어모면 옥율리 산 27-1");
            em.persist(location35);


            // 작품 생성 및 저장
            createArt("기생충", 2019, MOVIE, Arrays.asList(actor1, actor2, actor3, actor4, actor5, actor6, actor7), Arrays.asList(location1, location2, location3, location4, location5, location6));
            createArt("모래시계", 2020, DRAMA, Arrays.asList(actor8, actor9, actor10, actor11), Arrays.asList(location7));
            createArt("극한직업", 2019, MOVIE, Arrays.asList(actor12, actor13, actor14, actor15, actor16), Arrays.asList(location8));
            createArt("도깨비", 2016, DRAMA, Arrays.asList(actor17, actor18, actor19, actor20, actor21), Arrays.asList(location8, location9));
            createArt("오징어 게임", 2020, DRAMA, Arrays.asList(actor11, actor22, actor23, actor24, actor25), Arrays.asList(location10, location11, location12));
            createArt("괜찮아 사랑이야", 2014, DRAMA, Arrays.asList(actor37, actor38, actor39, actor40, actor41), Arrays.asList(location13, location14));
            createArt("선덕여왕", 2023, DRAMA, Arrays.asList(actor9, actor34), Arrays.asList(location15));
            createArt("뺑반", 2023, MOVIE, Arrays.asList(actor38, actor48), Arrays.asList(location16));
            createArt("질투의 화신", 2023, DRAMA, Arrays.asList(actor38, actor48), Arrays.asList(location17));
            createArt("이번 생도 잘 부탁해", 2023, DRAMA, Arrays.asList(actor27, actor28, actor29, actor30), Arrays.asList(location18));
            createArt("대행사", 2023, DRAMA, Arrays.asList(actor33, actor43), Arrays.asList(location19));
            createArt("마녀", 2023, MOVIE, Arrays.asList(actor4, actor46), Arrays.asList(location20));
            createArt("밀수", 2023, MOVIE, Arrays.asList(actor37, actor50), Arrays.asList(location21));
            createArt("닥터 차정숙", 2023, DRAMA, Arrays.asList(actor47, actor43), Arrays.asList(location22));
            createArt("도적 : 칼의 소리", 2023, MOVIE, Arrays.asList(actor36, actor51), Arrays.asList(location23));
            createArt("천원짜리 변호사", 2022, DRAMA, Arrays.asList(actor26, actor49), Arrays.asList(location24));
            createArt("동백꽃 필 무렵", 2019, DRAMA, Arrays.asList(actor38, actor52, actor53, actor54, actor55), Arrays.asList(location25, location26, location27, location28));
            createArt("Ditto", 2022, MUSIC, Arrays.asList(actor56, actor57, actor58, actor59), Arrays.asList(location29, location30));
            createArt("변신자동차 또봇x", 2010, ANIMATION, Arrays.asList(actor60, actor61), Arrays.asList(location31));
            createArt("호텔 델루나", 2019, DRAMA, Arrays.asList(actor62, actor63, actor64, actor65), Arrays.asList(location32, location33, location34, location35));
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
