package entity;

import java.io.BufferedWriter;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CUser extends CEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String password;
	private String name;
	private String type;
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	public void read(Scanner scanner) {
		ID = scanner.next();
		password = scanner.next();
		name = scanner.next();
	};
	public void write(Scanner scanner) {		
	}
	@Override
	public void write(BufferedWriter scanner) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DBRead(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		ID = resultSet.getString("id");//user table에 있는 찾은 행중(이미 윗단에서 찾았다고 가정) id 컬럼을 가져온것이다.
		password = resultSet.getString("pw");
		name = resultSet.getString("name");
		type = resultSet.getString("type");
	}
	@Override
	public void DBWrite(PreparedStatement pstmt) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}






