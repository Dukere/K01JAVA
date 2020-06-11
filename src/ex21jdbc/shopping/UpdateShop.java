package ex21jdbc.shopping;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.callable.DeleteProcCall;
import ex21jdbc.connect.IConnectImpl;

public class UpdateShop extends IConnectImpl {
	
	public UpdateShop() {
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
			csmt = con.prepareCall("{call ShopUpdateGoods(?,?,?,?,?)}");
			//2-1. in파라미터 설정
			csmt.setString(1, scanValue("상품명"));
			csmt.setString(2, scanValue("가격"));
			csmt.setString(3, scanValue("제품코드"));
			csmt.setString(4, scanValue("수정할 상품의 일련번호"));
			//2-2. out파라미터 설정(반환값의 자료형을 설정함)
			csmt.registerOutParameter(5, Types.VARCHAR);
			//3. 실행
			csmt.execute();

			System.out.println("삭제 프로시저 실행 결과 : ");
			System.out.println(csmt.getString(5));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new UpdateShop().execute();
	}
}