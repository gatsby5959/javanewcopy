package new01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		/*
		 * 단어장
		 * 단어 : 의미
		 * map으로 생성
		 * 입력받을 단어의 개수를 받아서 그 만큼 map에 추가
		 * 콘솔에 찍기
		 */

		System.out.print("입력할 단어의 개수를 입력하세용 : ");
		Scanner scaner = new Scanner(System.in);
		int size = scaner.nextInt();
		System.out.print(size + "개를 입력했습니당");
		
		
		HashMap<String, String> map = new HashMap<>();
		
        for (int i = 0; i < size; i++) {
            System.out.print("영어단어를 입력하세용: ");
            String word = scaner.next();
            System.out.println("");
            System.out.print("영어 단어 한글 의미를 입력하세요: ");
            String mean = scaner.next();
            scaner.nextLine();  // nextInt() 다음의 개행문자를 소비?

            map.put(word, mean);
        }
        
//        System.out.println(map);
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
        	String word = it.next();
        	System.out.println("단어:"+word+" ,  의미:"+map.get(word));
        }
		
	}

}
