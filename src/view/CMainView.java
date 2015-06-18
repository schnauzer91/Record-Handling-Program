package view;

import java.util.Scanner;

import main.Constant;
import main.Constant.EEvent;
import main.Constant.EMainView;
import entity.VUser;
import exception.InputTypeNotMatchException;

public class CMainView extends CView {

	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {

		int select;
		try{
			System.out.println("[" + title + "]");
			for(EMainView eView : EMainView.values()){
				System.out.println(eView.getEventID().ordinal() + ". " + eView.getTitle());
			}
			System.out.print(Constant.MENUSELECTION + ": ");
			select = scanner.nextInt();
			select = selectcheck(select, vuser);
			EEvent selection = EEvent.values()[select];
			this.setVuser(vuser);
			return selection;
		}catch(java.util.InputMismatchException e){
			try {
				throw new InputTypeNotMatchException();
			} catch (InputTypeNotMatchException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		String temp = scanner.next();
		EEvent selection = EEvent.values()[3];
		return selection;
	}

	@Override
	public int selectcheck(int select, VUser vuser) {
		if(select>=0 && select <= 2){
			return select;
		}
		System.out.println("�������� ���� �ƴմϴ�.");
		return 3;
	}
	
}