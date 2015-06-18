package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import DAOs.IDAO;
import DAOs.MySQL;
import entity.CUser;

public class CSignupControl extends CControl {

	public void signup(CUser user) {
		IDAO dao;
		
		try {
			dao = new MySQL();
			dao.connect("member", "r");
			dao.insertSignup(user.getID(), user.getPassword(), user.getName(), user.getType());
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

	public Vector<CUser> getUsers() {
		Vector<CUser> users = new Vector<CUser>();
		IDAO dao;
		
		try {
			dao = new MySQL();
			dao.connect("member", "r");
			dao.selectData("member");
			users = dao.UserRead();
			dao.disconnect();
			return users;
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

	public int checkUser(String id, Vector<CUser> users) {
		int check = 0;
		for(CUser user : users){
			if(user.getID().equals(id)){
				check = 1;
			}
		}
		return check;
	}

}
