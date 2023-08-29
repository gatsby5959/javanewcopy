package board_JGH;

import java.awt.image.BufferedImage;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.image.BufferedImage;
import java.awt.FlowLayout;


public class BoardManager implements I_BoardInterface {


	List<Board> arraylist_Board = new ArrayList<>();
 
	public void firstautoadd() {
		// 메인에서 처음 그냥 넣을때 쓰려고 한것
		Board bo1 = new Board(1, "하나", "첫번째 글내용 생성자테스트 내용입니다 동해물과 백두산이 마르고 끝");
		arraylist_Board.add(bo1);
		Board bo2 = new Board(2, "둘", "두번째 글내용 생성자테스트 내용 가을하늘 공활한데 높고 구름없이 끝!");
		arraylist_Board.add(bo2);		
	}

	
	int num = 3;
	int num2 = 0;
	@Override
	public void addBoard(Scanner scan) {
		// TODO Auto-generated method stub

		System.out.println("추가하실 게시글 제목을 입력해주세요");
		scan.nextLine();  // nextInt() 개행문자 소비
		String boardTitle = scan.nextLine();
		System.out.println("추가하실 게시글의 내용을 입력해주세요");
//		scan.nextLine();  // nextInt() 개행문자 소비
		String boardContent = scan.nextLine();

		
		Board board = new Board(num+num2, boardTitle, boardContent);
		
		arraylist_Board.add(board);
		num2++;
		
	}

	@Override
	public void searchBoard(Scanner scan) {
		// 제목 글 찾기
		System.out.println("찾으실 제목을 입력해주세요");
		scan.nextLine();
		
		String search_title_Nm = scan.nextLine();
		int index = -1;
		
		for (int i = 0; i < arraylist_Board.size(); i++) {
//			System.out.println("찾기 시작");
			if (arraylist_Board.get(i).getBoardTitle().equals(search_title_Nm)) {
				System.out.println("게시글 제목을 찾았습니다.");
				index = i;
				
				String content = arraylist_Board.get(i).getBoardContent();
				int boardnum = arraylist_Board.get(i).getBoardNum();
				System.out.println("게시글내용: " +content);
				System.out.println("게시글번호: "+boardnum);
			}
		}
	
		return;
		
	}

	@Override
	public void modifyBoard(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("수정할 게시글의 번호는 어떻게 되나요?");
		String search_title_Nm = scan.next();
		int num = Integer.parseInt(search_title_Nm);
		
		
		System.out.println("수정하실 게시글 제목을 입력해주세요");
		scan.nextLine();  // nextInt() 다음의 개행문자를 소비? 몰라 그냥 넣엇음 안그럼 지나침
		String boardTitle = scan.nextLine();
		System.out.println("수정하실 게시글의 내용을 입력해주세요");
		String boardContent = scan.nextLine();
		
		arraylist_Board.remove(num-1);
		Board board = new Board(num, boardTitle, boardContent);
		
		arraylist_Board.add(board);
		//위에서 get한것 처럼 반대로 set하면 될듯함... 근데 이미 여기까지 왔음....
		
	}

	@Override
	public void removeBoard(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("삭제할 게시글의 번호는 어떻게 되나요?");
		String d_title_No = scan.next();
		int num = Integer.parseInt(d_title_No);
	
		for (int i = 0; i < arraylist_Board.size(); i++) {

			if (num  == arraylist_Board.get(i).getBoardNum()) {
									
				System.out.println("게시글번호 "+num+"번을 지우겠습니다.");
				arraylist_Board.remove(i);

			}
		}
	
		System.out.println("게시글번호"+(num)+ "번 삭제완료");
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		System.out.println("|---------------입력된 모든 정보----------------|");
		for (int i = 0; i < arraylist_Board.size(); i++) {
		
			int num = (arraylist_Board.get(i).getBoardNum());
			System.out.println("글번호 "+ num);
			arraylist_Board.get(i).getBoardTitle();
			
			String tit = (arraylist_Board.get(i).getBoardTitle());
			System.out.println(tit);
			
			String con = (arraylist_Board.get(i).getBoardContent());
			arraylist_Board.get(i).getBoardContent();
			System.out.println(con);
			
			System.out.println("전체 프린트 완료");
			System.out.println("|-------------------------------------------|");

		}
		
	}
	   
}
