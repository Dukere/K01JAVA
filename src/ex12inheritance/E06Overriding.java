package ex12inheritance;
/*
 오버라이딩(Overriding)
 	: 클래스가 상속관계에 있을 때 하위클래스에서 상위클래스의
 	멤버메소드와 완전히 동일한 모양으로 재정의하는것을 말한다.
 	오버로딩과 다른점은 매개변수의 갯수, 타입, 변환형이 완전히 똑같은
 	형태로 정의하는 것이다
 	하위 클래스에서 오버라이딩한 메소드는 상의클래스의 메소드를
 	가리게 되므로 항상 최하위 클래스에서 오버라이딩한 메소드가
 	호출되게 된다.
 */

class Speaker{
	private int volumnRate;
	//setter메소드
	public void setVolumn(int vol) {
		volumnRate = vol;
	}
	
	public void showState() {
		System.out.println("스피커의 볼륨크기 " + volumnRate);
	}
}

class BaseSpeaker extends Speaker {
	
	private int baseRate;
	public void setBase(int bas) {
		baseRate = bas;
	}
	/*
	 @Override : 어노테이션이라 부르고 오버라이딩된
	 	메소드에 붙어 컴파일러에게 알려주는 역할을 한다.
	 */
	@Override
	public void showState() {
		//super를 통해 부모클래스에 정의된 멤버메소드를 호출
		super.showState();
		System.out.println("베이스의 볼륨크기 : " +baseRate);
	}
}
public class E06Overriding {

	public static void main(String[] args) {

		BaseSpeaker baseSpeaker = new BaseSpeaker();
		baseSpeaker.setVolumn(10);
		baseSpeaker.setBase(20);
		baseSpeaker.showState();/*
			하위 클래스에 오버라이딩된 showState() 메소드가 호출
		*/
		
		System.out.println();
		/*
		 부모클래스의 참조변수가 자식클래스의 객체를 참조할 수 있다.
		 이 경우 접근 범위는 부모클래스로 제한된다.
		 즉, 아래 호출 부분에서 speaker 참조 변수를 통해서는 setBase()
		 메소드는 호출할 수 없다. setBase()는 자식클래스에 정의된
		 멤버메소드이기 때문이다.
		 단, 오버라이딩 처리된 메소드가 있는 경우 하위 클래스의 메소드가 
		 호출되게 된다.
		 */
		Speaker speaker = new BaseSpeaker();
		speaker.setVolumn(30);
		speaker.showState();
		//speaker.setBase(40);
	}

}
