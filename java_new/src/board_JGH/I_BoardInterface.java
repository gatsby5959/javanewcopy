package board_JGH;

import java.util.Scanner;

public interface I_BoardInterface {

	void addBoard(Scanner scan); //1.게시글 등록

	void searchBoard(Scanner scan); // 2.게시글 조회(번호로)

	void modifyBoard(Scanner scan); // 3. 게시글 수정

	void removeBoard(Scanner scan); // 4. 게시글 삭제
	
	void printBoard(); // 5. 게시글 목록보기 printBoard(); 번호와 제목 보기
	
}
