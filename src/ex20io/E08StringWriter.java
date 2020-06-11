package ex20io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class E08StringWriter {

	public static void main(String[] args) {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("src/ex20io/string.txt"));

			out.write("나는 KOSMO에서 공부한다.");
			out.newLine();
			out.write("수료 후 꼭 취업하겠다.");
			out.newLine();

			out.close();
			System.out.println("입력완료");
		} catch (FileNotFoundException e) {
			System.out.println("파일 없음");
		} catch (IOException e) {
			System.out.println("IO오류");
		}
	}

}
