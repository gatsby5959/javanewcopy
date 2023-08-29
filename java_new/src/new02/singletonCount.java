package new02;

public class singletonCount {

   public static void main(String[] args) {
      // 객체를 2개 생성
      // 각각 개체에서 countMethod 실행
      // 출력
	   
	   Counter c1 = Counter.getInstance(); //클래스명.메서드명() //싱글톤 객체는 이렇게 생성 (1개만 생성)
	   Counter c2 = Counter.getInstance(); // getInstance()로 이렇게 불러오면 싱글톤이네? 라고 생각하면됨 
      
	   System.out.println(c1.countMethod()); //1
	   System.out.println(c1.countMethod()); //2
	   System.out.println(c1.countMethod()); //3
	   System.out.println(c2.countMethod()); //4
	   System.out.println(c2.countMethod()); //5
	   System.out.println(c2.countMethod()); //6

   }

}

class Counter{
   // 싱글톤으로 객체 만들기
   private static Counter instance;
   private int count;
   
   //private 생성자
   private Counter() {
      
   }
   //getInstace()
   public static Counter getInstance() {
      if(instance == null) {
         instance = new Counter();
      }
      return instance;
   }
   //count() //멤버변수의 count가 1씩증가
   public int countMethod() {
      count++;
      return count;
   }
   
}