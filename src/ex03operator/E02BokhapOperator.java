package ex03operator;

public class E02BokhapOperator {

	public static void main(String[] args) {
		
		/*
		 복합대입연산자
		 	: 산술연산자와 대입연산자를 연결해놓은 형태로
		 	좌우측의 값을 연산하여 좌측의 변수에 대입하는
		 	형태의 구조를 가진다.
		 	 문법 구조상 항상 현재 타입을 유지하는 특성을 가지고 있다.
		 */
		double e = 3.1;
		e += 2.1;
		e *= 2;
		e = e + e;
		System.out.println("e의 결과값 : " + e);
		
		int n = 5;
		//n = n * 2.7;
		n *= 2.7;
		System.out.println("n의 결과값 : " + n);
		

	}

}
