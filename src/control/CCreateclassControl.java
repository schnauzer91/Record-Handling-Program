package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import DAOs.IDAO;
import DAOs.MySQL;
import entity.CGangjwa;

public class CCreateclassControl extends CControl {

	public void createclass(CGangjwa gangjwa) {
		IDAO dao;
		
		try {
			dao = new MySQL();
			dao.connect("gangjwa","r");
			dao.insertGangjwa(gangjwa.getID(), gangjwa.getName(), gangjwa.getProf_ID());
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

	public Vector<CGangjwa> getGangjwa() {
		Vector<CGangjwa> gangjwalist = new Vector<CGangjwa>();
		IDAO dao;
		try {
			dao = new MySQL();
			dao.connect("gangjwa", "r");
			dao.selectData("gangjwa");
			gangjwalist = dao.GangjwaRead("ALL");
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

	public int checkGangjwa(String id, Vector<CGangjwa> gangjwalist) {
		int check = 0;
		for(CGangjwa gangjwa:gangjwalist){
			if(gangjwa.getId().equals(id)){
				check = 1;
			}
		}
		return check;
	}

}
