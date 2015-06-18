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
		System.out.print("���¹�ȣ : ");
		String id = scanner.next();
		check = ((CCreateclassControl)this.getControl()).checkGangjwa(id, gangjwalist);
		while(check == 1){
			System.out.println("���¹�ȣ�� �̹� �ֽ��ϴ�. �ٸ� ��ȣ�� �Է��ϼ���.");
			System.out.print("���¹�ȣ : ");
			id = scanner.next();
			check = ((CCreateclassControl)this.getControl()).checkGangjwa(id, gangjwalist);
		}
		System.out.print("���¸� : ");
		String name = scanner.next();
		String prof_ID = vuser.getUserID();
		gangjwa.setID(id);
		gangjwa.setName(name);
		gangjwa.setProf_ID(prof_ID);
		
		((CCreateclassControl)this.getControl()).createclass(gangjwa);
		System.out.println("���°����Ǿ����ϴ�.");
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
