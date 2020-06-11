package ex10accessmodifier;


//과일판매자를 추상화한 클래스
class FruitSeller {
	
	//외부에서 접근 못하게 프라이빗
	private int numOfApple; //판매자의 사과 보유 갯수
	private int myMoney;	//판매수익
	private final int APPLE_PRICE; //다시 상수로 선언함.
	/*
	상수는 값의 변경이 불가능하고 단 한번만 초기화되기
	때문에 일반적인 멤버메소드에서는 초기화 할 수 없다.
	단, 생성자메소드에서는 초기화가 가능하다.
	마음대로 호출할 수 없고, 객체생성시 단 한번만 호출되는
	특성이 동일하기 때문에 한 번 이상 초기화 되지 않음이
	보장되기 때문이다.
	 */
	public FruitSeller(int money,int appleNum, int price ) {
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

class FruitBuyer {
	private int myMoney;
	private int numOfApple;
	
	public FruitBuyer(int _myMoney,int _numOfApple) {
		
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액 : " + myMoney);
		System.out.println("[구매자]사과 갯수 : " + numOfApple);
	}
}

public class E03InformaionHiding {

	public static void main(String[] args) {
		
		/*
		 생성자를 통해서 객체 생성과 동시에 초기화되므로
		 init(초기화메소드)메소드를 호춣ㄹ 필요가 없어진다.
		 따라서 객체생성 코드를 한 줄로 줄일 수 있다.
		 */
		
		//판매자1
		FruitSeller seller1 = new FruitSeller(0, 100, 1000);

		FruitSeller seller2 = new FruitSeller(0, 80, 500);
		
		FruitBuyer buyer = new FruitBuyer(10000, 0);
		
		System.out.println("구매행위가 일어나기 전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
		/*
		 멤버변수를 private으로 선언하면 외부클래스에서는 접근이
		 불가능하므로 아래 코드는 에러가 발생된다 .
		 */
		/*
		
		seller1.myMoney += 1000;
		seller1.numOfApple -= 50;
		buyer.numOfApple += 50;

		seller2.myMoney += 1000;
		seller2.numOfApple -= 70;
		buyer.numOfApple += 70; // 구매자 보유금액 차감 X
		
		*/
		
		/*
		 판매자 1,2에게 각각의 금액을 지불하고 금액에 해당하는
		 사과를 정상적으로 구매하였다.
		 정보은닉을 통해 판매의 규칙이 지켜지게 되었다.
		 */
		
		buyer.buyApple(seller1, 1000);
		buyer.buyApple(seller2, 1000);
		
		
		System.out.println("구매행위가 일어나기 후의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();		
	}

}
