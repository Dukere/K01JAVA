package ex15usefulClass;

public class E01WrapperClass2 {

	public static void main(String[] args) {

		/*
		 parseInt() : 숫자형식의 문자열을 순자로 변경
		 */
		String strNumber = "1000";
		System.out.println("10+strNumber = " + (10+strNumber));
		System.out.println("10 + strNumber를 숫자로 변경 : " + (10 + Integer.parseInt(strNumber)));
		System.out.println("10 + strNumber를 숫자로 변경 : " + (10 + Integer.valueOf(strNumber)));//동일한 기능
		
		/*
		 문자열으로 숫자로 변경할 떄는 반드시 숫자형식만 와야한다.
		 '원'은 숫자가 아니므로 NumberFormat~으로 효년
		 */
		
		String money = "120원";
		//System.out.println("120원 : " + Integer.parseInt(money));
		
		/*
		 실수형태의 문자열을 실수로 변경할 때는 parseInt()를 사용할 수 업다.
		 위와 똑같은에러발생
		 */
		String floatString = "3.14";
		//System.out.println(Integer.parseInt(floatString));
		System.out.println("실수형(float)형으로 변경 : " + Float.parseFloat(floatString));
		System.out.println("실수형(Double)형으로 변경 : " + Double.parseDouble(floatString));
		
		//Character클래스의 주요 메소드
		/*
		 2]codePointAt() :  문자열에서 index에 해당하는 
		 	한 문자의 아스키코드값을 반환한다.
		 */
		System.out.println("ABCD에서 3번째 인덱스 D으 아스키코드");
		System.out.println(Character.codePointAt("ABCD", 3));
		/*
		 3] isDigit() : 문자열이 숫자인지 판단한다.
		 	숫자일 때 true 반환.
		 */
		System.out.println("isDigit()를 통한 숫자판단");
		System.out.println(Character.isDigit('A')?"숫자임":"숫자아님");
		System.out.println(Character.isDigit(50)?"숫자임":"숫자아님");
		System.out.println(Character.isDigit('7')?"숫자임":"숫자아님");
		
		/*
		 4] isLetter() : 문자 여부를 판단하는 메소드로 특수기호나 숫자형은 false를 반환
		 	숫자형 false반환

		 */
		System.out.println("isLetter()메소드를 통한 문자판단");
		System.out.println(Character.isLetter('가'));
		System.out.println(Character.isLetter('A'));
		System.out.println(Character.isLetter('#'));
		System.out.println(Character.isLetter('9'));
		
		/*
		 5] isWhiteSpace() : 공백문자인지 판단
		 */
		System.out.println("isWhiteSpace() 메소로 공백문자 판단");
		System.out.println(Character.isWhitespace('A'));
		System.out.println(Character.isWhitespace(' '));
		/*
		 6] isLowerCase(), isUpperCase()
				: 대소문자를 판단. 단 영문자에만 적용되며 알파벳이 아닌 문자에 적용시 false를 반환

		 */
		System.out.println("알파벳 대소문자 판단");
		System.out.println(Character.isLowerCase('A'));
		System.out.println(Character.isUpperCase('z'));
		System.out.println(Character.isLowerCase('a'));
		System.out.println(Character.isUpperCase('Z'));
		System.out.println(Character.isLowerCase('가'));
		
		/*
		 시나리오] 주어진 문자열 안에 몇개의 공백문자(스페이스)가 있는지
		 판단하는 프로그램을 작성하시오.
		 	참고) toCharArray() : 문자열을 char형 배열로 반환해주는
		 		String 클래스에 정의된 메소드.
		 */
		String whiteString = " H E    L      L  O";
		int whiteCount = 0;
		char[] chArr = whiteString.toCharArray();
		for(int i = 0; i<chArr.length; i++) {
			if(Character.isWhitespace(chArr[i])) {
				whiteCount++;
			}
		}
		System.out.println("총 공백 수 : "+ whiteCount);
		
	}

}
