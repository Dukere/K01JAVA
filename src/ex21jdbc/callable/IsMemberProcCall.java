package ex21jdbc.callable;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;


public class IsMemberProcCall extends IConnectImpl {
	
	public IsMemberProcCall() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		try {
			//1.콜러블객체생성
			/*
			 프로시져는 반환값이 없으므로 함수처럼 ?=로 시작하지 않음
			 return값 대신 out파라미터를 통해 값을 반환받음.
			 
			 */
			csmt = con.prepareCall("{call KosmoMemberAuth(?,?,?)}");
			//2-1. in파라미터 설정
			csmt.setString(1, scanValue("회원 아이디"));
			csmt.setString(2, scanValue("회원 패스워드"));
			//2-2. out파라미터 설정(반환값의 자료형을 설정함)
			csmt.registerOutParameter(3, Types.NUMERIC);
			//3. 실행
			csmt.execute();

			int outParamResult = csmt.getInt(3);
			switch(outParamResult) {
			case 0:
				System.out.println("아이디 없음");
				break;
			case 1:
				System.out.println("패스워드 일치하지 않음");
				break;
			case 2:
				System.out.println("회원 확인");
				break;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new IsMemberProcCall().execute();
	}
}
