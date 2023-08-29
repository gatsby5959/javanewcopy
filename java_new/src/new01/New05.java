package new01;

import java.util.HashMap;
import java.util.Scanner;

public class New05 {
	HashMap<String, String> map = new HashMap<>();
	static Scanner scaner = new Scanner(System.in);
	static int size = 0;

	public static void main(String[] args) {
		/* 2
		 * New04의 내용을 메서드로 분리
		 * */
		New05 new05= new New05();
		System.out.println("몇개입력받을꺼얌?");
		size = scaner.nextInt();
		//map를 받아서 출력	
		
		new05.map = new05.afun();
		System.out.println(new05.map);
	}

	/* 1
	 * 기능 : 단어 : 의미를 입력 받아서 map을 구성
	 * 리턴 : map
	 */
	public HashMap<String, String> afun() {
        for (int i = 0; i < size; i++) {
            System.out.print("영어단어를 입력하세용: ");
            String word = scaner.next();
//            System.out.println("");
            System.out.print("영어 단어 한글 의미를 입력하세요: ");
            String mean = scaner.next();
            scaner.nextLine();  // nextInt() 다음의 개행문자를 소비? 몰라 그냥 넣엇음
            map.put(word, mean);
        }		
		return map;
	}
	
}
