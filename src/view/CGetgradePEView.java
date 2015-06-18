package view;

import java.util.Scanner;
import java.util.Vector;

import control.CGetclassControl;
import control.CGetgradePControl;
import control.CGetgradeSControl;
import control.CSetgradeControl;
import entity.CGangjwa;
import entity.CSugang;
import entity.VUser;
import main.Constant.EEvent;

public class CGetgradePEView extends CView {
	public CGetgradePEView(){
		this.setControl(new CGetgradePControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		Vector<CSugang> suganglist = new Vector<CSugang>();
		Vector<CGangjwa> gangjwalist = new Vector<CGangjwa>();
		int check;
		gangjwalist = ((CGetgradePControl)this.getControl()).getGangjwa(vuser);
		System.out.println("���¹�ȣ �����̸�");
		for(CGangjwa gangjwa: gangjwalist){
			System.out.println(gangjwa.getId() + " " + gangjwa.getName());
		}
		check = ((CGetgradePControl)this.getControl()).checkGangjwa(gangjwalist);
		if(check == 0){//�������°�������
			System.out.println("������ ���°� �����ϴ�.");
			this.setVuser(vuser);
			EEvent selection = EEvent.eSetGrade;
			return selection;
		}
		
		System.out.println("���¹�ȣ�� ������ �ּ���");
		String select = scanner.next();
		
		check = ((CGetgradePControl)this.getControl()).checkGangjwa(select, gangjwalist);
		while(check == 0){
			System.out.print("���°����Դϴ� ���Է� ���ּ��� : ");
			select = scanner.next();
			check = ((CGetgradePControl)this.getControl()).checkGangjwa(select, gangjwalist);
		}
		
		suganglist = ((CGetgradePControl)this.getControl()).getSugang(select);
		check = ((CGetgradePControl)this.getControl()).checkStudent(suganglist);
		if(check == 0){//�����л��� ������
			System.out.println("���� �������� �л��� �����ϴ�.");
			this.setVuser(vuser);
			EEvent selection = EEvent.eSetGrade;
			return selection;
		}
		System.out.println("�л����̵� ����");
		for(CSugang sugang: suganglist){
			System.out.println(sugang.getId() + " " + sugang.getHakjeom());
		}
		
		
		this.setVuser(vuser);
		EEvent selection = EEvent.eGetGradeP;
		return selection;
	}

	@Override
	public int selectcheck(int select, VUser vuser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
