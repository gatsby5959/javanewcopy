package board;

import java.util.Scanner;

public interface BoardInterface {
//정리 메서드 정리용  팀원들을 위해서 한눈에 보여주려고
	void printMenu();
	
	void addBoard(Scanner scan); //1.게시글 등록

	void searchBoard(Scanner scan); // 2.게시글 조회(번호로)

	void modifyBoard(Scanner scan); // 3. 게시글 수정

	void removeBoard(Scanner scan); // 4. 게시글 삭제
	
	void printBoard(); // 5. 게시글 목록보기 printBoard(); 번호와 제목 보기
	
}
