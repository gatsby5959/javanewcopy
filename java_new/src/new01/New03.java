package new01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class New03 {
	public static void main(String[] args) {
		
		/*
		 * 컬렉션 프레임워크
		 * - List : 순서를 보장, 중복저장 가능
		 * - Set : 순서보장안함, 중복허용안함
		 * - Map : 2가지 데이터를 쌍으로 저장, 순서보장하지 않음
		 * 	- key(중복불가능), value(중복가능)
		 */
		
		//리스트 생성하고, 1~10까지 등록한 후 출력
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		System.out.println(list);
		for(Integer tmp :list) {
			System.out.print(tmp+ " ");
		}
		System.out.println();
		
		//정수를 입력받아서 입력받은 만큼 오늘의 할일을 입력하고 출력
		//기존 리스트를 비우고 입력받기
		list.clear();
		
		ArrayList<String> list2 = new ArrayList<>();
		
		System.out.println(list);
		System.out.println("숫자를 입력 > ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(num + "개 할일입력> ");
		while(list2.size()< num) {
		
			String str = sc.next();
			list2.add(str);
		}
		
		System.out.println(list2);
		
//		for(int i=1; i<=int_sc; i++) {
//			str_list.add(sc.next());
//			 
//		}
		
		
		for(String tmp :list2) {
			System.out.print(tmp+ " ");
		}
		
		
		
		
		
		
		/* map을 이용하여 이름 : 점수 형태로 3명만 입력
		 * 출력
		 * 
		 * */
		System.out.println("");
		Map<String, Integer> str_int_hashmap = new HashMap<>();
		
        for (int i = 0; i < 3; i++) {
            System.out.print("이름을 입력하세요: ");
            String name = sc.next();
            System.out.println("");
            System.out.print("점수를 입력하세요: ");
            int score = sc.nextInt();
            sc.nextLine();  // nextInt() 다음의 개행문자를 소비

            str_int_hashmap.put(name, score);
        }
		
        System.out.println(str_int_hashmap);
		
		
        
        
		
		sc.close();
	}

}
