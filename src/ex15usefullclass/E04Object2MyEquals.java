package ex15usefullclass;

/*
equals() 메서드
-자바에서 인스턴스의 내용 비교를 위해 비교연사자(==)를 사용하는 것은
단순히 참조값에 대한 비교를 하는것이므로, 실제 내용에 대한 비교가
이뤄지지 않는다.
-인스턴스간의 내용 비교를 위해서는 equals() 메서드를 각 클래스에
맞게 오버라이딩 하여 사용해야한다.
-String과 같은 기본 클래스는 별도의 오버라이딩 없이도 내용 비교가
가능하다.
 */

class IntNumber {
	int num;
	public IntNumber(int num) {
		this.num = num;
	}
	public boolean myEquals(IntNumber numObj) {
		if (this.num == numObj.num) {
			return true;
		} else {
			return false;
		}
	}
}

public class E04Object2MyEquals {

	public static void main(String[] args) {

		String str1 = new String("Java개발자");
		String str2 = "Java개발자";
		if (str1.equals(str2)) {
			System.out.println("같은 문자열 입니다.");
		} else {
			System.out.println("다른 문자열 입니다.");
		}

		IntNumber num1 = new IntNumber(10);
		IntNumber num2 = new IntNumber(20);
		IntNumber num3 = new IntNumber(30);

		if (num1.myEquals(num2)) {
			System.out.println("num1과 num2는 동일한 정수");
		} else {
			System.out.println("num1과 num2는 다른 정수");
		}

		if (num1.myEquals(num3)) {
			System.out.println("num1과 num3는 동일한 정수");
		} else {
			System.out.println("num1과 num3는 다른 정수");
		}
	}

}
