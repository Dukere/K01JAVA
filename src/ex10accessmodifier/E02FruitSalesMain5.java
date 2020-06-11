package ex10accessmodifier;


//과일판매자를 추상화한 클래스
class FruitSeller5 {
	int numOfApple; //판매자의 사과 보유 갯수
	int myMoney;	//판매수익
	final int APPLE_PRICE; //다시 상수로 선언함.
	/*
	상수는 값의 변경이 불가능하고 단 한번만 초기화되기
	때문에 일반적인 멤버메소드에서는 초기화 할 수 없다.
	단, 생성자메소드에서는 초기화가 가능하다.
	마음대로 호출할 수 없고, 객체생성시 단 한번만 호출되는
	특성이 동일하기 때문에 한 번 이상 초기화 되지 않음이
	보장되기 때문이다.
	 */
	public FruitSeller5(int money,int appleNum, int price ) {
		numOfApple = appleNum;
		myMoney = money;
		APPLE_PRICE = price; // <= 생성자 내에서는 상수를 초기화 할 수 있음.
	}
	
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	
	public void showSaleResult() {
		System.out.println("[판매자]남은 사과 갯수 : " + numOfApple);
		System.out.println("[판매자]판매수익 : " + myMoney);
	}
}

class FruitBuyer5 {
	int myMoney;
	int numOfApple;
	
	public FruitBuyer5(int _myMoney,int _numOfApple) {
		
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller5 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액 : " + myMoney);
		System.out.println("[구매자]사과 갯수 : " + numOfApple);
	}
}

public class E02FruitSalesMain5 {

	public static void main(String[] args) {
		
		/*
		 생성자를 통해서 객체 생성과 동시에 초기화되므로
		 init(초기화메소드)메소드를 호춣ㄹ 필요가 없어진다.
		 따라서 객체생성 코드를 한 줄로 줄일 수 있다.
		 */
		
		//판매자1
		FruitSeller5 seller1 = new FruitSeller5(0, 100, 1000);

		FruitSeller5 seller2 = new FruitSeller5(0, 80, 500);
		
		FruitBuyer5 buyer = new FruitBuyer5(10000, 0);
		
		System.out.println("구매행위가 일어나기 전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		/*
		 아래의 코드는 문법적으로는 오류가 없으나 지불금액과 구매한
		 사과의 관계가 전혀 맞지 않는 논리적 오류가 발생되었다.
		 즉, 코드(메소드)로 구현한 규칙이 완전히 무너지게 된다.
		 객체지향 언어에서는 이런 논리적 오류를 범하지 않기 위해
		 "정보 은닉"이라는 개념을 제시하고 있다.
		 */
		
		seller1.myMoney += 1000;
		seller1.numOfApple -= 50;
		buyer.numOfApple += 50;

		seller2.myMoney += 1000;
		seller2.numOfApple -= 70;
		buyer.numOfApple += 70; // 구매자 보유금액 차감 X
		
		System.out.println("구매행위가 일어나기 후의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();		
	}

}
