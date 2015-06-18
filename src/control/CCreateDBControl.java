package control;

import java.io.IOException;
import java.sql.SQLException;

import DAOs.IDAO;
import DAOs.MySQL;

public class CCreateDBControl extends CControl {

	public void create() {
		IDAO dao;
		
		try {
			dao = new MySQL();
			dao.createAccount();
			dao.createDB("");
			dao.createTable("");
			dao.insertData("");
			dao.disconnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
