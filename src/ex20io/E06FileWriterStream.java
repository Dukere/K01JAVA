package ex20io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class E06FileWriterStream {

	public static void main(String[] args) {

		try {
			char ch1 = 'A';
			char ch2 = 'Z';
			
			Writer out = new FileWriter("src/ex20io/alpha.txt");
			
			out.write(ch1);
			out.write(ch2);
			out.close();
		}
		catch(IOException e) {
			System.out.println("문자 스트림 작업 중 오류 발생");
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	}

}
