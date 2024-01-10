package ex12inheritance;

//Animal 클래스정의 
//동물의 일반적인 특성을 표현하는 클래스를 정의하시오.
//멤버변수 : 
//	동물의 종류(포유류, 어류, 조류 등)->species
//	나이->age
//	성별->gender
//멤버메소드 : 
//	showAnimal() : 멤버변수를 출력하는 용도
//인자생성자 : 
//	멤버변수 3개 모두를 초기화할수 있도록 정의
//
//※1차완성후 species를 private로 선언후 적절히 수정한다.(첫 작성시에는 public으로 만들어 주세요.)
//
//
//AnimalDog 클래스 정의
//강아지를 표현한 클래스 
//- Dog is a Animal이 성립하므로 상속관계로 표현하기에 
//	적합한 모델	
//멤버변수
//	강아지의종류 : 푸들, 포매라니안 등 -> dogKind
//	이름 -> name
//멤버메소드
//	bark() : 강아지가 짖는것을 표현
//		출력결과 : 이름이 XX이고 종(포유류)이 
//			YY인 강아지가 짖는다.
//	showDog() : 강아지의 현재상태(멤버변수)를 출력하는 
//		메소드
//인자생성자
//	: 부모클래스까지 초기화할수 있도록 구성할 것


public class AnimalMain {

	public static void main(String[] args) {
		//강아지 객체생성
		AnimalDog dog = new AnimalDog("포유류",2,"수컷","포매라니안","뽀미");
		
		dog.showAnimal();
		System.out.println("====================");
		dog.bark();
		System.out.println("====================");
		dog.showDog();
	}

}
