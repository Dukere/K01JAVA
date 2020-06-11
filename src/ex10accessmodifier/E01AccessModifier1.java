package ex10accessmodifier;

/*
class를 정의할 때 반드시 public과 default(생략형)만 가능
private class PrivateClass1 {
	void myFunc() {
		System.out.println("나는 정의할 수 없는 Class");
	}
}
*/
/*
접근지정자 생략 시 default 클래스
해당 패키지 안에서만 접그나능
 */

class DefaultClass1 {
	void myFunc() {
		System.out.println("DefaultClass클래스의 myFunc() 메소드 호출");
	}
}

public class E01AccessModifier1 {
	
	private int privateVar;
	int defaultVar;
	public int publicVar;
	
	/*
	 동일 클래스 내에서는 private 멤버라 할지라도 접근이 가능핟.
	 즉, 동일클래스라면 접근지정자의 영향을 받지 않는다.
	 */
	
	private void privateMethod() {
		privateVar = 100;
		System.out.println("privateMethod() 메소드 호출");
	}
	void defaultMethod() {
		privateVar = 200;
		System.out.println("defaultMethod() 메소드 호출");
	}
	/*
	프라이빗으로 선언된 멤버(변수 혹은 메소드)를 외부 클랫에서 접근하고
	싶을떄는 퍼블릭으로 선언된 멤버메소드를 이용해서 간접적으로
	접근을 허용한다.
	 */
	public void publicMethod() {
		privateVar = 300;
		System.out.println("publicMethod() 메소드 호출");
	}

}
