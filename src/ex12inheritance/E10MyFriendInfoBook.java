package ex12inheritance;

import java.util.Scanner;

class Friend {
	String name;
	String phone;
	String addr;

	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}

	public void showAllData() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + addr);
	}

	public void showBasicInfo() {
	}
}

class HighFriend extends Friend {
	String nickname;

	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}

	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명 : " + nickname);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("별명 : " + nickname);
		System.out.println("전번 : " + phone);

	}

}

class UnivFriend extends Friend {
	String major;

	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}

	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공 : " + major);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("별명 : " + name);
		System.out.println("전번 : " + phone);
	}
}

public class E10MyFriendInfoBook {

	public static void menuShow() {
		System.out.println("***메뉴를선택하세요***");
		System.out.println("1.고딩친구입력");
		System.out.println("2.대딩친구입력");
		System.out.println("3.전체정보출력");
		System.out.println("4.간략정보출력");
		System.out.println("5.검색");
		System.out.println("6.삭제");
		System.out.println("7.프로그램종료");
		System.out.println("메뉴선택>>>");
	}

	public static void main(String[] args) {

		FriendInfoHandler handler = new FriendInfoHandler(100);

		while (true) {
			menuShow();

			Scanner scan = new Scanner(System.in);

			int choice = scan.nextInt();

			switch (choice) {
			case 1:	case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllData();
				break;
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}


