package new01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class New03_2 {
	public static void main(String[] args) {
		
		/*
		 * 컬렉션 프레임워크
		 * - List : 순서를 보장, 중복저장 가능
		 * - Set : 순서보장안함, 중복허용안함
		 * - Map : 2가지 데이터를 쌍으로 저장, 순서보장하지 않음
		 * 	- key(중복불가능), value(중복가능)
		 */
	
		
		
		
		
		/* map을 이용하여 이름 : 점수 형태로 3명만 입력
		 * 출력
		 * 
		 * */
		System.out.println("");
		Map<String, Integer> map = new HashMap<>();
		
		map.put("영이",78);
		map.put("창희",77);
		map.put("건희",69);
		
        System.out.println(map);
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+":"+map.get(key));
		}
		for(String tmp : map.keySet()) {
			System.out.println(tmp+":"+map.get(tmp));
		}
        
        
	}

}
