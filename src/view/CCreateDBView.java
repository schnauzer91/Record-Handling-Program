package view;

import java.util.Scanner;

import control.CCreateDBControl;
import main.Constant.EEvent;
import entity.VUser;

public class CCreateDBView extends CView {
	public CCreateDBView(){
		this.setControl(new CCreateDBControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		((CCreateDBControl)this.getControl()).create();
		System.out.println("DB설정 완료");
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
