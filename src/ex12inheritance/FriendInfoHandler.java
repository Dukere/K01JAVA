package ex12inheritance;

import java.util.Scanner;

class FriendInfoHandler {
	
	//멤버변수
	
	/*
	 Friend 타입의 객체배열은 하위클래스인 High, Univ객체를 모두 저장할 수
	 잇으므로, 하나의 배열 내에 2개의 객체를 동시에 저장하여 관리할 수 있다.
	 */
	
	private Friend[] myFriends;
	private int numOfFriends;
	
	//생성자 : 인자로 전달되는 num크기로 객체배열 생성
	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriends = 0;
	}
	
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		
		String iName,iPhone,iAddr,iNickname,iMajor;
		
		System.out.println("이름 : ");
		iName = scan.nextLine();
		System.out.println("전화번호 : ");
		iPhone = scan.nextLine();
		System.out.println("주소 : ");
		iAddr = scan.nextLine();
		
		/*
		 1.친구정보를 입력 받은 후  
		 2. 객체배열 0번방에 객체를 저장하고,,,
		 3. numOfFriends 변수를 1 증가시킨다.(후위증가)
		 */
		if(choice==1) {
			System.out.println("별명 : ");
			iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName,iPhone, iAddr, iNickname);
			myFriends[numOfFriends++] = high;
		}
		else if (choice ==2) {
			System.out.println("전공 : ");
			iMajor = scan.nextLine();
			myFriends[numOfFriends++] = new UnivFriend(iName,iPhone, iAddr, iMajor);
			
		}
		
		System.out.println(" 친구 정보 입력이 완료되었습니다. ");
	}
	
	public void showAllData() {
		for (int i = 0; i< numOfFriends ; i++) {
			myFriends[i].showAllData();
		}
		
		System.out.println("==전체 정보가 출력되었습니다==");
		
	}
	/*
	 1.고딩친구 정보를 Friend에 추가
	 2,High 객체가 Friend타입으로 자동형변환되어 저장
	 3. 객체배열에 저장된 객체들은 for문을 통해 순차적으로
		출력. 이때, 오버라이딩된 메소드를 통해 항상 해당 객체의
		정보 출력할 수 있음. ( 참조변수의 타입에 영향을 받지 않음)
	 */
	public void showSimpleData() {
		for (int i = 0; i<numOfFriends ; i++) {
			myFriends[i].showBasicInfo();
		}
		
		System.out.println("==간략정보가 출력되었습니다.==");
	}
	
	public void searchInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요");
		String searchName = scan.nextLine();
		
		for(int i = 0 ; i<numOfFriends; i++ ) {
			
			System.out.println("검색중인 이름 : " + myFriends[i].name);
			
			//검색할 이름과 객체의 이름이 일치하는 경우 모든 정보 출력
			if(searchName.compareTo(myFriends[i].name)==0) {
				myFriends[i].showAllData();
				
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
			}
		}
	}
	
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요 : " );
		String deleteName = scan.nextLine();
		/*
		 배열의 요소 중 삭제된 요소의 인덱스 값을 저장할 용도의 변수
		 요소를 삭제한 후 빈자리를 채울 때 사용할 예정
		 */
		int deleteIndex = -1;
		
		for(int i = 0; i<numOfFriends; i++) {
			if(deleteName.compareTo(myFriends[i].name)==0) {
				//요소를 삭제하기 위해 참조값을 null로 변경
				myFriends[i] = null;
				//삭제된 요소의 인덱스값 저장
				deleteIndex = i;
				//전체 카운트 변수 -1 차감
				numOfFriends--;
			}
		}
		
		if(deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다");
			
		}
		else {
			/*
			 객체 배열에서 검색된 요소를 삭제한 후 입력된 위치의 바로 뒤 요소를
			 앞으로 하나씩 교환한다.
			 */
			for(int i = deleteIndex; i< numOfFriends; i++) {
				myFriends[i]= myFriends[i+1];
			}
			
			System.out.println("==데이터("+deleteIndex+"번)가 삭제되었습니다==");
		}
	}
	
}
