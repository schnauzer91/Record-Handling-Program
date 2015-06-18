package view;

import java.util.Scanner;

import main.Constant;
import main.Constant.EEvent;
import main.Constant.EProfessorView;
import entity.VUser;
import exception.InputTypeNotMatchException;

public class CProfessorView extends CView {

	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		int select;
		try{
			System.out.println("[" + title + "]");
			for(EProfessorView eView : EProfessorView.values()){
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
		if(select==6 || select == 7 || select == 8 || select == 9 || select == 0 || select == 3){
			if(select == 3){
				vuser.setUserID(null);
				vuser.setName(null);
				vuser.setType(null);
			}
			return select;
		}
		System.out.println("범위내의 수가 아닙니다.");
		return 4;
	}

}