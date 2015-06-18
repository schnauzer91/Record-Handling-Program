package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import main.Constant.EEvent;
import control.CLoginControl;
import entity.VLogin;
import entity.VUser;
import entity.VUser.EUserType;
import exception.PasswordNotMatchException;
import exception.UserIDNotFoundException;

public class CLoginView extends CView {
	public CLoginView(){
		this.setControl(new CLoginControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser){
		// input from keyboard using scanner
		VLogin vLogin = new VLogin();
		System.out.print("ID : ");
		String userId = scanner.next();	
		System.out.print("Password : ");	
		String password = scanner.next();
		vLogin.setUserID(userId);		
		vLogin.setPassword(password);

		VUser vUser;
		EEvent selection = null;
		try {
			vUser = ((CLoginControl)this.getControl()).login(vLogin);
			System.out.println("로그인되었습니다.");
			this.setVuser(vUser);
			if(vUser.geteUserType() == EUserType.EProfessor){
				selection = EEvent.eProfessor;
			}else if(vUser.geteUserType() == EUserType.EStudent){
				selection = EEvent.eStudent;
			}else{
				selection = EEvent.eLogout;
			}
		} catch (UserIDNotFoundException | PasswordNotMatchException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selection;
	}
	@Override
	public int selectcheck(int select, VUser vuser) {
		// TODO Auto-generated method stub
		return 0;
	}
}
