package control;

import java.io.IOException;
import java.sql.SQLException;

import DAOs.IDAO;
import DAOs.MySQL;
import entity.CUser;
import entity.VLogin;
import entity.VUser;
import entity.VUser.EUserType;
import exception.PasswordNotMatchException;
import exception.UserIDNotFoundException;

public class CLoginControl extends CControl {
	public VUser login(VLogin vLogin) 
			throws UserIDNotFoundException, 
					PasswordNotMatchException, IOException {
		// TODO Auto-generated method stub
		VUser vUser = new VUser();
		CUser user = new CUser();
			IDAO dao;
			try {
				dao = new MySQL();
				dao.connect("member","r");
				dao.selectData("member");
				user = (CUser)dao.read(user, vLogin.getUserID());
				dao.disconnect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (java.lang.NullPointerException e){
				throw new UserIDNotFoundException();
			}
		
		if (user==null) 
			throw new UserIDNotFoundException();
		if (!user.getPassword().equals(vLogin.getPassword())) 
			throw new PasswordNotMatchException();
		
		vUser.setName(user.getName());
		vUser.setUserID(user.getID());
		vUser.setType(user.getType());
		
		if(vUser.getType().equals("stu")){
			vUser.seteUserType(EUserType.EStudent);
		}else{
			vUser.seteUserType(EUserType.EProfessor);
		}
		return vUser;
	}
}
