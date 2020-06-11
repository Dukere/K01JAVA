package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04MultiCatch {

	public static void main(String[] args) {
		
		/*
		 예외 처리를 할 떄 필요에 따라 여러개의catch블럭을사용할수 있다.
		 -이 경우 반드시자식 예외클래스부터 catch블럭에 사용한다.
		 -Exception클래스는 모든 예외를 catch하기 때문에
		 마지막 블럭에 사용해야 한다.
		 -중간에 사용하면에러가 발생한다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		int array[] = new int[3];
		
		try {
			for(int i = 0; i <array.length;i++) {
				System.out.print("array["+i+"]에 저장할 숫자 입력 : ");
				array[i] = Integer.parseInt(scanner.nextLine());
				//테스트 시 '11a' 형태로 입력할 것
			}
			
			System.out.println("배열에 저장된 두 숫자 나누기 : " +
					array[0]/array[1]);
			System.out.print("나이를 입력하세요 : ");
			int age = scanner.nextInt();
			//나이입력시 숫자 이외의 문자를 입력할 것
			System.out.println("당신의 나이는 : " + age);
			
			array[3] = age;
			
		}
		
		catch(InputMismatchException e) {
			System.out.println("숫자로만 입력해야합니다.");
			
		}
		catch(ArithmeticException e) {
			System.out.println("산술연산이 불가능 합니다.");
		}
		catch(NumberFormatException e) {
			System.out.println("숫자 형태의 문자만 입력가능합니다.");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스를 초과하였습니다.");
		}
		catch(Exception e) {
			System.out.println("예외가 발생하였습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("===프로그램 끝 ===");

	}

}
