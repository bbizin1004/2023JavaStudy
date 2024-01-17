package ex17collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Ex08AsList {
	
	
	//컬렉션을 매개변수로 받은 후 전체항목을 출력한다.
	public static void listprint(String title, List<String> list) {
		//제목 출력
		System.out.println("#" + title);
		/*확장 for문으로 전체를 출력한다. 출력할 인스턴스가 String 이므로 별도의 오버라이딩
		  없이도  내용을 출력할 수 있다. 만약 우리가 직접 정의한 클래스라면 toString()을 
		  오버라이딩 해야한다. */
		for (Object ob : list) {
			System.out.print(ob + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		/*
		 String 인스턴스 배열을 생성과 동시에 초기화한다. 이 경우
		 초기데이터를 통해 크기를 유추할 수 잇으므로 크기는 생략해야한다.
		 */
		String[] strArr = new String[] {"마린","파이어뱃","메딕","마린"};
		
		/*
		 Arrays.asList() : 일반적인 배열을 List<E> 컬렉션으로
		 	변경한 후 반환한다. 단, 값을 참조만 할수있고 입력이나 
		 	삭제는 할수없다.
		 */
		
		List<String> list= Arrays.asList(strArr);
		listprint("출력1", list);
		//현채 상태에서는 데이터를 추가할 수 없다. 런타임에러 발생됨.
		//list.add("탱크");
		
		
		/*
		 ArrayList<E> 의 생성자를 통해 앞에서 만든 인스턴스를 복사하면 
		 데이터를 변경할 수 있다.
		 */
		list = new ArrayList<String>(list);
		//복사한 이후에는 데이터를 추가할 수 있다.
		boolean isAdd = list.add("탱크");
		System.out.println("add결과:"+ isAdd);
		listprint("출력2", list);
		
		/*
		 이터레이터를 for문을 이용해서 출력한다.
		 for( 초기값; 조건식; 증감식){
		 	실행문장-> next()가 증감식을 대체하는 형식으로 작성한다.
		 }
		 */
		System.out.println("# 출력3");
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
			System.out.print(itr.next()+ " ");
		}
		System.out.println();
		
		/*
		 Set<E> 컬렉션은 중복을 허용하지 않으므로 List에 저장된
		 중복값을 제거할 수 있다. 단, 출력 순서는 변경될 수 있다.
		 */
		HashSet<String> set =new HashSet<String>(list);
		list = new ArrayList<String>(set);
		listprint("출력4", list);
	}

}
