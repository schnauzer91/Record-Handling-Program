package entity;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CSugang extends CEntity {
	private String id;
	private String gangjwa_id;
	private String hakjeom;
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getGangjwa_id() {return gangjwa_id;}
	public void setGangjwa_id(String gangjwa_id) {this.gangjwa_id = gangjwa_id;}
	public String getHakjeom() {return hakjeom;}
	public void setHakjeom(String hakjeom) {this.hakjeom = hakjeom;}

	@Override
	public void read(Scanner scanner) throws NoSuchElementException,
			IllegalStateException {
		id = scanner.next();
		gangjwa_id = scanner.next();
		hakjeom = scanner.next();

	}

	@Override
	public void write(BufferedWriter bufferWriter) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void DBRead(ResultSet resultSet) throws SQLException {
		id = resultSet.getString("id");
		gangjwa_id = resultSet.getString("gangjwa_id");
		if(resultSet.getString("hakjeom") != null){
			hakjeom = resultSet.getString("hakjeom");
		}else{
			hakjeom = "미입력상태";
		}

	}

	@Override
	public void DBWrite(PreparedStatement pstmt) throws SQLException {
		// TODO Auto-generated method stub

	}

}
