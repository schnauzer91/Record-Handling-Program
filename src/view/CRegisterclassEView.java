package view;

import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CRegisterclassControl;
import entity.CGangjwa;
import entity.CSugang;
import entity.VUser;

public class CRegisterclassEView extends CView {
	public CRegisterclassEView(){
		this.setControl(new CRegisterclassControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		Vector<CGangjwa> gangjwalist = new Vector<CGangjwa>();
		Vector<CSugang> suganglist = new Vector<CSugang>();
		gangjwalist = ((CRegisterclassControl)this.getControl()).getGangjwa();
		suganglist = ((CRegisterclassControl)this.getControl()).getSugang(vuser);
		
		System.out.println("���¹�ȣ ���¸�");
		for(CGangjwa gangjwa: gangjwalist){
			System.out.println(gangjwa.getId() + " " + gangjwa.getName());
		}
		System.out.print("������ ���¹�ȣ�� �Է��ϼ��� : ");
		String select = scanner.next();
		int checking = ((CRegisterclassControl)this.getControl()).check(select, gangjwalist, suganglist);
		checking = 0;
		while(checking != 0){
			if(checking == 1){
				System.out.print("���°����Դϴ� ���Է����ּ��� : ");
			}else if(checking == 2){
				System.out.print("�̹̼������� �����Դϴ� ���Է� ���ּ��� : ");
			}
			select = scanner.next();
			checking = ((CRegisterclassControl)this.getControl()).check(select, gangjwalist, suganglist);
		}
		
		
		((CRegisterclassControl)this.getControl()).Registerclass(vuser, select);
		System.out.println("������û�Ǿ����ϴ�.");
		
		this.setVuser(vuser);
		EEvent selection = EEvent.eRegisterClass;
		return selection;
	}

	@Override
	public int selectcheck(int select, VUser vuser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
