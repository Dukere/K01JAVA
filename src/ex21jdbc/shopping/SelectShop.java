package ex21jdbc.shopping;

import java.sql.SQLException;
import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;

public class SelectShop extends IConnectImpl  {
	
	public SelectShop(String user, String pass) {
		super(user, pass);
	}
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("상품명을 입력하세요");
			String goods = sc.nextLine();
			
			String query = "SELECT g_idx, goods_name, to_char(goods_price,'999,999,999'), "
					+ " to_char(regidate, 'yyyy-mm-dd hh24:mi'), p_code FROM sh_goods "
					+ " where goods_name like '%"+ goods + "%' ";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String g_idx = rs.getString(1);
				String goods_name = rs.getString(2);
				String goods_price = rs.getString(3);
				String regidate = rs.getString(4);
				String p_code = rs.getString(5);
				
				
				System.out.println(g_idx+ " || " +goods_name+ " || " +goods_price+ " || " +regidate+ " || " +p_code);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new SelectShop("kosmo", "1234").execute();
	}

}
