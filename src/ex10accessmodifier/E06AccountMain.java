package ex10accessmodifier;

public class E06AccountMain {

	public static void main(String[] args) {

		AccountDAO cap = new AccountDAO();
		
		cap.init("홍길동", "1234-56789-0", 10000);
		cap.printAccount();
		cap.withdraw(20000);
		cap.withdraw(3000);
		cap.deposit(10000);
		cap.printAccount();
		
	}

}
