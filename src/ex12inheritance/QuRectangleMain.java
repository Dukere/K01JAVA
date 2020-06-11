package ex12inheritance;

class Rectangle {
	int x, y;

	public Rectangle(int a, int b) {
		x = a;
		y = b;
	}

	public void ShowAreaInfo() {
		System.out.println("직사각형의 면적 : " + x * y);
	}
}

class Square extends Rectangle {

	public Square(int a) {
		super(a, a);
	}
	
	/*
	 오버라이딩해야함.
	 */
	public void ShowAreaInfo() {
		System.out.println("정사각형의 면적 : " + x * y);
	}
}

public class QuRectangleMain {

	public static void main(String[] args) {
		Rectangle rec = new Rectangle(4, 3);
		rec.ShowAreaInfo();

		Square sqr = new Square(7);
		sqr.ShowAreaInfo();
	}

}
