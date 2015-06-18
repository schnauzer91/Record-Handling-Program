package view;

import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CSignupControl;
import entity.CUser;
import entity.VUser;
import exception.InputTypeNotMatchException;

public class CSignupEView extends CView {
	public CSignupEView(){
		this.setControl(new CSignupControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		CUser user = new CUser();
		Vector<CUser> users = new Vector<CUser>();
		users = ((CSignupControl)this.getControl()).getUsers();
		int check;
		try{
			System.out.print("아이디 : ");
			String id = scanner.next();
			check = ((CSignupControl)this.getControl()).checkUser(id, users);
			while(check == 1){
				System.out.println("이미 사용중인 아이디 입니다. 재입력 바랍니다.");
				System.out.print("아이디 : ");
				id = scanner.next();
				check = ((CSignupControl)this.getControl()).checkUser(id, users);
			}
			System.out.print("비밀번호 : ");
			String pw = scanner.next();
			System.out.print("이름 : ");
			String name = scanner.next();
			System.out.print("사용자타입(학생일시 1, 교수일시 2 입력) : ");
			int typeint = scanner.nextInt();
			String type;
			if(typeint == 1){
				type = "stu";
			}else if(typeint == 2){
				type = "prof";
			}else{
				System.out.println("1,2이외의 수를 입력하셨으므로 학생으로 간주합니다.");
				type = "stu";
			}
			user.setID(id);
			user.setName(name);
			user.setPassword(pw);
			user.setType(type);
			
			((CSignupControl)this.getControl()).signup(user);
			this.setVuser(vuser);
			System.out.println("회원가입되었습니다.");
			EEvent selection = EEvent.eSignUp;
		}catch(java.util.InputMismatchException e){
			try {
				throw new InputTypeNotMatchException();
			} catch (InputTypeNotMatchException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.setVuser(vuser);
		EEvent selection = EEvent.eSignUp;
		return selection;
	}

	@Override
	public int selectcheck(int select, VUser vuser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
