package new02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Network03 {
	
	public static void main(String[] args) {
		// https://www.nubizio.co.kr/
		URL url = null;
		BufferedReader input = null;
		String addr = "http://www.nubizio.co.kr/";
		String line ="";
		
	
			try {
				url = new URL(addr);
				input = new BufferedReader(new InputStreamReader(url.openStream()));
				
				while((line = input.readLine()) != null){
					System.out.println(line);	
				} //크롤링   //자바로 보통 크롤링 하진 않음 보통은 자바스크립트로 크롤링 해서 사용함( 아님 파이썬에서 크롤링함)
				input.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
