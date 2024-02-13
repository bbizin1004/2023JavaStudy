package ex21jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyConnection implements IConnect {
	
	/*
	 멤버변수 : JDBC 작업을 위해 필요한 여러가지 인스턴스를 정의
	 	DB연결, select결과의 반환, 정적쿼리문 실행,동적쿼리문 실행,
	 	프로시져 실행의 기능을 수행한다.
	 */
	
	/*
	 Statement 인터페이스 사용
	 Statement 객체는 단순한 정적SQL문을 사용할 경우에 좋다.
	 SQL문을 직접적으로 작성하기 때문에 쉽게 분석할 수 있다.
	 단점
	 SQL문이 문자열로 작성되기 문자열과 같은 값을 넣기위해 작은따옴표(')등의 처리를 직접 처리해야한다.
	 작성된 SQL문을 재사용하기 어렵다.
	 
	 PreparedStatement 인터페이스 사용
	 sql문장을 미리 컴파일할 수 있도록 개선되었다.
	 작은따옴표(')같은 문자열 등을 자동적으로 처리한다.
	 재사용하기 편리하다.
	 미리 컴파일되기 때문에 쿼리의 수행 속도가 Statement 객체에 비해 빠르다.
	  
	 CallableStatement 인터페이스 사용
	 Connection 객체의 prepareCall() 메소드를 사용해서 객체를 생성한다. 
	 CallableStatement 객체는 주로 저장프로시저(Stored Procedure)를 
	 호출하기 위해 사용된다.
	*/
	

	public Connection con;
	public ResultSet rs; //select 결과의 반환
	public Statement stmt; //정적쿼리문을 처리할때 빠른 객체
	public PreparedStatement psmt;//동적쿼리문을 처리할때 빠른 객체
	public CallableStatement csmt;//프로시저를 호출하도록 도와주는 객체
	
	//생성자 : 사용자 계정과 패스워드를 전달받아 DB에 연결한다.
	public MyConnection(String user,String pass) {
		try {
			//드라이버 로드
			Class.forName(ORACLE_DRIVER);
			//오라클 연결(접속)
			con = DriverManager.getConnection(ORACLE_URL,user,pass);
		} catch (Exception e) {
			System.out.println("DB 커넥션 예외발생");
			e.printStackTrace();
		}
	}
	
	/*
	 CRUD에 대한 작업은 하위 클래스에서 구현할 예정이므로 구현부가
	 없는 상태로 오버라이딩만 해놓는다.
	 */
	@Override
	public void dbExecute() {}
	
	//DB자원 반납을 위한 메서드
	@Override
	public void dbClose() {
		try {
			if(con!=null)con.close();
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(psmt!=null)psmt.close();
			if(csmt!=null)csmt.close();
			System.out.println("DB 자원 반납");
		} catch (Exception e) {
			System.out.println("DB 자원 반납시 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	//사용자로부터 입력값을 받기위한 메서드
	public String inputValue(String title) {
		Scanner scan = new Scanner(System.in);
		System.out.print(title + "을(를) 입력(exit-> 종료):");
		String inputStr =scan.nextLine();
		/*입력값으로 대소문자 구분없이 exit 라고 입력하면 즉시 자원을 반납하고
		  프로그램을 종료한다.*/
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			dbClose();
			System.exit(0);
		}
		//종료가 아니라면 입력값을 호출한 지점으로 반환한다.
		return inputStr;
	}
	
	

}
