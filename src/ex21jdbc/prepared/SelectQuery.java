package ex21jdbc.prepared;

import java.sql.SQLException;

import ex21jdbc.connect.IConnectImpl;

public class SelectQuery extends IConnectImpl{

	public SelectQuery() {
		super("kosmo","1234");
	}
	@Override
	public void execute() {
		try
		{
			while(true)
			{
				String sql = "select * from member "
						//+ " where name like '%?%'";//부적합한 열 인덱스
						+ " where name like '%'||?||'%'";
				psmt = con.prepareStatement(sql);
				psmt.setString(1, scanValue("찾는 이름"));
				rs =psmt.executeQuery();
				while(rs.next()) {
					String id = rs.getString(1);
					String pass = rs.getString(2);
					String name = rs.getString(3);
					String regidate = rs.getString(4).substring(0,10);
					
					System.out.printf("%s %s %s %s \n", id, pass, name, regidate);
				}
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
		new SelectQuery().execute();
	}

}
