package task;

class Point {
	int xDot, yDot;

	public Point(int x, int y) {
		xDot = x;
		yDot = y;
	}

	public void showPointInfo() {
		System.out.println("[x좌표:" + xDot + ", y좌표" + yDot + "]");
	}
}

class Circle {
	int radian;//반지름
	Point center;
	
	//생성자
	public Circle(int x, int y, int r) {
		radian = r;
		center = new Point(x, y);

	}

	public void showRadianInfo() {
		System.out.println("반지름:" + radian);
		center.showPointInfo();
	}

}

class Ring {
	Circle innerCircle;
	Circle outerCircle;

	public Ring(int x, int y, int r, int a, int b, int c) {
		innerCircle = new Circle(x, y, r);
		outerCircle = new Circle(a, b, c);
	}
	public void showRingInfo() {
		System.out.println("안쪽원의 정보:");
		innerCircle.showRadianInfo();
		System.out.println("바깥쪽원의 정보:");
		outerCircle.showRadianInfo();
	}
}

class QuRingMake {
	public static void main(String[] args) {
		Ring c = new Ring(1, 1, 3, 2, 2, 9);
		c.showRingInfo();
	}
}
