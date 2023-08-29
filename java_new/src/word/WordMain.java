package word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		/*
		 *  단어장 프로그램 작성
		 *  word 클래스 생성
		 *  단어, 의미
		 *  메뉴
		 *  1. 단어 등록, 2. 단어검색 3. 단어수정, 4.단어출력 5.종료
		 *  
		 *  ArrayList<Word>
		 *  
		 *  	//z클래스를 담는 리스트로 값을 하나씩 애드
		 */
		int menu = -1;
		Scanner scan = new Scanner(System.in);
		Wordmanager wm = new Wordmanager();
		do {
			System.out.println("1. 단어 등록, 2. 단어검색 3. 단어수정,  4.단어출력   5.파일출력    6.종료");
			System.out.println("menu > ");
			menu = scan.nextInt();
			
			try {
				switch(menu) {
				case 1 : wm.insertWord(scan); break;
				case 2 : wm.searchWord(scan); break;
				case 3 : wm.modifyWord(scan); break;
				case 4 : wm.printWord(); break;
				case 5 : wm.filePrint(); break;
				case 6 : System.out.println("프로그램 종료"); break;
				default:
					System.out.println("잘못된 메뉴");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} while (menu != 6);
//		System.out.println("프로그램 종료");
		scan.close();
	
		
	}
	
}
