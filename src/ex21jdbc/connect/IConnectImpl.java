package ex21jdbc.connect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectImpl implements IConnect {

	//동적 쿼리 처리를 위한 객체
	public PreparedStatement psmt;
	//프로시져 혹은 함수를 호출하기 위한 객체
	public CallableStatement csmt;
	public Statement stmt;
	
	public Connection con;
	public ResultSet rs;
	
	public IConnectImpl() {
		System.out.println("IConnetImpl 기본생성자 호출");
	}
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnetImpl 인자생성자 호출");
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
		} 
		catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}

	@Override
	public void execute() {
		//하는일 없음
	}

	@Override
	public void close() {
		try {
			if(con != null) con.close();
			if(psmt != null) psmt.close();
			if(csmt != null) csmt.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			System.out.println("자원 반납 완료");
		} 
		catch (Exception e) {
			System.out.println("자원 반납 시 오류발생");
			e.printStackTrace();
		}
	}

	@Override
	public String scanValue(String title) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print(title + "을(를) 입력(exit -> 종료) : ");
		String inputStr = scan.nextLine();
		
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			//프로그램 자체가 즉시 종료된다.
			System.exit(0);
		}
		
		return inputStr;
	}
	
}
