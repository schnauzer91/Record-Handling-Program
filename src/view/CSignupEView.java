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
			System.out.print("���̵� : ");
			String id = scanner.next();
			check = ((CSignupControl)this.getControl()).checkUser(id, users);
			while(check == 1){
				System.out.println("�̹� ������� ���̵� �Դϴ�. ���Է� �ٶ��ϴ�.");
				System.out.print("���̵� : ");
				id = scanner.next();
				check = ((CSignupControl)this.getControl()).checkUser(id, users);
			}
			System.out.print("��й�ȣ : ");
			String pw = scanner.next();
			System.out.print("�̸� : ");
			String name = scanner.next();
			System.out.print("�����Ÿ��(�л��Ͻ� 1, �����Ͻ� 2 �Է�) : ");
			int typeint = scanner.nextInt();
			String type;
			if(typeint == 1){
				type = "stu";
			}else if(typeint == 2){
				type = "prof";
			}else{
				System.out.println("1,2�̿��� ���� �Է��ϼ����Ƿ� �л����� �����մϴ�.");
				type = "stu";
			}
			user.setID(id);
			user.setName(name);
			user.setPassword(pw);
			user.setType(type);
			
			((CSignupControl)this.getControl()).signup(user);
			this.setVuser(vuser);
			System.out.println("ȸ�����ԵǾ����ϴ�.");
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
