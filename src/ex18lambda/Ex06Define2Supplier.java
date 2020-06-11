package ex18lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Ex06Define2Supplier {

	//난수 생성
	public static List<Integer> makeRandomNum(Supplier<Integer> s, int cnt){
		
		List<Integer> li = new ArrayList<Integer>();
		//cnt크기만큼 반복하면서 난수를 생성 후 List에 저장
		for(int i = 1;i<=cnt; i++) {
			li.add(s.get());
		}
		return li;
	}
	public static void main(String[] args) {
		
		//get()메소드를 오버라이딩한 람다식. 난수 생성해 반환.
		Supplier<Integer> sup = () -> {
			Random random = new Random();
			return random.nextInt(100);
		};
		int rNum = sup.get();/* get()메소드가 반환하는 Integer객체를
								Auto 언박싱해서 int형 변수에 저장.
								*/
		System.out.println("생성된 난수 = " + rNum);
		
		//10개 난수 만들어 List로 반환받음
		List<Integer> list = makeRandomNum(sup,10);
		System.out.println("###print문으로 출력1");
		System.out.println(list);
		
		System.out.println("###foreach문으로 출력2");
		for(Integer i : list) {
			System.out.printf("%d ", i);
		}
		System.out.println();
		
		System.out.println("###이터레이터로 출력3");
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

	}

}
