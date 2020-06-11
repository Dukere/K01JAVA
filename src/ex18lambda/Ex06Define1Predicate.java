package ex18lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*
 JAVA에서 제공하는 기본 함수형 인터페이스로 다음과 같은 종류가 있다.
 큰 차이점이라면 매개변수의 유무, 리턴값의 유무 정도이다.
 
 Consumer: 매개변수 있고, 리턴값 없음
 Supplier : 매개변수 없고, 리턴값 있음
 Function: 매개변수, 리턴값 둘 다 있음
 Predicate : 매개변수 있고, 리턴은 boolean값으로 반환함
 */

public class Ex06Define1Predicate {

	/*Interface A {
		boolean test(Object obj);
	}*/
	public static void main(String[] args) {
		/*
		 Interface Predicate<E> {
		 	boolean test(T t);
		 }
		 : 전달된 인자를 대상으로 true, false를 판단할 때
		 사용하는 추상메소드를 정의하고 있다.
		 */
		Human p1 = new Human("케이윌", "남", 80);
		Human p2 = new Human("에일리", "여", 77); 
		/*
		 Predicate<Human> 인터페이스를 구현하여 정의한
		 람다식.test() 추상메소드를 오버라이딩하고 있다.
		 */
		Predicate<Human> pre = (Human h) -> {
			return h.getGender().equals("남");
		};
		System.out.println("p.test(p1) => " + pre.test(p1));
		System.out.println("p.test(p2) => " + pre.test(p2));
		
		System.out.println("===============================");
		
		Human p3 = new Human("임재범", "남" , 97);
		Human p4 = new Human("아이유", "여" , 99);
		
		//일반적인 배열을 List 컬렉션으로 변경해주는 메소드
		List<Human> list1 = Arrays.asList(p1,p2,p3,p4);
		
		//람다식 자체를 매개변수로 전달
		//첫번째호출 : 매개변수 객체가 남자일 때 true를 반환하는 람다식 전달
		double maleAvg = avg(a -> a.getGender().equals("남"), list1);
		System.out.println("남자 평균 : " + maleAvg);
		
		double femaleAvg = avg((Human b) -> b.getGender().equals("여"), list1);
		System.out.println("여자 평균 : " + femaleAvg);
		
		System.out.println("======================");
		
		List<Integer> list = Arrays.asList(1,3,5,7,9,11,12,14);
		
		int total;
		total = sum((Integer n ) -> n%2 == 0, list);
		System.out.println("짝수합 : " + total);
		total = sum((Integer n ) -> n%2 != 0, list);
		System.out.println("홀수합 : " + total);
	}// end of main
	
	public static double avg(Predicate<Human> ph, List<Human> li) {
		int pCount = 0;//전달된 객체의 성별에 따라 인원 수 카운트
		int tCount = 0;//점수를 누적해서더해 총점 저장하기 위한 변수
		for(Human h: li) {//li 컬렉션의 크기만큼 반복
			if(ph.test(h)==true) {
				/*
				 첫번째 호출에서는 남자일 때 true를 반환한다. 즉, 남자의 점수가 카운트됨.
				 두번째 호출은 여자.
				 */
				pCount++;//인원수 증가
				tCount += h.getScore();//점수를 합산
			}
		}
		return (double)tCount/ pCount;//평균값 계산후 반환
	}
	
	public static int sum(Predicate<Integer> p,List<Integer> list) {
		int sum = 0;
		for(int a : list) {
			if(p.test(a)) {
				sum+=a;
			}
		}
		return sum;
	}

}
