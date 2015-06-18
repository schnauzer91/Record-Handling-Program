package view;

import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CCreateclassControl;
import entity.CGangjwa;
import entity.VUser;

public class CCreateclassEView extends CView {
	public CCreateclassEView(){
		this.setControl(new CCreateclassControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		int check;
		Vector<CGangjwa> gangjwalist = new Vector<CGangjwa>();
		gangjwalist = ((CCreateclassControl)this.getControl()).getGangjwa();
		CGangjwa gangjwa = new CGangjwa();
		System.out.print("강좌번호 : ");
		String id = scanner.next();
		check = ((CCreateclassControl)this.getControl()).checkGangjwa(id, gangjwalist);
		while(check == 1){
			System.out.println("강좌번호가 이미 있습니다. 다른 번호를 입력하세요.");
			System.out.print("강좌번호 : ");
			id = scanner.next();
			check = ((CCreateclassControl)this.getControl()).checkGangjwa(id, gangjwalist);
		}
		System.out.print("강좌명 : ");
		String name = scanner.next();
		String prof_ID = vuser.getUserID();
		gangjwa.setID(id);
		gangjwa.setName(name);
		gangjwa.setProf_ID(prof_ID);
		
		((CCreateclassControl)this.getControl()).createclass(gangjwa);
		System.out.println("강좌개설되었습니다.");
		this.setVuser(vuser);
		EEvent selection = EEvent.eCreateClass;
		return selection;
	}

	@Override
	public int selectcheck(int select, VUser vuser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
