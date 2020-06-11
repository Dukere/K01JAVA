package ex10accessmodifier.cal;

/*칼큘레이ㅓ 클래스는 해당자바파일에서 외부에가장 의미있는
 * 클래스로써 퍼블릭으로 선언되었다.
 * 자바에서는 하나의 클래스만퍼블릭으로 선언하는 것이 가능하ㅏ.
 * 퍼블릭으로선언된 클래스에서 디폴트 클래스를 사용하는형태로
 * 제작되어야 한다.
 */

public class Calculator {

	private Adder adder;
	private Subtractor subtractor;
	/*
	 * 생성자 메소드
	 * 		: 해당클래스의 객체가 생성될 때 덧셈, 뺄셈을
	 * 위한클래스의 객체도 동시에 생성된다.
	 */

	public Calculator() {
		adder = new Adder();
		subtractor = new Subtractor();
	}
	
	/*
	 * 멤버 메소드 
	 * 		: 각연산을위해 해당디폴트클래스의 멤버메소드를 호출한 후 결과를 반환
	 */

	public int addTwoNumber(int n1, int n2) {
		return adder.addTwoNumber(n1, n2);
	}

	public int subTwoNumber(int n1, int n2) {
		return subtractor.subTwoNumber(n1, n2);
	}
	
	//정보은닉되어있는 멤버변수의 출력 위해 getter()메소드 호출
	public void showOperatingTimes() {
		System.out.println("덧셈횟수 : " + adder.getCntAdd());
		System.out.println("뺄셈횟수 : " + subtractor.getCntSub());
	}

}


class Adder{
	
	private int cntAdd;
	
	Adder() {
		cntAdd= 0;
	}
	
	public int getCntAdd() {
		return cntAdd;
	}
	
	int addTwoNumber(int n1, int n2) {
		cntAdd++;
		return n1+n2;
	}
}

class Subtractor{
	
	private int cntSub;
	
	public Subtractor() {
		cntSub= 0;
	}
	
	public int getCntSub() {
		return cntSub;
	}
	
	int subTwoNumber(int n1, int n2) {
		cntSub++;
		return n1 - n2;
	}
}
