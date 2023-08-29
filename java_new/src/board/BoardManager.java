package board;

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


public class BoardManager implements BoardInterface {

	ArrayList<Board> list = new ArrayList<>();

	@Override
	public void addBoard(Scanner scan) {
		System.out.println("--게시글 등록--");
		System.out.println("제목:");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.println("작성자:");
		String writer = scan.next();
		System.out.println("내용:");
		scan.nextLine();
		String content = scan.nextLine();

		Board b = new Board(title, content, writer);
		list.add(b);
	}

	@Override
	public void searchBoard(Scanner scan) {
		System.out.println("조회할 번호 입력>");
		int num = scan.nextInt();
		//객체가 없다면 -1 리턴
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			//해당 게시글이 있다면...
			Board tmpBoard = list.get(index);
			tmpBoard.print();
			return;
		}else {
			System.out.println("일치하는 게시글이 없습니다.");
		}
		
	}

	@Override
	public void modifyBoard(Scanner scan) {
		System.out.println("수정할 번호를 입력해주세요>");
		int num = scan.nextInt();
		//indexOf(Object) : list에서 object와 같은 객체가 있는 위치를 반환
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			//수정작업
			System.out.println("제목:");
			scan.nextLine();
			String title = scan.nextLine();
			System.out.println("내용:");
//			scan.nextLine();
			String content = scan.nextLine();
			
			Board b = list.get(index);	//검색해 놓은 번지의 객체
			b.setTitle(title);
			b.setContents(content);
			System.out.println("수정완료");
			
		}else {
			System.out.println("게시글이 존재하지 않습니다.");
		}
		
		
	}

	@Override
	public void removeBoard(Scanner scan) {
		System.out.println("삭제할 번호를 입력해주세요>");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		
		if(index != -1) {//값이 있따면
			list.remove(index);
			System.out.println("게시글이 삭제되었습니다.");
		}else {
			System.out.println("게시글이 존재하지 않습니다.");
		}
		
	}

	@Override
	public void printBoard() {
		for(Board b: list) {
			System.out.println(b);
		}
		
	}

	@Override
	public void printMenu() {
		System.out.println("--게시판--");
		System.out.println("1.등록 | 2.조회 | 3.수정");
		System.out.println("4.삭제 | 5.목록 | 6.종료");
		System.out.println("메뉴입력 >");
		
	}


	   
}
