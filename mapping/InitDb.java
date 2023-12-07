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

        public void dbInit() {
            System.out.println("Init" + this.getClass());

            Genre MOVIE = Genre.createGenre("MOVIE");
            em.persist(MOVIE);
            Genre DRAMA = Genre.createGenre("DRAMA");
            em.persist(DRAMA);
            Genre BOOK = Genre.createGenre("BOOK");
            em.persist(BOOK);
            Genre ANIMATION = Genre.createGenre("ANIMATION");
            em.persist(ANIMATION);
            Genre MUSIC = Genre.createGenre("MUSIC");
            em.persist(MUSIC);


            // 배우 생성 및 저장----------------------------------
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

            // 치즈 인 더 트랩 BOOK
            Actor actor66 = createActor("홍설", "여자");
            em.persist(actor66);
            Actor actor67 = createActor("유정", "남자");
            em.persist(actor67);
            Actor actor68 = createActor("백인호", "남자");
            em.persist(actor68);
            Actor actor69 = createActor("김상철", "남자");
            em.persist(actor69);
            Actor actor70 = createActor("장보라", "여자");
            em.persist(actor70);

            // 12.07 추가
            Actor actor71 = createActor("이재욱", "남자");
            em.persist(actor71);
            Actor actor72 = createActor("정소민", "여자");
            em.persist(actor72);
            Actor actor73 = createActor("황민현", "남자");
            em.persist(actor73);
            Actor actor74 = createActor("유준상", "남자");
            em.persist(actor74);
            Actor actor75 = createActor("신승호", "남자");
            em.persist(actor75);
            Actor actor76 = createActor("오나라", "여자");
            em.persist(actor76);
            Actor actor77 = createActor("조재윤", "남자");
            em.persist(actor77);
            Actor actor78 = createActor("유인수", "남자");
            em.persist(actor78);
            Actor actor79 = createActor("아린", "여자");
            em.persist(actor79);

            Actor actor80 = createActor("조보아", "여자");
            em.persist(actor80);
            Actor actor81 = createActor("로운", "남자");
            em.persist(actor81);
            Actor actor82 = createActor("하준", "남자");
            em.persist(actor82);
            Actor actor83 = createActor("유라", "여자");
            em.persist(actor83);

            Actor actor84 = createActor("유재명", "남자");
            em.persist(actor84);
            Actor actor85 = createActor("이현욱", "남자");
            em.persist(actor85);
            Actor actor86 = createActor("이호정", "여자");
            em.persist(actor86);

            // 트와이스
            Actor actor87 = createActor("사나", "여자");
            em.persist(actor87);
            Actor actor88 = createActor("모모", "여자");
            em.persist(actor88);
            Actor actor89 = createActor("쯔위", "여자");
            em.persist(actor89);
            Actor actor90 = createActor("나연", "여자");
            em.persist(actor90);
            Actor actor91 = createActor("지효", "여자");
            em.persist(actor91);
            Actor actor92 = createActor("채영", "여자");
            em.persist(actor92);
            Actor actor93 = createActor("미나", "여자");
            em.persist(actor93);
            Actor actor94 = createActor("정연", "여자");
            em.persist(actor94);
            Actor actor95 = createActor("다현", "여자");
            em.persist(actor95);

            // 20세기 소년소녀
            Actor actor96 = createActor("한예슬", "여자");
            em.persist(actor96);
            Actor actor97 = createActor("이상우", "남자");
            em.persist(actor97);
            Actor actor98 = createActor("류현경", "여자");
            em.persist(actor98);
            Actor actor99 = createActor("이상희", "여자");
            em.persist(actor99);
            Actor actor100 = createActor("오상진", "남자");
            em.persist(actor100);

            // 닥터 프로스트
            Actor actor130 = createActor("프로스트", "남자");
            em.persist(actor130);
            Actor actor131 = createActor("윤성아", "여자");
            em.persist(actor131);
            Actor actor132 = createActor("문성현", "남자");
            em.persist(actor132);
            Actor actor133 = createActor("천상원", "남자");
            em.persist(actor133);
            Actor actor134 = createActor("송선", "여자");
            em.persist(actor134);

            // 인소의 법칙
            Actor actor135 = createActor("함단이", "여자");
            em.persist(actor135);
            Actor actor136 = createActor("반여령", "여자");
            em.persist(actor136);
            Actor actor137 = createActor("반여단", "남자");
            em.persist(actor137);
            Actor actor138 = createActor("권은형", "남자");
            em.persist(actor138);
            Actor actor139 = createActor("우주인", "남자");
            em.persist(actor139);
            Actor actor140 = createActor("유천영", "남자");
            em.persist(actor140);
            Actor actor141 = createActor("이루다", "남자");
            em.persist(actor141);


            // 장소 생성 및 저장----------------------------------
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
            Location location28 = Location.createLoc("대보항", "경북 포항시", "남구", "호미곶면 구만길 279-8");
            em.persist(location28);

            // 뉴진스 - Ditto 뮤비 촬영지
            Location location29 = Location.createLoc("계성중고등학교", "대구", "중구", "대신동 277-1");
            em.persist(location29);
            Location location30 = Location.createLoc("청라언덕(관광명소)", "대구", "중구", "달구벌대로 2029");
            em.persist(location30);

            // 변신 로봇 또봇
            Location location31 = Location.createLoc("구로경찰서", "서울", "구로구", "가마산로 235");
            em.persist(location31);

            //호텔 델루나
            Location location32 = Location.createLoc("목포근대역사관 1관", "전남", "목포시", "영산로29번길 6");
            em.persist(location32);
            Location location33 = Location.createLoc("파라다이스시티(호텔)", "인천", "중구", "영종해안남로321번길 186");
            em.persist(location33);
            Location location34 = Location.createLoc("망상해변(해수욕장)", "강원특별자치도", "동해시", "동해대로 6270-10");
            em.persist(location34);
            Location location35 = Location.createLoc("한국보건대학교(폐교,사유지)", "경상북도", "김천시", "어모면 옥율리 산 27-1");
            em.persist(location35);

            //BOOK
            Location location36 = Location.createLoc("건국대학교 박물관", "서울특별시", "광진시", "아차산로 263");
            em.persist(location36);
            Location location37 = Location.createLoc("건국대학교 학생회관", "서울특별시", "광진구 화양동", "능동로 120");
            em.persist(location37);
            Location location38 = Location.createLoc("문광저수지 은행나무길", "충북", "괴산군 문광면", "양곡리 55");
            em.persist(location38);
            Location location39 = Location.createLoc("영동 금강둘레길", "충북", "영동군 양산면", "봉곡리");
            em.persist(location39);

            // 12.07 추가
            Location location40 = Location.createLoc("문경새재 오픈 세트장", "경상북도 문경시", "문경읍", "상초리 84-2");
            em.persist(location40);
            Location location41 = Location.createLoc("용안굴", "제주특별자치도 제주시", "애월읍", "무수천3경");
            em.persist(location41);
            Location location42 = Location.createLoc("체오름(사유지)", "제주특별자치도 제주시", "구좌읍", "송당리 산62");
            em.persist(location42);
            Location location43 = Location.createLoc("부여 성흥산성(사랑나무)", "충청남도 부여시", "부여군", "임천면 군사리 산7-10");
            em.persist(location43);
            Location location44 = Location.createLoc("가산수피아", "경상북도", "칠곡군", "가산면 학하들안2길 105");
            em.persist(location44);
            Location location45 = Location.createLoc("세연정(판석보)", "전라남도", "완도군", "가보길면 부황길 57");
            em.persist(location45);
            Location location46 = Location.createLoc("안동 군자마을 한옥스테이", "경상북도", "안동시", "와룡면 오천리 산27-1");
            em.persist(location46);
            Location location47 = Location.createLoc("농월정국민관광지", "경상남도", "함양군", "안의면 월림리 1472");
            em.persist(location47);
            Location location48 = Location.createLoc("백운동 원림", "전라남도", "강진군", "성전면 월하리 546번지");
            em.persist(location48);
            Location location49 = Location.createLoc("명옥헌 원림", "전라남도", "담양군", "고서면 후산길 103");
            em.persist(location49);
            Location location50 = Location.createLoc("나주영상테마파크", "전라남도", "나주시", "공산면 덕음로 450");
            em.persist(location50);
            Location location51 = Location.createLoc("드라마 《바람의 화원》 촬영지", "충청북도", "괴산군", "청천면 송문로덕평1길 44-18");
            em.persist(location51);
            Location location52 = Location.createLoc("운보의집운보미술관", "충청북도", "청주시", "청원구 내수읍 형동2길 92-41");
            em.persist(location52);
            Location location53 = Location.createLoc("설악산 권금성", "강원도", "속초시", "설악동 산41");
            em.persist(location53);
            Location location54 = Location.createLoc("함안 말이산 고본군", "경상남도", "함안군", "가야읍 고분길 153-31");
            em.persist(location54);
            Location location55 = Location.createLoc("수옥폭포", "충청북도", "괴산군", "연풍면 원풍리");
            em.persist(location55);
            Location location56 = Location.createLoc("드라마 《최참판댁》 촬영지", "경상남도", "하동군", "악양면 평사리길 66-7");
            em.persist(location56);
            Location location57 = Location.createLoc("계명대학교 성서캠퍼스 계명한학촌", "대구광역시 달서구", "호산동", "산2-1");
            em.persist(location57);
            Location location58 = Location.createLoc("문경 선유동 계곡", "경상북도", "문경시", "가은읍 완장리");
            em.persist(location58);
            Location location59 = Location.createLoc("고석정", "강원도", "철원군", "동송읍 태봉로 1825");
            em.persist(location59);
            Location location60 = Location.createLoc("아침고요수목원 서화연", "경기도", "가평군", "상면 수목원로 497");
            em.persist(location60);
            Location location61 = Location.createLoc("몰운대 서화연", "강원도", "정선군", "화암면 몰운리 산43");
            em.persist(location61);
            Location location62 = Location.createLoc("용머리해안", "제주특별자치도", "서귀포시", "안덕면 사계리 112-3");
            em.persist(location62);
            Location location63 = Location.createLoc("해식동굴", "충청남도", "태안군", "소원면 파도리 산 203");
            em.persist(location63);
            Location location64 = Location.createLoc("포천 아트밸리 천주호", "경기도", "포천시", "신북면 아트밸리로 234");
            em.persist(location64);

            Location location65 = Location.createLoc("포항시청", "경상북도", "포항시", "남구 시청로 1");
            em.persist(location65);
            Location location66 = Location.createLoc("스페이스워크", "경상북도", "포항시", "북구 두호동 산8");
            em.persist(location66);

            Location location67 = Location.createLoc("합천 영상테마파크", "경상남도", "합천군", "용주면 합천호수로 757");
            em.persist(location67);
            Location location68 = Location.createLoc("철원 역사문화공원", "강원도", "철원군", "철원읍 금강산로 262");
            em.persist(location68);
            Location location69 = Location.createLoc("영화 웰컴 투 동막골 촬영 세트장", "강원도", "평창군", "미탄면 동막골길 117");
            em.persist(location69);
            Location location70 = Location.createLoc("해양드라마세트장", "경상남도", "창원시", "마산합포구 구산면 석곡리 산183-2");
            em.persist(location70);
            Location location71 = Location.createLoc("황매산군립공원", "경상남도", "합천군", "가회면 황매산공원길 331");
            em.persist(location71);
            Location location72 = Location.createLoc("내장산국립공원 우화정", "전라북도", "정읍시", "내장동 산231");
            em.persist(location72);
            Location location73 = Location.createLoc("익산 교도소 세트장", "전라북도", "익산시", "성당면 함낭로 207");
            em.persist(location73);
            Location location74 = Location.createLoc("새만금 방조제", "전라북도", "익산시", "옥도면 신시도리 257");
            em.persist(location74);
            Location location75 = Location.createLoc("선샤인스튜디오", "충청남도", "논산시", "연무읍 봉황로 90");
            em.persist(location75);

            // 트와이스 SIGNAL 뮤직비디오
            Location location76 = Location.createLoc("금오름(산)", "제주특별자치도", "제주시", "한림읍 금악리 산1-1");
            em.persist(location76);

            // 더미 데이터
            Location location77 = Location.createLoc("주왕산국립공원(산)", "경북", "청송군", "주왕산면 상의리 산 6-1");
            em.persist(location77);
            Location location78 = Location.createLoc("영덕해맞이공원", "경북", "영덕군", "영덕읍 창포리 산 5-5");
            em.persist(location78);
            Location location79 = Location.createLoc("슈퍼마켓", "경북", "영덕군", "영덕읍 시걸길 198-2");
            em.persist(location79);

            // 20세기 소년소녀
            Location location80 = Location.createLoc("더백푸드트럭", "서울특별시", "용산구", "신흥로20길 45-1");
            em.persist(location80);
            Location location81 = Location.createLoc("회현시민아파트", "서울특별시", "중구", "퇴계로8길 101");
            em.persist(location81);
            Location location82 = Location.createLoc("인천국제공항", "인천광역시", "중구", "공항로 272");
            em.persist(location82);

            //닥터프로스트
            Location location130 = Location.createLoc("서울시립대학교", "서울특별시" , "동대문구", "서울시립대로 163");
            em.persist(location130);
            Location location131 = Location.createLoc("서강대학교", "서울특별시" , "마포구", "백범로 35");
            em.persist(location131);
            Location location132 = Location.createLoc("로케이션어스(드라마 세트장)", "파주시" , "탄현면", "검산로 423-71");
            em.persist(location132);

            //인소의 법칙
            Location location134 = Location.createLoc("서현고등학교", "성남시" , "분당구", "분당로 87");
            em.persist(location134);
            Location location135 = Location.createLoc("에버랜드", "용인시" , "처인구 포곡읍", "에버랜드로 199");
            em.persist(location135);
            Location location136 = Location.createLoc("가평전원별장펜션", "경기도" , "가평군 북면", "백둔로650번길 62");
            em.persist(location136);
            Location location137 = Location.createLoc("임피리얼팰리스 부티크호텔", "서울특별시" , "용산구", "이태원로 221");
            em.persist(location137);

            // 작품 생성 및 저장----------------------------------
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
            createArt("도적: 칼의 소리", 2023, MOVIE, Arrays.asList(actor36, actor51, actor84, actor85, actor86),
                    Arrays.asList(location23, location40, location67, location68, location69, location70, location71, location72, location73, location74, location75));
            createArt("천원짜리 변호사", 2022, DRAMA, Arrays.asList(actor26, actor49), Arrays.asList(location24));
            createArt("동백꽃 필 무렵", 2019, DRAMA, Arrays.asList(actor38, actor52, actor53, actor54, actor55), Arrays.asList(location25, location26, location27, location28));
            createArt("Ditto", 2022, MUSIC, Arrays.asList(actor56, actor57, actor58, actor59), Arrays.asList(location29, location30));
            createArt("변신자동차 또봇x", 2010, ANIMATION, Arrays.asList(actor60, actor61), Arrays.asList(location31));
            createArt("호텔 델루나", 2019, DRAMA, Arrays.asList(actor62, actor63, actor64, actor65), Arrays.asList(location32, location33, location34, location35));
            createArt("치즈 인 더 트랩", 2018, BOOK, Arrays.asList(actor66, actor67, actor68, actor69, actor70), Arrays.asList(location36, location37, location38, location39));
            // 12.07 추가
            createArt("환혼", 2022, DRAMA, Arrays.asList(actor71, actor72, actor73, actor74, actor75, actor76, actor77, actor78, actor79),
                    Arrays.asList(location40, location41, location42, location43, location44, location45, location46, location47, location48, location49, location50, location51,
                            location52, location53, location54, location55, location56, location57, location58, location59, location60, location61, location62, location63, location64));
            createArt("이 연애는 불가항력", 2023, DRAMA, Arrays.asList(actor80, actor81, actor82, actor83), Arrays.asList(location65, location66));
            createArt("SIGNAL", 2017, MUSIC, Arrays.asList(actor87, actor88, actor89, actor90, actor91, actor92, actor93, actor94, actor95), Arrays.asList(location76));
            createArt("20세기 소년소녀", 2017, DRAMA, Arrays.asList(actor53, actor96, actor97, actor98, actor99, actor100), Arrays.asList(location80, location81, location82));
            createArt("닥터 프로스트", 2011,BOOK, Arrays.asList(actor130,actor131,actor132), Arrays.asList(location36));
            createArt("인소의 법칙", 2015,BOOK, Arrays.asList(actor134,actor135,actor136,actor137), Arrays.asList(location36));

            // 더미 데이터
            createArt("등산(더미)", 1999, MOVIE, Arrays.asList(actor13, actor20, actor23, actor55, actor70, actor72, actor74, actor80), Arrays.asList(location77));
            createArt("해맞이(더미)", 1999, BOOK, Arrays.asList(actor14, actor22, actor24, actor55, actor78, actor79, actor80, actor81), Arrays.asList(location78));
            createArt("가게(더미)", 1999, DRAMA, Arrays.asList(actor15, actor23, actor25, actor35, actor45, actor55, actor65, actor71), Arrays.asList(location79));
        }


        // 로직----------------------------------
        // 작품생성 : 작품명, 연도, 장르, 배우들, 촬영장소들
        private void createArt(String name, Integer year, Genre genre, List<Actor> actors, List<Location> locations) {
            List<Filmed> filmedList = locations.stream()
                    .map(Filmed::createFilmed)
                    .collect(Collectors.toList());
            filmedList.forEach(em::persist);

            Art art = Art.createArt(name, year, filmedList, actors, genre);
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
