package controller;

import java.util.ArrayList;
import model.MoviesDTO;

public class MoviesController {
	private ArrayList<MoviesDTO> list;
	private int nextId;

	public MoviesController() {
		list = new ArrayList<>();
		nextId = 1;

		MoviesDTO default1 = new MoviesDTO();
		default1.setTitleKor("겟 아웃");
		default1.setTitleEng("Get Out");
		default1.setGenre("공포, 스릴러, 미스터리");
		default1.setAgeLimit(15);
		default1.setPlot(
				"[감독] 조던 필 [출연] 다니엘 칼루야, 앨리슨 윌리암스, 브래드리 휘트포드 등\n\n여자 친구와 통화를 한 후, 흑인 남성 안드레이 헤이워드는 늦은 밤 교외를 걷던 도중 \n납치된다. 몇 달 후, 흑인 사진가인 크리스 워싱턴과 그의 백인 여자 친구인 로즈 아미\n티지는 로즈의 부모인 딘과 미시, 그리고 로즈의 동생 제러미를 만나기 위해 여행을 떠\n난다. 로즈의 집에서 모든 사람은 크리스를 편하게 하기 위해 노력하지만 크리스는 흑인 \n정원사와 가정부의 이상한 행동에 불안감을 느낀다. 그날 밤 크리스는 미시에게 뺑소니로 \n죽은 자신의 어머니에 대해 이야기한다. 이야기를 하던 중, 미시는 크리스에게 최면을 \n걸어 마비된 상태를 만들고 크리스의 의식을 공허로 던져버런다. 다음 날 잠에서 깬 크\n리스는 악몽을 꾸었다고 생각하는데...");
		insert(default1);

		MoviesDTO default2 = new MoviesDTO();
		default2.setTitleKor("그랜드 부다페스트 호텔");
		default2.setTitleEng("The Grand Budapest Hotel");
		default2.setGenre("미스터리, 모험, 범죄, 코미디");
		default2.setAgeLimit(15);
		default2.setPlot(
				"[감독] 웨스 앤더슨 [출연] 랄프 파인즈, 틸다 스윈튼, 토니 레볼로리, 시얼샤 로넌 등\n\n1927년 세계대전이 한창이던 어느 날, 세계 최고의 부호 마담 D.가 의문의 살인을 당\n한다. 유력한 용의자로 지목된 사람은 바로 전설적인 호텔 지배인이자 그녀의 연인 ‘구\n스타브’! 구스타브는 누명을 벗기 위해 충실한 로비보이 ‘제로’에게 도움을 청하고, 그 \n사이 구스타브에게 남겨진 마담 D.의 유산을 노리던 그녀의 아들 ‘드미트리’는 무자비한 \n킬러를 고용해 [그랜드 부다페스트 호텔]을 찾게 되는데...");
		insert(default2);

		MoviesDTO default3 = new MoviesDTO();
		default3.setTitleKor("글래디에이터");
		default3.setTitleEng("Gladiator");
		default3.setGenre("액션, 드라마");
		default3.setAgeLimit(15);
		default3.setPlot(
				"[감독] 리들리 스콧 [출연] 러셀 크로우, 호아킨 피닉스, 코니 닐슨 등\n\n절정기의 로마제국은 그 영토가 광대하여 아프리카 사막에서 잉글랜드 북쪽까지 걸쳐 있\n었다. 그 당시 세계는 그 총인구의 1/4이 로마 황제의 지배 하에 있었다. 때는 서기 \n180년, 마르커스 아우렐리우스(Marcus Aurelius) 황제의 12년에 걸친 \n게르마니아(Germania) 정벌이 거의 마무리되던 무렵이었다. 마지막 하나 남은 적의 요\n새만 함락하면 이제 로마 제국은 평화가 온다. 평화로운 '5현제 시대'가 막바지에 이른 \n서기 180년 로마. 어두운 삼림. 수백명의 부대가 숨을 죽이고 서 있다. 마치 폭풍전야\n와 같이. 장군의 신호가 울리고 거대한 함성소리와 함께 하늘에는 불화살, 불타는 점토 \n항아리가 난무하고, 땅위는 수많은 병사들의 피로 물드는데...");
		insert(default3);

		MoviesDTO default4 = new MoviesDTO();
		default4.setTitleKor("나비효과");
		default4.setTitleEng("The Butterfly Effect");
		default4.setGenre("SF, 스릴러, 드라마");
		default4.setAgeLimit(18);
		default4.setPlot(
				"[감독] 에릭 브레스, J. 마키에 그러버 [출연] 애쉬튼 커쳐, 에이미 스마트 등\n\n나비의 날개 짓이 지구 반대편에선 태풍을 일으킬 수도 있다. - 카오스 이론 끔찍한 어\n린 시절의 상처를 지닌 에반. 그에게 남은 것은 기억의 파편들과 상처입은 친구들. 에반\n은 과거의 기억을 되살리기 위해 정신과 치료를 받으며 어릴 적부터 매일매일 꼼꼼하게 \n일기를 쓴다. 대학생이 된 어느 날, 예전의 일기를 꺼내 읽다가 일기장을 통해 시공간 \n이동의 통로를 발견하게 되는 에반. 그것을 통해 과거로 되돌아가 미치도록 지워버리고 \n싶은 기억, 어린 시절의 상처 때문에 스스로 목숨을 끊은 첫사랑 켈리와의 돌이키고 싶\n은 과거, 그리고 사랑하는 친구들에게 닥친 끔찍한 불행들을 고쳐 나간다. 그러나 과거\n를 바꿀수록 더욱 충격적인 현실만이 그를 기다릴 뿐, 현재는 전혀 예상치 못한 파국으\n로 치닫는데 과연 그는 과거를 바꿔 그가 원하는 현재를 이룰 수 있을 것인가? 아니면 \n불행한 현재에 영원히 갇혀버릴 것인가?");
		insert(default4);

		MoviesDTO default5 = new MoviesDTO();
		default5.setTitleKor("라이프 오브 파이");
		default5.setTitleEng("Life of Pi");
		default5.setGenre("모험, 드라마, 판타지");
		default5.setAgeLimit(0);
		default5.setPlot(
				"[감독] 이안 [출연] 수라즈 샤르마, 이르판 칸 등\n\n인도에서 동물원을 운영하던 ‘파이’의 가족은 동물들을 싣고 이민을 떠나는 도중 거센 \n폭풍우를 만나고 배는 침몰한다. 혼자 살아남은 파이는 가까스로 구명보트에 올라 타지만 \n다친 얼룩말과 굶주린 하이에나, 그리고 오랑우탄과 함께 표류하게 된다. 하지만 모두를 \n놀라게 만든 진짜 주인공은 바로 보트 아래에 몸을 숨기고 있던 벵골 호랑이 ‘리처드 파\n커’! 배고픔에 허덕이는 동물들은 서로를 공격하고 결국 파이와 리처드 파커만이 배에 \n남게 되는데... 끝없이 펼쳐진 수평선, 거대하게 빛나는 고래 바다를 빛으로 물들인 해파\n리, 미어캣이 사는 신비의 섬까지, 파이와 리처드 파커 앞에 그 누구도 보지 않고서는 \n믿을 수 없는 놀라운 광경이 펼쳐진다!");
		insert(default5);

		MoviesDTO default6 = new MoviesDTO();
		default6.setTitleKor("럭키");
		default6.setTitleEng("Luck-Key");
		default6.setGenre("코미디, 드라마");
		default6.setAgeLimit(15);
		default6.setPlot(
				"[감독] 이계벽 [출연] 유해진, 이준, 조윤희\n\n냉혹한 킬러 형욱(유해진)은 사건 처리 후 우연히 들른 목욕탕에서 비누를 밟고 넘어져 \n과거의 기억을 잃게 된다. 인기도, 삶의 의욕도 없어 죽기로 결심한 무명배우 재성(이준\n)은 신변 정리를 위해 들른 목욕탕에서 그런 형욱을 보게 되고, 자신과 그의 목욕탕 키\n를 바꿔 도망친다. 이후 형욱은 자신이 재성이라고 생각한 채, 배우로 성공하기 위해 노\n력하는데... 인생에 단 한번 찾아온 초대형 기회! 초특급 반전! 이것이 LUCK.KEY다!");
		insert(default6);

		MoviesDTO default7 = new MoviesDTO();
		default7.setTitleKor("말레나");
		default7.setTitleEng("Malena");
		default7.setGenre("드라마, 로맨스, 전쟁");
		default7.setAgeLimit(18);
		default7.setPlot(
				"[감독] 쥬세페 토르나토레 [출연] 모니카 벨루치, 주세페 술파로 등\n\n2차 대전이 한창인, 햇빛 찬란한 지중해의 작은 마을. 매혹적인 말레나. 걸어갈 때면 \n어린 아이부터 어른까지 모두 그녀를 훑어내린다. 여자들은 시기하여 쑥덕거리기 시작하\n고 곁에는 그녀를 연모하는 열세살 순수한 소년- 레나토가 있다. 남편의 전사 소식과 함\n께 욕망과 질투, 분노의 대상이 된 말레나. 남자들은 아내를 두려워해 일자리를 주지 않\n고, 여자들은 질투에 눈이 멀어 그녀를 모함하기 시작한다. 결국 사람들은 독일군에게까\n지 웃음을 팔아야 했던 말레나를 단죄하고 급기야 그녀는 늦은 밤 쫓기듯 어딘가로 떠나\n게 된다. 소년 레나토만이 진실을 간직한 채 마지막 모습을 애처롭게 지켜볼 뿐이다. 그\n리고 1년 후 전쟁의 상처가 아물어 갈 때쯤 말레나가 다시 마을에 나타난다. 그녀의 곁\n엔 죽은줄 알았던 남편이 불구가 되어 팔짱을 끼고 있었다.");
		insert(default7);

		MoviesDTO default8 = new MoviesDTO();
		default8.setTitleKor("미녀와 야수");
		default8.setTitleEng("Beauty and the Beast");
		default8.setGenre("판타지, 로맨스");
		default8.setAgeLimit(0);
		default8.setPlot(
				"[감독] 크리스토프 갱스 [출연] 레아 세이두, 뱅상 카셀\n\n칠흑같이 어둡고 시리도록 차가운 저주는 야수의 심장을 얼어붙게 만들었다. 예기치 않게 \n찾아온 운명의 밤, 장미 한 송이로 시작된 위험한 거래 그리고 사랑! 순수한 사랑을 갈\n망하는 외로운 야수와 얼어붙은 그의 심장을 녹일 아름다운 벨의 폭풍보다 강렬하고 장미\n보다 매혹적인 초대형 판타지 로맨스가 시작된다!");
		insert(default8);

		MoviesDTO default9 = new MoviesDTO();
		default9.setTitleKor("뷰티풀 마인드");
		default9.setTitleEng("A Beautiful Mind");
		default9.setGenre("드라마");
		default9.setAgeLimit(12);
		default9.setPlot(
				"[감독] 론 하워드 [출연] 러셀 크로우, 에드 해리스, 제니퍼 코넬리 등\n\n40년대 최고의 엘리트들이 모이는 프린스턴 대학원. 시험도 보지 않고 장학생으로 입학\n한 웨스트버지니아 출신의 한 천재가 캠퍼스를 술렁이게 만든다. 너무도 내성적이라 무뚝\n뚝해 보이고, 오만이라 할 정도로 자기 확신에 차 있는 수학과 새내기 존 내쉬. 누구도 \n따라올 수 없는 뛰어난 두뇌와 수려한 용모를 지녔지만 괴짜 천재인 그는 기숙사 유리창\n을 노트 삼아 단 하나의 문제에 매달린다. 바로 자신만의 '오리지날 아이디어'를 찾아내\n는 것. 어느 날 짓궂은 친구들과 함께 들른 술집에서 금발 미녀를 둘러싸고 벌이는 친구\n들의 경쟁을 지켜보던 존 내쉬는 섬광같은 직관으로 '균형이론'의 단서를 발견한다. \n1949년 27쪽 짜리 논문을 발표한 20살의 청년 존 내쉬는 하루 아침에 학계의 스타로, \n제2의 아인슈타인으로 떠오른다. 이후 MIT 교수로 승승장구하던 그는 정부 비밀요원 윌\n리암 파처를 만나 냉전시대 최고의 엘리트들이 그러하듯 소련의 암호 해독 프로젝트에 비\n밀리에 투입된다. 하지만 정작 그를 당황케 한 것은 몇 만개의 암호가 아닌 사랑이란 인\n생의 난제였다. 자신의 수업을 듣던 물리학도 알리샤와 사랑에 빠진 그는 난생처음 굳게 \n닫혔던 마음의 문을 열고, 둘은 행복한 결혼에 골인한다. 알리샤와의 결혼 후에도 존은 \n윌리암과의 프로젝트를 비밀리에 수행한다. 하지만 점점 소련 스파이가 자신을 미행한다\n는 생각에 사로잡히는 존. 목숨의 위협에도 불구하고, 아내에게 끝까지 자신의 일을 비\n밀로 하지만, 자신의 영혼의 빛이 점점 꺼져가고 있음을 깨닫지 못하는데...");
		insert(default9);

		MoviesDTO default10 = new MoviesDTO();
		default10.setTitleKor("300: 제국의 부활");
		default10.setTitleEng("Rise of an Empire");
		default10.setGenre("액션, 전쟁, 드라마, 모험");
		default10.setAgeLimit(18);
		default10.setPlot(
				"[감독] 노암 머로 [출연] 에바 그린, 설리반 스탭플턴, 로드리고 산토로 등\n\nBC 480년 페르시아의 '크세르크세스' 황제는 100만 대군으로 그리스를 향해 진군하고. \n육지에선 스파르타의 왕 '레오니다스' 가 이끄는 300명의 전사들이 싸우는 동안, 같은 \n시기 그리스의 장군 '테미스토클레스' 는 '아르테미시아' 가 이끄는 엄청난 규모의 페르\n시아 해군과 살라미스 해협에서 부딪히게 되는데...");
		insert(default10);

		MoviesDTO default11 = new MoviesDTO();
		default11.setTitleKor("센과 치히로의 행방불명");
		default11.setTitleEng("The Spiriting Away Of Sen And Chihiro");
		default11.setGenre("애니메이션, 판타지, 모험");
		default11.setAgeLimit(0);
		default11.setPlot(
				"[감독] 미야자키 하야오 [출연] 히이라기 루미, 이리노 미유 등\n\n금지된 세계의 문이 열렸다! 이사 가던 날, 수상한 터널을 지나자 인간에게는 금지된 신\n들의 세계로 오게 된 치히로.. 신들의 음식을 먹은 치히로의 부모님은 돼지로 변해버린\n다. “걱정마, 내가 꼭 구해줄게...” 겁에 질린 치히로에게 다가온 정체불명의 소년 하쿠. \n그의 따뜻한 말에 힘을 얻은 치히로는 인간 세계로 돌아가기 위해 사상 초유의 미션을 \n시작하는데...");
		insert(default11);

		MoviesDTO default12 = new MoviesDTO();
		default12.setTitleKor("쇼생크 탈출");
		default12.setTitleEng("The Shawshank Redemption");
		default12.setGenre("드라마, 범죄");
		default12.setAgeLimit(15);
		default12.setPlot(
				"[감독] 프랭크 다라본트 [출연] 팀 로빈스, 모건 프리먼 등\n\n촉망 받던 은행 부지점장 ‘앤디(팀 로빈슨 分)’는 아내와 그 애인을 살해한 혐의로 종\n신형을 받고 쇼생크 교도소에 수감된다. 강력범들이 수감된 이곳에서 재소자들은 짐승 취\n급 당하고, 혹여 간수 눈에 잘못 보였다가는 개죽음 당하기 십상이다. 처음엔 적응 못하\n던 ‘앤디’는 교도소 내 모든 물건을 구해주는 ‘레드(모건 프리먼 分)’와 친해지며 교\n도소 생활에 적응하려 하지만, 악질 재소자에게 걸려 강간까지 당한다. 그러던 어느 날, \n간수장의 세금 면제를 도와주며 간수들의 비공식 회계사로 일하게 되고, 마침내는 소장의 \n검은 돈까지 관리해주게 된다. 덕분에 교도소 내 도서관을 열 수 있게 되었을 무렵, 신\n참내기 ‘토미(길 벨로우스 分)’로부터 ‘앤디’의 무죄를 입증할 기회를 얻지만, 노튼 \n소장은 ‘앤디’를 독방에 가두고 ‘토미’를 무참히 죽여버리는데...");
		insert(default12);

		MoviesDTO default13 = new MoviesDTO();
		default13.setTitleKor("시카고");
		default13.setTitleEng("Chicago");
		default13.setGenre("뮤지컬, 범죄, 드라마");
		default13.setAgeLimit(15);
		default13.setPlot(
				"[감독] 롭 마샬 [출연] 르네 젤위거, 캐서린 제타 존스, 리차드 기어 등\n\n화려한 무대 위 스타가 되길 꿈꾸는 ‘록시’는 우발적인 살인으로 교도소에 수감된다. 그\n곳에서 만난 매혹적인 시카고 최고의 디바 ‘벨마’는 승률 100%의 변호사 ‘빌리’와 무\n죄 석방을 위한 계획을 짜고 있다. ‘빌리’는 법정을 하나의 무대로 탈바꿈시키는 쇼 비\n즈니스의 대가로, 자극적인 사건에 불나방처럼 모여드는 언론의 속성을 교묘하게 이용한\n다. ‘록시’ 또한 ‘빌리’의 흥미를 끌어 자신의 변호를 맡기게 되고, 평범한 가수 지망\n생에 불과했던 ‘록시’는 신문의 1면을 장식하며 일약 스타덤에 오르게 되는데... “그건 \n살인이었지만, 범죄는 아니야” 그들의 쇼는 이미 시작됐다!");
		insert(default13);

		MoviesDTO default14 = new MoviesDTO();
		default14.setTitleKor("알라딘");
		default14.setTitleEng("Aladdin");
		default14.setGenre("애니메이션, 뮤지컬, 판타지, 모험, 로맨스");
		default14.setAgeLimit(0);
		default14.setPlot(
				"[감독] 존 머스커, 론 클레멘츠 [출연] 스콧 와인거, 로빈 윌리엄스, 린다 라킨 등\n\n키우는 원숭이 아부와 함께 살아가는 아그라바의 좀도둑 알라딘은 어느 날 궁궐을 탈출한 \n술탄의 딸 자스민에게 한눈에 반한다. 술탄의 자리를 노리고 있는 사악한 마법사 자파는 \n알라딘을 눈여겨보고 그에게 마법의 램프를 가져다주면 부자로 만들어주겠다고 말한다. \n동굴에 들어가서 램프를 찾던 알라딘은 도중에 동굴이 무너지는 바람에 갇히게 된다. 위\n기에 빠진 알라딘은 램프의 요정 지니와 마법 양탄자의 도움으로 동굴에서 탈출한다. 지\n니의 주인이 된 알라딘은 지니를 램프에서 구해주겠다고 약속하고, 지니의 힘을 빌어 왕\n자로 변신해 자스민에게 청혼하기 위해 아그라바로 돌아온다. 알라딘 때문에 자신의 계획\n이 실패로 돌아갈 위기에 처하자 자파는 알라딘을 붙잡아 바다에 던지는데...");
		insert(default14);

		MoviesDTO default15 = new MoviesDTO();
		default15.setTitleKor("어스");
		default15.setTitleEng("Us");
		default15.setGenre("공포, 스릴러");
		default15.setAgeLimit(15);
		default15.setPlot(
				"[감독] 조던 필 [출연] 루피타 뇽, 윈스턴 듀크, 엘리자베스 모스 등\n\n우리는 누구인가?\n엄마, 아빠, 딸, 아들\n그리고 다시\n엄마, 아빠, 딸, 아들...");
		insert(default15);

		MoviesDTO default16 = new MoviesDTO();
		default16.setTitleKor("에이아이");
		default16.setTitleEng("A.I.");
		default16.setGenre("SF, 드라마, 판타지");
		default16.setAgeLimit(12);
		default16.setPlot(
				"[감독] 스티븐 스필버그 [출연] 할리 조엘 오스먼트, 주드 로, 프란시스 오코너 등\n\n과학문명은 천문학적 속도로 발전하고 있지만 극지방의 해빙으로 도시들은 물에 잠기고 \n천연자원은 고갈되어 가던 미래의 지구. 모든 생활을 감시받고, 먹는 음식조차 통제되는 \n그 세계에서 인간들은 인공지능 (Artificial Intelligence)을 가진 인조인간들의 \n봉사를 받으며 살아간다. 정원가꾸기, 집안 일, 말 동무등 로봇이 인간을 위해 해줄수 \n있는 일은 무한하다. 단 한가지 '사랑'만 빼고... 로봇에게 '감정'을 주입시키는 것은 \n로봇공학 발전의 마지막 관문이자, 논란의 쟁점이기도 했다. 인간들은 로봇을 정교한 가\n재 도구로 여길 뿐, 그 이상의 것을 용납하지 않았다. 그러나 많은 부부가 자식을 가질 \n수 없게 되면서 인간들은 로봇에게서 가재 도구 이상의 가치를 찾게 된다. 어느날 하비 \n박사는 감정이 있는 로봇을 만들겠다고 선언한다. 하비 박사의 계획에 따라 로봇 회사 \nCybertronics Manufacturing을 통해 감정을 가진 최초의 인조인간 데이빗이 탄생\n하고, 데이빗은 Cybertronics사의 한 직원, 헨리 스윈튼의 집에 입양되는데...");
		insert(default16);

		MoviesDTO default17 = new MoviesDTO();
		default17.setTitleKor("위대한 개츠비");
		default17.setTitleEng("The Great Gatsby");
		default17.setGenre("드라마, 로맨스");
		default17.setAgeLimit(15);
		default17.setPlot(
				"[감독] 바즈 루어만 [출연] 레오나르도 디카프리오, 캐리 멀리건, 토비 맥과이어 등\n\n\n1922년 뉴욕 외곽에서 살고 있는 닉은 호화로운 별장에 살고 있는 이웃 개츠비에게 관\n심을 갖게 된다. 제1차 세계대전에 참전한 후 옥스포드에서 공부한 적이 있다는 개츠비\n는 어딘가 비밀이 가득한 의문의 사나이. 이 베일에 싸인 백만장자는 토요일마다 떠들썩\n한 파티를 열어 많은 손님을 초대했다. 파티에 초대 받아 참석한 후 개츠비와 우정을 쌓\n게 된 닉은 자신의 사촌 데이지와 개츠비가 옛 연인 사이였던 것을 알게 된다. 데이지는 \n가난한데다 전쟁터에서도 돌아오지 않는 개츠비를 잊은 채 부유한 톰과 결혼한 상태이다. \n하지만 그녀의 남편 톰은 정비공의 아내와 은밀한 사이였고, 때마침 개츠비와 재회하게 \n된 데이지는 잊혀졌던 사랑의 감정을 되살리는데...");
		insert(default17);

		MoviesDTO default18 = new MoviesDTO();
		default18.setTitleKor("테넷");
		default18.setTitleEng("Tenet");
		default18.setGenre("액션, SF");
		default18.setAgeLimit(12);
		default18.setPlot(
				"[감독] 크리스토퍼 놀란 [출연] 존 워싱턴, 로버트 패틴슨, 엘리자베스 데비키 등\n\n시간의 흐름을 뒤집는 인버전을 통해 현재와 미래를 오가며 세상을 파괴하려는 사토르(케\n네스 브래너)를 막기 위해 투입된 작전의 주도자(존 데이비드 워싱턴). 인버전에 대한 \n정보를 가진 닐(로버트 패틴슨)과 미술품 감정사이자 사토르에 대한 복수심이 가득한 그\n의 아내 캣(엘리자베스 데비키)과 협력해 미래의 공격에 맞서 제3차 세계대전을 막아야 \n한다!");
		insert(default18);
	}

	public void insert(MoviesDTO m) {
		m.setMovieId(nextId++);
		list.add(m);
	}

	public ArrayList<MoviesDTO> selectAll() {
		ArrayList<MoviesDTO> temp = new ArrayList<>();
		for (MoviesDTO m : list) {
			MoviesDTO tempM = new MoviesDTO(m);
			temp.add(tempM);
		}
		return temp;
	}

	public MoviesDTO selectOne(int movieId) {
		for (MoviesDTO m : list) {
			if (m.getMovieId() == movieId) {
				return new MoviesDTO(m);
			}
		}
		return null;
	}

	public void update(MoviesDTO m) {
		int index = list.indexOf(m);
		list.set(index, m);
	}

	public void delete(int movieId) {
		MoviesDTO m = new MoviesDTO();
		m.setMovieId(movieId);
		list.remove(m);
	}

	public ArrayList<MoviesDTO> sortByGenre(String geanre) {
		ArrayList<MoviesDTO> temp = new ArrayList<>();
		for (MoviesDTO m : list) {
			if (m.getGenre().contains(geanre)) {
				temp.add(m);
			}
		}
		return temp;
	}

	public ArrayList<MoviesDTO> sortByAgeLimit(int ageLimit) {
		ArrayList<MoviesDTO> temp = new ArrayList<>();
		for (MoviesDTO m : list) {
			if (m.getAgeLimit() == ageLimit) {
				temp.add(m);
			}
		}
		return temp;
	}
}
