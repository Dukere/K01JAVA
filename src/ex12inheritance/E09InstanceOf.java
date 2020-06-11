package ex12inheritance;

class Box {
	public void boxWrap() {
		System.out.println("Box로 포장합니다.");
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("PaperBox로 포장합니다.");
	}
}
class GoldPaperBox extends PaperBox{
	public void goldWrap() {
		System.out.println("GoldPaperBox로 포장합니다.");
	}
}

public class E09InstanceOf {
	
	static void wrapBox(Box b) {
		int num1 = (int)1.0;
		double num2 = 1;
		
		if(b instanceof GoldPaperBox) {
			((GoldPaperBox) b).goldWrap();
		}
	
		else if(b instanceof PaperBox) {
			((PaperBox) b).paperWrap();
		}
		
		else if (b instanceof Box) {
			b.boxWrap();
		}
	}

	public static void main(String[] args) {
		
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		
		String str = new String ("나는 누구?");
//		wrapBox(str);

	}

}
