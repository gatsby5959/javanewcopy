package new02;

import java.io.IOException;
import java.net.URL;

public class Network02 {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://news.mt.co.kr/mtview.php?no=2023082915335124202&cast=1&STAND=MTS_P");
		System.out.println(url.getContent());
		System.out.println(url.getAuthority());
		System.out.println(url.getPort());
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getQuery());
		System.out.println(url.getPath());
	}
	
	
}
