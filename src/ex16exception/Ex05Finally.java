package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 finally절
 	: 예외 발생 여부와 상관없이 try문으로 진입했을 때
 	반드시 실행해야 하는 코드가 있는 경우 기술하는 블럭이다.
 	즉, try문으로 집인되지 않는다면 finally절은 실행되지 않는다.
 	
 	1)try~catch : 예외를 직접 처리할때
 	2)try~catch~finally : 예외를 직접 처리 후 실행할
 		문장이 있을 때
 	3) try~finally : 예외는 외부로 던지고 예외발생과
 		상관없이 실행할 문장이 있을때 . . . . .  . . .
 */

public class Ex05Finally {
	
	static void runtime() throws NumberFormatException {
		Integer.parseInt("백");
	}
	
	static void tryCatchFinally() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = Integer.MAX_VALUE;
		try {
			age = scan.nextInt();
			System.out.println("당신은 5년 후 " + (age+5) + "살 입니다.");
			//try구문에서 return을 만나도 finally 구문 실행됨.
			return;
		}
		catch(InputMismatchException e) {
			//예외가 발생되더라도 finally구문은 실행됨.
			System.out.println("나이는 숫자만 쓰세요.");
		}
		
		finally {
			System.out.println("항상 실행되는 finally절 입니다.");
			
			//프로그램 자체 종료
			/*
			try문 안에서 exit(0)를 실행하게 되면 프로그램 자체가
			종료되므로 finally 구문 실행 X
 			 */
			System.exit(0);
		}
	}

	public static void main(String[] args) {

		try {
			runtime();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		tryCatchFinally();
		System.out.println("메인 메소드 끝");
	}

}
