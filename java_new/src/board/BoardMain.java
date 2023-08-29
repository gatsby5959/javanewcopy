package board;


import java.util.Scanner;

import word.Wordmanager;
public class BoardMain {

	  public static void main(String[] args) {
	  BoardManager bm = new BoardManager();
	  Scanner scan = new Scanner(System.in);
	  int menu = -1;
	  
	  do {
		bm.printMenu();
		menu = scan.nextInt();
		switch(menu) {
		case 1: bm.addBoard(scan); break;
		case 2: bm.searchBoard(scan); break;
		case 3: bm.modifyBoard(scan);  break;
		case 4: bm.removeBoard(scan);  break;
		case 5: bm.printBoard();  break;
		case 6: 
			System.out.println("게시판 종료~!!!");
			break;
			default:
				System.out.println("잘못된 메뉴~!!!");
		}
	  }while(menu != 6);
	  
	  
	  
	  }
	  

}

