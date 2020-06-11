package ex20io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class E07FileReaderStream {

	public static void main(String[] args) {

		try {
			char[] cbuf = new char[10];
			int readCnt;
			
			Reader in = new FileReader("src/ex20io/alpha.txt");
			
			readCnt = in.read(cbuf,0,10);
			
			for(int i = 0; i<readCnt; i++) {
				System.out.println(cbuf[i]);
			}
			in.close();
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일 없음");
		}
		catch(IOException e) {
			System.out.println("IO오류 발생");
		}
	}

}
