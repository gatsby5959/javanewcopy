package new01;

import java.util.Scanner;

public class New02 {
	/*
	 * for문을 이용하여 1~10까지중 짝수만 출력
	 * 
	 * 1부터 내가 입력한 수까지 5의 배수를 출력
	 * 
	 */
	public static void main(String[] args) {
		for(int i = 1 ; i <= 10 ; i=i+1) {
			if(i%2==0) {
			System.out.println(i);
			}
		}
		
		System.out.println("-----------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력 : ");
		String str_sc = sc.next();
		int num = sc.nextInt();
//		System.out.println(str_sc);
		int int_sc = Integer.parseInt(str_sc);
		for(int i=1 ; i <= num ; i++) {
			if(i % 5 == 0) {
				System.out.println(i);
			}
		}
	}
}
