package entity;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CGangjwa extends CEntity {//ID, NAME, PROF_ID
	private String id;
	private String name;
	private String prof_ID;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getProf_ID() {return prof_ID;}
	public void setProf_ID(String prof_ID) {this.prof_ID = prof_ID;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	@Override
	public void read(Scanner scanner) throws NoSuchElementException,
			IllegalStateException {
		id = scanner.next();
		name = scanner.next();
		prof_ID = scanner.next();

	}

	@Override
	public void write(BufferedWriter bufferWriter) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void DBRead(ResultSet resultSet) throws SQLException {
		id = resultSet.getString("id");
		name = resultSet.getString("name");
		prof_ID = resultSet.getString("prof_id");
	}

	@Override
	public void DBWrite(PreparedStatement pstmt) throws SQLException {
		// TODO Auto-generated method stub

	}

}
