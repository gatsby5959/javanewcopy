package JDBC;

import java.util.List;
import java.util.Scanner;

public class ProductController {

	/* 상품등록, 상품리스트보기, 상품상세보기, 상품수정, 상품삭제
	 * Controller <- Service(interface) <- DAO(interface)
	 * Controller에서 모든 메뉴에 대한 분기처리
	 */
	private Scanner scan;
	private Service svc; //아직 없음230830_17시기준 없음
	private boolean flag; //종료 변수
	
	public ProductController() {
		scan = new Scanner(System.in);
		svc = new ProductServiceImpl(); //service 구현 객체
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("--상품관리프로그램--");
			System.out.println("1.상품등록 | 2.상품목록 | 3.상품검색(상품상세)");
			System.out.println("4.상품수정 | 5.상품삭제 | 6.종료");
			System.out.println("메뉴선택> ");
			int menu = scan.nextInt();
			
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
				flag= false;
				break;
			}
		}
		
	}

	/*
	 * select 리턴이 있음. Product 객체 리턴
	 * insert(등록), update(수정), delete(삭제)
	 * 리턴은 
	 */
	private void remove() {
		// 상품삭제
		System.out.println("상품번호>>");
		int pno = scan.nextInt();
		int isOk = svc.delete(pno);
		System.out.println("상품등록 "+  ((isOk > 0)? "성공":"실패") );
	}

	private void modify() {
		// TODO Auto-generated method stub
		// pno에 해당하는 객체를 수정(pname, price, madeby)
		System.out.println("수정하려는 번호 >>");
		// 상품수정용
		int pno = scan.nextInt();
		System.out.println("상품이름>>");
		scan.nextLine(); //위쪽 공백처리
		String pname = scan.nextLine();
		System.out.println("상품가격>>");
		int price = scan.nextInt();
		System.out.println("상품상세내역madeby>>");
		scan.nextLine(); //위쪽 공백처리
		String madeby = scan.nextLine();
		
		
		Product p = new Product(pno,pname, price, madeby);
		//서비스에게 수정을 요청하는 메서드 작성
		int isOk = svc.update(p);
		//isOk는 디비에서 Insert될때 리턴해 주는 값
		//잘되면 1을 리턴 안되면 0리턴
		System.out.println("상품등록 "+  ((isOk > 0)? "성공":"실패") );
		

		
	}

	private void detail() {
		// TODO Auto-generated method stub
		// 상품 하나의 상세정보 select * from product where pno=?
		System.out.println("상품번호>>");
		int pno = scan.nextInt();	//1
		Product p = svc.detail(pno);
		System.out.println(p);
		
	}

	private void list() {
		// 상품 전체 리스트 select * from product
		List<Product> list = svc.list();
		//출력
		for(Product p : list) {
			System.out.println(p);
		}		
	}

	
	private void register() {
		// 상품등록
		System.out.println("상품이름>>");
		scan.nextLine(); //위쪽 공백처리
		String pname = scan.nextLine();
		System.out.println("상품가격>>");
		int price = scan.nextInt();
		System.out.println("상품상세내역>>");
		scan.nextLine(); //위쪽 공백처리
		String madeby = scan.nextLine();
		Product p = new Product(pname, price, madeby);
		//서비스에게 등록을 요청하는 메서드 작성
		int isOk = svc.register(p);
		//isOk는 디비에서 Insert될때 리턴해 주는 값
		//잘되면 1을 리턴 안되면 0리턴
		System.out.println("상품등록 "+  ((isOk > 0)? "성공":"실패") );
	}
	
	
	
	
} //class






















