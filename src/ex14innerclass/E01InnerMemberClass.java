package ex14innerclass;
/*
 내부 멤버 클래스
 	: 클래스 안에 정의된 클래스로 static이 없는 클래스를 말한다.
 	
 	- 외부클래스의 모든 멤버 ( 정적 혹은 인스턴스형)를 사용할 수 있다.
 	-정적 멤버를 가질 수 없다. ( 단, 상수는 가능)
 	- 컴파일 시 외부클래스명$내부클래스명.class 파일이 생성
 	- 이벤트 기반 프로그래밍 ( 윈도우 프로그래밍, 안드로이드 등) 에서
 	주로 많이 사용된다.
 */

//외부클래스
class OuterMember {

	int outerInstanceVar; // 인스턴스형변수
	static int outerStaticVar; // 정적멤버변수

	int sameVar = 1000;

	// 내부클래스를 사용하기 위한 멤버변수 및 초기화
	InnerMember inner;

	public OuterMember() {
		inner = new InnerMember();
	}

	void outerInstanceMethod() {
		System.out.println("외부의 sameVar : " + sameVar);

		// 정적멤버는 클래스명으로 접근 가능
		System.out.println("내부클래스의 상수 : " + InnerMember.MAX_INT);
		System.out.println("내부의 sameVar : " + inner.sameVar);
	}

	static void outerStaticMethod() {
		// 외부클래스의 정적메소드에서 내부클래스의 정적상수에 접근가능함
		System.out.println(InnerMember.MAX_INT);

		// 정적 메소드에서는 정적 멤버만 접근 가능
		// System.out.println("내부의 sameVar : " + inner.sameVar);
	}

	// 내부클래스(내부멤버클래스)
	class InnerMember {
		int innerInstanceVar;
		int sameVar = 100;

		/*
		 외부 클래스는 내부 클래스보다 넓은 지역이므로 내부 클래스에서는
		 외부의 모든 멤버를 사용할 수 있다.
		 */
		void innerInstanceMethod() {
			outerInstanceMethod();
			outerStaticMethod();
			this.sameVar = sameVar;
			OuterMember.this.sameVar = sameVar;
		}

		/*
		 내부클래스에서는 static멤버를 선언할 수 없다.
		 단, 상수(final)인 경우에는 허용된다.
		 */
		static final int MAX_INT = Integer.MAX_VALUE;
	}
}

public class E01InnerMemberClass {

	public static void main(String[] args) {
		
		/*
		 외부클래스가 아닌 다른 클래스에서는 내부 멤버 클래스가
		 보이지 않으므로 직접 인스턴스를 생성할 수 없다.
		 */

		// InnerMember innerClass = new InnerMember();
		
		/*
		 외부클래스의 인스턴스를 먼저 생성한 후 내부 클래스의 인스턴스를
		 생성해야 한다.
		 */
		OuterMember outerclass = new OuterMember();

		/*
		 내부클래스의 객체는 아래 3가지 방법을 통해 생성할 수 있다.
		 */
		outerclass.inner.innerInstanceMethod();
		OuterMember.InnerMember in = outerclass.new InnerMember();
		OuterMember.InnerMember in2 = new OuterMember().new InnerMember();
	}

}
