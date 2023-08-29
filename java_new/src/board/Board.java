package board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class Board {

	/*
	 * 번호, 제목, 내용, 작성자, 작성일
	 * 번호, 작성일
	 * 번호가 일치하면 같은 객체로 인정 equals
	 */
	private static int count;
	private int num;
	private String title; //
	private String contents; // 
	private String writer; // 
	private Date registerDate; // 
	
	

	//생성자
	public Board() {
		count++;
		num = count;
		registerDate = new Date();
	}
	public Board( String title, String content, String writer) {
		this();//위에 잇는 보드 호출
	
		this.title = title;
		this.contents = content;
		this.writer = writer;
	}
	public Board(Board board) {
		this.num = board.num;
		this.registerDate = board.registerDate;
		this.contents = board.contents;
		this.writer = board.writer;
		this.title = board.title;
	}
	
	public void print() {
		System.out.println("번호:"+num);
		System.out.println("제목:"+title);
		System.out.println("작성자:"+writer);
		System.out.println("작성일:"+registerDate);
		System.out.println("내용");
		System.out.println(contents);
	}
	
	public Board(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegisterDate() {
		//날짜를 문자열로 변환
		SimpleDateFormat sh = new SimpleDateFormat("yyyy-MM-dd");
		return sh.format(registerDate);
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title  + ", writer=" + writer
				+ ", registerDate=" + getRegisterDate() + "]"; //적당히 뺄꺼 뺌 고치고
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(contents, count, num, registerDate, title, writer);
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
//		return Objects.equals(contents, other.contents) && count == other.count && num == other.num
//				&& Objects.equals(registerDate, other.registerDate) && Objects.equals(title, other.title)
//				&& Objects.equals(writer, other.writer);  다른거 안보고 넘버만 볼려구 주석처리 아래처럼
		//넘버만 맞으면 맞는걸로 처리하기
		if(num != other.num) {
			return false;
		}
		return true;
	}

	
}
