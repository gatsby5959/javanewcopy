package word;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wordmanager {

	private ArrayList<Word> list = new ArrayList<>();

	public void insertWord( Scanner scan) {
		// TODO Auto-generated method stub
		Word w = new Word();
		System.out.println("단어 : ");
		w.setWord(scan.next());
		System.out.println("의미 : ");
		w.setMean(scan.next());
		list.add(w);
		System.out.println("등록완료");
	}

	public void searchWord(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("검색단어:");
		String s = scan.next();
		for(Word tmp : list) {
			if(tmp.getWord().equals(s)) {
				System.out.println("--검색결과--");
				System.out.println(tmp);
				return;
			}
		}
		System.out.println("검색결과가 없습니다.");
		
	}

	public void modifyWord(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("수정단어:");
		String s = scan.next();
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getWord().equals(s)) {
				System.out.println("의미수정:");
				String m = scan.next();
				Word w = new Word(s,m);
				list.set(i, w);
				return;
			}
		}
		
		System.out.println("검색되 ㄴ단어가 없습니다.");
	}

	public void printWord() {
		// TODO Auto-generated method stub
		System.out.println("--단어장--");
		for(Word tmp : list) {
			System.out.println(tmp); //toString자동?호출
		}
	}

	public void filePrint() throws IOException {
		// TODO Auto-generated method stub
		// 파일로 출력
		FileWriter fw = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sb = new StringBuffer();
		
		String data="";
		int cnt = 0;
	
		while(cnt < list.size()) {//리스트가 모두 소진될때까지
			sb.append(list.get(cnt).toString());
			sb.append("\n"); //줄바꿈
			data = sb.toString();
			cnt++;
		}
		System.out.println(data);
		fw.write(data);
		fw.close();
		
	}
	
	
} //class










