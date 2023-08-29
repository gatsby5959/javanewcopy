package board_JGH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Board {

	private int boardNum; //게시글 번호
	private String boardTitle; // 게시글 제목
	private String boardContent; // 게시글 내용
	private List<String> keyword = new ArrayList<>(); // 혹시나 해서 그냥 만들어 높고 주석

	public Board() {
	}; // 기본생성자

	public Board(int boardNum) { // 이름만 들어가는 생성자
		super();
		this.boardNum = boardNum;
	}

	public Board(int boardNum, String boardTitle) { // 이름 타입 생성자
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
	}
	
	public Board(int boardNum, String boardTitle, String boardContent) { // 이름 타입 생성자
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + "]";
	}

	
	
	
//	public void printOneFoodShopInfoAndAllmenuInfo() {
//		System.out.println("┌─────────────────────────────────────────────┐");
//		System.out.println("│식당명:" + fsName + "\t 종류:" + fsType + "\t\t " );
//		System.out.println("│                                             │ ");
//		if (rating != 0.0) {
//	    System.out.println("│별점 : " + rating +    "                        　           │ "      );
//	    System.out.println("└─────────────────────────────────────────────┘");
//		}
//	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) //동일하게 일치한다면 true 리턴
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if(keyword == null) {
			if(other.keyword != null) {
				return false;
			}
		}else if(keyword.equals(other.keyword)) {
			return false;
		}
		return true;
	}
	
	




}
