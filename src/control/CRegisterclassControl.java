package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import DAOs.IDAO;
import DAOs.MySQL;
import entity.CGangjwa;
import entity.CSugang;
import entity.VUser;

public class CRegisterclassControl extends CControl {

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

	public void Registerclass(VUser vuser, String select) {
		IDAO dao;
		
		try {
			dao = new MySQL();
			dao.connect("sugang", "r");
			dao.insertSugang(vuser.getUserID(), select);
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

	public int check(String select, Vector<CGangjwa> gangjwalist, Vector<CSugang> suganglist) {
		int checking = 0;
		for(CGangjwa gangjwa: gangjwalist){
			if(gangjwa.getId().equals(select)){
				checking = 0;
			}
			checking = 1;
		}
		for(CSugang sugang: suganglist){
			if(sugang.getGangjwa_id().equals(select)){
				checking = 2;
			}
		}
		return checking;
	}

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
