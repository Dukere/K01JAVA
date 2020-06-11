package ex13interface;

/*
 추상클래스를 interface로 변경하기
 	abstract class => interface
 	
 	메소드의 경우 public abstract를 제거
 	
 	멤버상수인 경우 public static final을 제거
 */

//프로젝트 전체에서 기준이 될 수 있는 추상클래스 정의
interface PersonalNumberStorageInter{
	void addPersonalInfo(String juminNum, String name);
	String searchPersonalInfo(String juminNum);
}
/*
 사람의 정보를 저장할 용도의 DTO클래스, 혹은 VO클래스라고 한다.
 */
class PersonalInfoVO{
	private String name;
	private String juminNum;
	
	public PersonalInfoVO(String name, String juminNum) {
		this.name = name;
		this.juminNum = juminNum;
	}

	public String getName() {
		return name;
	}

	public String getJuminNum() {
		return juminNum;
	}
	
	
}

/*
 클래스가 클래스를 상속 받을 때 => extends 사용
 클래스가 인터페이스를 상속 받을 때 => implements 사용
 인터페이스가 인터페이스를 상속 받을 때 => extends 사용
 
 extends는 '상속'이라 표현하고, implements는 '구현'이라 표현한다.
 */
class PersonalNumberStorageImpl implements PersonalNumberStorageInter{
	PersonalInfoVO[] personalArr;
	int numOfPerInfo;
	
	
	public PersonalNumberStorageImpl(int arrSize) {
		personalArr = new PersonalInfoVO[arrSize];
		numOfPerInfo = 0;
	}
	
	/*
	 전달 받은 인자를 통해 PersonalInfoVO 객체를생성 후 객체 배열에
	 저장한다.
	 */
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo] =
				new PersonalInfoVO(name, juminNum);
		numOfPerInfo++;
	}
	/*
	 주민번호를인자로 전달 받아 객체배열에 저장된 정보를 검색한 후 
	 일치하는 경우에만 이름을 반환한다.
	 */
	@Override
	public String searchPersonalInfo(String juminNum) {
		for(int i = 0; i < numOfPerInfo; i++) {
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0)
			{
				return personalArr[i].getName();
			}
		}
		return null;
	}
}
public class E02AbstractToInterface2 {

	public static void main(String[] args) {

		PersonalNumberStorageInter storage = 
				new PersonalNumberStorageImpl(10);
		
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("001024-1090333"));
	}

}
