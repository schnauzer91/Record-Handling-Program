package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import DAOs.IDAO;
import DAOs.MySQL;
import entity.CGangjwa;
import entity.VUser;

public class CGetclassControl extends CControl {

	public Vector<CGangjwa> getGangjwa(VUser vuser) {
		Vector<CGangjwa> gangjwalist = new Vector<CGangjwa>();
		IDAO dao;
		try {
			dao = new MySQL();
			dao.connect("gangjwa", "r");
			dao.selectData("gangjwa");
			gangjwalist = dao.GangjwaRead(vuser.getUserID());
			dao.disconnect();
			return gangjwalist;
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
