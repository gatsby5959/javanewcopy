package board_JGH;


import java.util.Scanner;

import word.Wordmanager;
public class BoardMain {

	  public static void main(String[] args) {
		  	BoardManager boardMana = new BoardManager();
		  	boardMana.firstautoadd();

			int menu = -1;
			Scanner scan = new Scanner(System.in);

			do {
				System.out.println("  \n"
						+ "1. 게시글 등록, 2. 게시글 조회\n"
						+ "3. 게시글 수정,  4. 게시글 삭제\n"
						+ "5. 게시글 목록 보기   6. 종료");
				System.out.println("menu > ");
				menu = scan.nextInt();
				
				try {
					switch(menu) {
					case 1 : boardMana.addBoard(scan); break;
					case 2 : boardMana.searchBoard(scan); break;
					case 3 : boardMana.modifyBoard(scan); break;
					case 4 : boardMana.removeBoard(scan); break;
					case 5 : boardMana.printBoard(); break;
					case 6 : System.out.println("프로그램 종료"); break;
					default:
						System.out.println("잘못된 메뉴");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} while (menu != 6);
//			System.out.println("프로그램 종료");
			scan.close();

		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
		  	
//	        while (true) {
//
//	            Scanner scanner = new Scanner(System.in);
//	            int choice = scanner.nextInt();
//	            
//	            
//	            if (choice == 1) {
//	            	// 음식점 추가 메서드
//	            	fmr.FoodShopAdd(scanner);
//	            	fmr.printAllFoodShopInfoAndAllmenuInfo();
//	            } else if (choice == 2) {
//	                // 음식점 찾기 메서드
//	            	fmr.FoodShopSearch(scanner);       	
//	            } else if (choice == 3) {
//	                // 음식점 유형 검색 메서드
//	            	fmr.FoodShopType(scanner);
//	            } else if (choice == 4) {
//	                // 음식점 후기 추가 메서드 호출
//	            	fmr.FoodShopReview(scanner);
//	            } else if (choice == 5) {
//	                // AI 추천 메서드 호출
//	            	fmr.FoodShopAI();
//	            	
//	            } else if (choice == 6) {
//	                // AI 추천 메서드 호출
//	            	fmr.FoodShopkeyword(scanner);	
//	            	
//	            } else if (choice == 7) {
//	                fmr.foodPriceSearch(scanner);
//	                
//	             
//	            } else if (choice == 8) {
//	                System.out.println("Exiting program...");
//	                  
//	            } else if(choice == 99) {
//	            	fmr.printAllFoodShopInfoAndAllmenuInfo();
//	            	
//	            }
//	            
//	            else {
//	                System.out.println("Invalid choice. Please choose a valid option.");
//	            }
//	        }
		  	
		  	
		  	
		  	
	    }
	  

}

