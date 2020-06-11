package ex11static;

/*
 static 블럭 
 	: 동일 클래스 안의 main 메소드보다 먼저 실행되는 블럭으로
 	main메소드의 실행코드 없어도 먼저 실행된다.
 	단, 다른 클래스에 main이 있는 경우에는 main이 순차적으로 실행되다가 static
 	블럭이 있는 클래스가 객체화할 때 실행되게 한다.
 	이 때, 생성자보다 static블럭이 먼저 실행된다.
 */

public class StaticBlock {
	//인스턴스형 멤버
	int instanceVar;
	void instanceMethod() {}
	//static 불록
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적 메소드");		
	}
	
	//static 블럭
	static {
		//static 블럭 안에서는 정적멤버인 staticVar에 접근가능
		staticVar = 1000;
		
		/*
		 Static 블럭 안에서만 사용할 수 있는 지역변수 선언.
		 블럭 내에서는 제한적으로 사용이 가능하다.
		 */
		
		int localVar;
		localVar = 1000;
		System.out.println("localVar = " + localVar);
		
		/*
		 static 블럭 내에서는 인스턴스형 멤버를 사용할 수 없다.
		 */
		//System.out.println("instanceVar = " + instanceVar);//에러
		//instanceMethod();//에러
		
		/*
		 정적멤버만 접근이 가능
		 */
		System.out.println("staticVar = " + staticVar);
		staticMethod();
		
		//main메소드보다 먼저 실행되는지 확인용 출력문
		System.out.println("===static block===");
	}
	
	//생성자 메소드
	/*
	 외부파일의 main메소드에서 실행되는 경우 해당 클래스으 객체가 
	 생성자를 통해 생성되기 전에 static블럭이 먼저 실행된다.
	 */
	public StaticBlock() {
		staticVar = -1;
		System.out.println("==staticBlack의 생성자");
	}
	
	public static void main(String[] args) {
		/*
		 E02StaticBlockMain.java 에서 실행할 때는 주석 처리 후 실행하세요.
		 main메소드가 외부파일에 있을 때 실행을 테스트 하기 위함.
		 */
		//System.out.println("==메인메소드==");
		//System.out.println("localVar = " + localVar);
	}

}
