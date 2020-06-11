package ex12inheritance;

class Burger {
	//멤버변수
	/* 버거명, 가격, 패티, 소스, 야채을 표현 */
	private String name;
	private int price;
	private String patty;
	private String source;
	private String vegi;
	
	//인자생성자
	public Burger(String name, int price, String patty, String source, String vegi) {
		super();
		this.name = name;
		this.price = price;
		this.patty = patty;
		this.source = source;
		this.vegi = vegi;
	}
	
	//getter : price만 필요	
	public int getPrice() {
		return price;
	}
	
	//햄버거 정보 출력
	/* 버거명, 가격, 식재료 출력*/
	
	public void showHamburger() {
		System.out.printf("%s\n가격 : %d\n식재료 : %s, %s, %s\n"
				,name,price,patty,source,vegi);
	}
}
//햄버거의 기본가격 추상화 
class HamburgerPrice {
	//멤버변수
	/* 햄버거종류, 음료, 프렌치프라이 */
	Burger burger;
	final int COKE = 1000;
	final int POTATO = 1500;

	//인자생성자
	public HamburgerPrice (Burger burger) {
		this.burger = burger;
	}
	//기본가격계산
	//햄버거와 결제금액 출력
	public void showPrice() {
		burger.showHamburger();
		System.out.println("결제금액 : "+(burger.getPrice()+COKE+POTATO));
		System.out.println("==================================");
	}
}
//세트가격을 추상화(기본가격을 상속)
class SetPrice extends HamburgerPrice {	
	//인자생성자

	public SetPrice (Burger burger) {
		super(burger);
	}
	//세트가격계산(오버라이딩)
	
	//햄버거와 세트결제금액 출력(오버라이딩)
	public void showPrice() {
		burger.showHamburger();
		System.out.println("결제금액 : "+(burger.getPrice()+COKE+POTATO-500));
		System.out.println("==================================");
	}
}

public class QuBuyHamburger {

	public static void main(String[] args) {
		
		//치즈버거 객체 생성
		Burger burger1 = new Burger("치즈버거", 2000, "쇠고기패티", "케챱", "피클");
		//치킨버거 객체 생성
		Burger burger2 = new Burger("치킨버거", 3000, "닭고기패티", "마요네즈", "양상치");
		
		//치즈버거를 기본가격으로 구매
		HamburgerPrice price1 = new HamburgerPrice(burger1); 
		price1.showPrice();	// 4500원	
		
		//치킨버거를 세트가격으로 구매
		HamburgerPrice price2 = new SetPrice(burger2); 
		price2.showPrice();	// 5000원
	}
}
