package ex12inheritance;
/*
 구성관계로 표현하기에 적합한 Has-A 관계
 	: X Has A Y -> X가 Y를 소유하고 있다.
 	-경찰이 권총을소유하다
 	- 경찰이 수갑을 소유하다.
 	
 	Has-A오 같이 소유의 관계를 상속으로 표현하면 클래스 간의
 	강한 연결고리가 형성되어 권총이 없는 경찰을 표현하기가
 	힘들어진다. 따라서 이 경우에는 구성관계로 표현하는 것이
 	적합하다. 구성관계는 클래스의 멤버로 또 다른 객체를 정의하는 것을 
 	말한다.
 */
class Gun {
	int bullet;
	public Gun(int bNum) {
		bullet = bNum;
	}
	public void shotGun() {
		System.out.println("빵야 ~~ !");
		bullet--;
	}
}

class Police {
	int handCuffs;
	Gun gun;
	
	public Police (int bNum, int hCuff) {
		handCuffs = hCuff;
		/*
		 권총 보유여부 초기화
		 	:만약 총알이 없는 상태라면 보유한 권총이 없는 것으로
		 	표현하기 위해 참조변수를 null로 초기화한다. 참조변수가
		 	null값을 가진다는 것은 아무것도 참조할 객체가 없다는 의미이다.
		 */
		if(bNum<=0) {
			gun = null;
		}
		else {
			gun = new Gun(bNum);
		}
	}
	
	public void putHandcuff() {
		System.out.println(" 수갑 채움 ");
		handCuffs--;
	}
	public void shot() {
		if(gun == null) {
			System.out.println("보유한 권총없음. ");
			
		}
		else {
			gun.shotGun();
		}
	}
}

public class E05HasAComposite {

	public static void main(String[] args) {
		
		System.out.println("==경찰1==");
		Police police1 = new Police(5,3);
		police1.shot();
		police1.putHandcuff();
		
		System.out.println("==경찰2==");
		Police police2 = new Police(0,3);
		police2.shot();
		police2.putHandcuff();

	}

}
