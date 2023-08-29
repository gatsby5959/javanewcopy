package new01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class New05_miran {

   public static void main(String[] args) {
      /* New04의 내용을 메서드로 분리
       * map을 받아서 출력
       * */
      
       HashMap<String, String> map = new HashMap<>();
       
       map = mapreturn();
       
       for(String tmp : map.keySet()) {
            System.out.println(tmp + ":" + map.get(tmp));
         }
         
//       Iterator 순서
         Iterator<String> it = map.keySet().iterator();
         while(it.hasNext()) {
            String word = it.next();
            System.out.println("단어:" + word + "의미:" + map.get(word));
         }
   }

   
   /* 기능 : 단어 : 의미를 입력받아서 map을 구성
    * 리턴 : map
    * */
   
   public static HashMap<String, String> mapreturn() {
      Scanner scan = new Scanner(System.in);
      
      HashMap<String, String>map = new HashMap<String, String>();
      
      System.out.println("숫자 입력");
      int a = scan.nextInt();
      
         for(int i = 0; i < a; i++) {
         
         System.out.println("단어");
         String scan3 = scan.next();
         System.out.println("의미");
         String scan4 = scan.next();
         map.put(scan3, scan4);
      }
         
         return map;
      
   }
      
}