package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import DAOs.IDAO;
import DAOs.MySQL;
import entity.CSugang;
import entity.VUser;

public class CGetgradeSControl extends CControl {

	public Vector<CSugang> getSugang(VUser vuser) {
		Vector<CSugang> suganglist = new Vector<CSugang>();
		IDAO dao;
		
		try {
			dao = new MySQL();
			dao.connect("sugang", "r");
			dao.selectData("sugang");
			suganglist = dao.SugangRead(vuser.getUserID(), vuser.getType());
			dao.disconnect();
			return suganglist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
