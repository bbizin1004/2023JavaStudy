package ex15usefullclass;

/*
Wrapper 클래스
:기본자료형의 데이터를 인스턴스화 할때 사용하는 클래스로 Boxing 혹은
Unboxing을 통해 기본자료형의 데이터를 인스턴스화한다. 뒤에서 학습할
제네릭 클래스에서 필수적으로 사용된다.
 */

public class E01WrapperClass1 {

	public static void main(String[] args) {
		
		//일반적인 정수의 연산
		int num1 = 10;
		int num2 = 20;
		int result = num1 + num2;
		System.out.println("result=" + result);
		
		
		/*
		 JDK 1.4 이전의 코딩형태
		 기본자료형을 박싱 처리한 인스턴스에 대해서 산술연산을 진행할때
		 언박싱을 위해 intValue()와 같은 메소드를 호출해야한다.
		 */
		
		//현재는 이와같은 생성자는 Deprecated(디플리케이트) 되었다.
		Integer n10Obj = new Integer(10);
		//구버전과의 호환성을 위해 아직 남겨져있는 상태이다.
		Integer n20Obj = new Integer(num2);
		int result2 = n10Obj.intValue() + n20Obj.intValue();
		System.out.println("result2=" + result2);
		
		Integer resultObj = new Integer(result2);
		System.out.println("결과값을 byte형 값으로 변경:" + resultObj.byteValue());
		System.out.println("결과값을 이진수로 변경:" + Integer.toBinaryString(result2));
		
		/*
		 JDK1.5 이후 버전에서의 코딩형태
		 오토박싱 혹은 언박싱이 지원되므로 기본자료형 변수를 선언하는것과 
		 동일하게 코딩할 수 있다.
		 */
		Integer numObj1 = 100;
		Integer numObj2 = 200;
		int num3 = numObj1;
		//인스턴스이지만 정수처럼 연산이 가능하다.
		int result3 = numObj1 - numObj2;
		System.out.println("오토언박싱 이후 연산결과:" + result3);
		
		
		//int형의 최대/최소 범위를 가진 상수를 제공
		System.out.println("int형의 최대값:" + Integer.MAX_VALUE);
		System.out.println("int형의 최소값:" + Integer.MIN_VALUE);
		//진법 변환을 위한 메서드를 제공
		System.out.println("10을 2진수로:" + Integer.toBinaryString(10));
		System.out.println("10을 8진수로:" + Integer.toOctalString(10));
		System.out.println("10을 16진수로:" + Integer.toHexString(10));

	}

}
