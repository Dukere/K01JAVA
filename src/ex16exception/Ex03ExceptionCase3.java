package ex16exception;

import java.io.IOException;

/*
 예외 처리 방법2]
 	: 예외 발생 지점에서 직접 처리

 */

public class Ex03ExceptionCase3 {

	static void compileFunc() {
		try {
			System.out.print
			("하나의 문자를 입력하세요 : ");
			int userChar = System.in.read();
			System.out.println("입력된 문자는 : " + (char) userChar);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		compileFunc();

	}

}
