package boardJDBC;

import java.util.List;
import java.util.Scanner;

import JDBC.Product;

public class BoardController {

	private Scanner scan;
	private Service svc; //<--인터페이스 생성할꺼임
	private boolean flag;
	
	public BoardController() {
		scan = new Scanner(System.in);
		svc = new BoardServiceImpl();
		flag = true;
		printMenu();
	}
	
	private void printMenu() {
		while(flag) {
			System.out.println("--게시판--");
			System.out.println("1.글쓰기|2.글목록보기|3.글상세보기");
			System.out.println("4.글수정|5.글삭제|6.글종료");
			System.out.println("메뉴선택>>");
			int menu = scan.nextInt();  //연결되는 생성자가 중요합니다.
			
			switch(menu) {
			case 1: register();
				break;
			case 2: list();
				break;
			case 3: detail();
				break;
			case 4: modify();
				break;
			case 5: remove();
				break;
			default:
				flag=false;
				break;
			}
		}
	}//printMenu()
	
	



	private void register() {
		// 상품등록
		System.out.println("글 제목>>");
		scan.nextLine(); //위쪽 공백처리
		String title = scan.nextLine();
		System.out.println("글 작성자>>");

		String writer = scan.nextLine();

		System.out.println("글 내용>>");

		String content = scan.nextLine();

		BoardVO p = new BoardVO(title, writer, content);
		//서비스에게 등록을 요청하는 메서드 작성
		int isOk = svc.register(p);
		//isOk는 디비에서 Insert될때 리턴해 주는 값
		//잘되면 1을 리턴 안되면 0리턴
		System.out.println("등록 "+  ((isOk > 0)? "성공":"실패") );
	}
	
	private void list() {
		// 게시판글 전체 리스트 SELECT * FROM board
		List<BoardVO> list = svc.list();
		//출력
		for(BoardVO bovo : list) {
			System.out.println(bovo);
		}		
	}
	
	
	private void detail() {
		// 게시글 하나의 상세정보 select * from board where bno=?
		System.out.println("게시글 번호>>");
		int bno = scan.nextInt();	//1
		BoardVO bovo = svc.detail(bno);
		System.out.println(bovo);
	}
	
	
	private void modify() {
		//글수정용 VO
//		public BoardVO(int bno, String title, String writer, String content) {
//			super();
//			this.bno = bno;
//			this.title = title;
//			this.writer = writer;
//			this.content = content;
//		}
		// pno에 해당하는 객체를 수정(int bno, String title, String writer, String content)
		System.out.println("수정하려는 글번호 >>");
		
		int bno = scan.nextInt();
		System.out.println("글 제목>>");
		scan.nextLine(); //위쪽 공백처리
		String title = scan.nextLine();
		System.out.println("글 작성자>>");
		String writer = scan.nextLine();
		System.out.println("글 내용(컨탠트)>>");
//		scan.nextLine(); //위쪽 공백처리
		String content = scan.nextLine();
		
		
		BoardVO bovo = new BoardVO(bno,title, writer, content);
		//서비스에게 수정을 요청하는 메서드 작성
		int isOk = svc.update(bovo);
		//isOk는 디비에서 Insert될때 리턴해 주는 값
		//잘되면 1을 리턴 안되면 0리턴
		System.out.println("수정 "+  ((isOk > 0)? "성공":"실패") );
		
	}
	
	
	

	private void remove() {
		// 글 삭제
		System.out.println("삭제할 글 번호>>");
		int bno = scan.nextInt();
		int isOk = svc.delete(bno);
		System.out.println("글 삭제 관련 "+  ((isOk > 0)? "성공":"실패") );
		
	}
	
	
	
}

//class

//create table board(
//bno int auto_increment,
//title varchar(200) not null,
//writer varchar(100) not null,
//content text,
//regdate datetime default now(),
//moddate datetime default now(),
//readcount int default 0,
//primary key(bno)
//);

