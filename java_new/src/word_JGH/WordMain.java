package word_JGH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordMain {
	static ArrayList<Word> arraylist = new ArrayList<Word>();
	
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
//		ArrayList<Book> lit = new ArrayList<>();
		
		WordMain wordmain = new WordMain();
//		ArrayList<Word> arrayWord = new ArrayList<>();
//		System.out.println(arrayWord);
		

		int mainMenu = 0;
		//메인메뉴
	   do{
			System.out.println("1.단어 등록, 2.단어검색 3. 단어수정, 4.단어출력 5.종료");
			Scanner scanner = new Scanner(System.in);
			
			mainMenu = scanner.nextInt();
			System.out.println();//줄바꿈
			
		switch(mainMenu) {
		case 1: {System.out.println("1단어등록");
			registe();
			mainMenu = 0;
		break;
		}
		
		case 2: {System.out.println("2.단어검색"); 
			search();
		break;
		}
		case 3: {System.out.println("3.단어수정입니다"); 
		    update();
		break;}
		case 4: {System.out.println("4 단어 출력입니다.");
			print();
		break;}
		case 5: {System.out.println("5"); break;}
		}
		}while(mainMenu!=5); 
		System.out.println("반복문 끝났음 프로그램 끝났음");
	}
	
	
	
	   public static ArrayList<Word> search() {
		      Scanner scan = new Scanner(System.in);
		      
//		      ArrayList<Word> arraylist = new ArrayList<Word>();
		      Word word = new Word();
		      System.out.println("무엇을 검색할까영?");
		      String searchwd = scan.next();
		      
				for (int i = 0; i < arraylist.size(); i++) {
					if (arraylist.get(i).getWord().equals(searchwd)) {
						System.out.println("같은단어 있음");
						System.out.println(arraylist.get(i));
					}
				}
//				System.out.println(arraylist);
				return arraylist;
		      
	   }
	   
	   
	   public static ArrayList<Word> registe() {
		      Scanner scan = new Scanner(System.in);
		      
//		      ArrayList<Word> arraylist = new ArrayList<Word>();
		      
		      System.out.println("단어 몇개 입력할껀지 숫자 입력");
		      int a = scan.nextInt();
		      
		         for(int i = 0; i < a; i++) {
		         
		         System.out.println("영어단어");
		         String scan3 = scan.next();
		         System.out.println("한글의미");
		         String scan4 = scan.next();
		         
		         Word word = new Word(scan3, scan4);
		         arraylist.add(word);
		      }
		         
		         return arraylist;
		      
	   }
	   
	   
	   public static ArrayList<Word> update(){
		      System.out.println("바꿀 영어 단어 입력");
		      Scanner scan = new Scanner(System.in);
		      
		      
		      Word word = new Word();
		      System.out.println("무엇을 검색할까영?");
		      String searchwd = scan.next();
		      
				for (int i = 0; i < arraylist.size(); i++) {
					if (arraylist.get(i).getWord().equals(searchwd)) {
						System.out.println("같은단어 있음");
						System.out.println("영어단어의 한글 뜻을 무엇으로 바꿀까요? 입력하세요");
						String updatemean = scan.next();
						arraylist.get(i).setMean(updatemean);
					}
				}
				System.out.println(arraylist);
				return arraylist;
	   }
	   
	   
	   public static ArrayList<Word> print(){
//				for (int i = 0; i < arraylist.size(); i++) {
//
//				}
				System.out.println(arraylist);
				return arraylist;
	   }
	   
		public static void printOne() {
			System.out.println("┌─────────────────────────────────────────────┐");
			Word word = new Word();
			word.toString();
			System.out.println(" ───────────────────────────────────────────── ");
		}
	
	
}
