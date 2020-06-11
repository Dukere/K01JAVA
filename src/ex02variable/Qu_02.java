package ex02variable;

/*
 국어,영어,수학 점수를 99, 80, 96점으로 입력하고 
평균점수를 구해서 출력하는 프로그램을 작성하시오.
출력결과]
	99점,80점,96점의 평균점수는 XXX.XX점입니다.(실수형태)
	99점,80점,96점의 평균점수는 XXX점입니다.(정수형태)

 */

public class Qu_02 {

	public static void main(String[] args) {

		int kor = 99, eng = 80, math = 96;
		double result1 = (kor + eng + math) / 3.0;
		int result2 = (kor + eng + math) / 3;
		
		
		System.out.println("99점, 80점, 96점의 평균점수는 " + result1 + "입니다.(실수형태)");		
		System.out.println("99점, 80점, 96점의 평균점수는 " + result2 + "입니다.(정수형태)");		
		
	}

}
