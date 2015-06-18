package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import DAOs.IDAO;
import DAOs.MySQL;
import entity.CGangjwa;
import entity.CSugang;
import entity.VUser;

public class CSetgradeControl extends CControl {

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

	public Vector<CSugang> getSugang(String select) {
		Vector<CSugang> suganglist = new Vector<CSugang>();
		IDAO dao;
		
		try {
			dao = new MySQL();
			dao.connect("sugang", "r");
			dao.selectData("sugang");
			suganglist = dao.SugangRead(select, "prof");
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

	public void Setgrade(String gangjwaId, String StuId, String hakjeom) {
		IDAO dao;
		
		try {
			dao = new MySQL();
			dao.connect("sugang", "r");
			dao.updateHakjeom(gangjwaId, StuId, hakjeom);
			dao.disconnect();
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
	}

	public int checkGangjwa(Vector<CGangjwa> gangjwalist) {
		int check = 0;
		for(CGangjwa gangjwa:gangjwalist){
			check++;
		}
		return check;
	}

	public int checkStudent(Vector<CSugang> suganglist) {
		int check = 0;
		for(CSugang sugang:suganglist){
			check++;
		}
		return check;
	}

	public int checkid(String stuId, Vector<CSugang> suganglist) {
		int check = 0;
		for(CSugang sugang:suganglist){
			if(sugang.getId().equals(stuId)){
				check = 1;
			}
		}
		return check;
	}

	public int checkGangjwa(String gangjwaId, Vector<CGangjwa> gangjwalist) {
		int check = 0;
		for(CGangjwa gangjwa:gangjwalist){
			if(gangjwa.getId().equals(gangjwaId)){
				check = 1;
			}
		}
		return check;
	}

	public int checkHakjeom(String hakjeom) {
		int check = 0;
		if(hakjeom.equals("A+") || hakjeom.equals("A0") || hakjeom.equals("B+") || hakjeom.equals("B0") || hakjeom.equals("C+") || hakjeom.equals("C0") || hakjeom.equals("F")){
			check = 1;
		}
		return check;
	}

}
