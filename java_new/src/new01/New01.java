package new01;

public class New01 {

	public static void main(String[] args) {
		/*
		 * 홍길동 주민등록번호는 881122-1234567이다 
		 * 출력형태 : 생년월일 : 881122, 성별 : 남(1,3)
		 **/
		String pin = "881122-1234567";
//		System.out.println("되나요?");
//		String pin2 = pin.substring(0, 6);
//		System.out.print("생년월일 : ");
//		System.out.print(pin2);
//		System.out.print(", ");
//		System.out.print("성별 : ");
//		String pin3 = pin.substring(7, 8);
//		if (pin3.equals("1") || pin3.equals("3")) {
//			System.out.println("남 (1,3)");
//		} else {
//			System.out.println("여");
//		}
		
		
		String pin2 = pin.substring(0, 6);
		String birth = pin.substring(0,pin.indexOf("-"));
		System.out.print("생년월일 : "+birth);
//		char ch = pin.charAt(pin.indexOf("-")+1);
		String ch = pin.substring(pin.indexOf("-")+1,pin.indexOf("-")+2);
		System.out.println(ch);
		//ch : 정수형 ==
		//String : 문자열 equals 사용
		if(ch.equals("1")||ch.equals("3")) {
			System.out.println("성별:남");
		}else {
			System.out.println("성별:여");
		}
				

	}

}
