package view;

import java.util.Scanner;
import java.util.Vector;

import control.CGetgradePControl;
import control.CSetgradeControl;
import entity.CGangjwa;
import entity.CSugang;
import entity.VUser;
import main.Constant.EEvent;

public class CSetgradeEView extends CView {
	public CSetgradeEView(){
		this.setControl(new CSetgradeControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		Vector<CSugang> suganglist = new Vector<CSugang>();
		Vector<CGangjwa> gangjwalist = new Vector<CGangjwa>();
		int check;
		gangjwalist = ((CSetgradeControl)this.getControl()).getGangjwa(vuser);
		System.out.println("���¹�ȣ �����̸�");
		for(CGangjwa gangjwa: gangjwalist){
			System.out.println(gangjwa.getId() + " " + gangjwa.getName());
		}
		check = ((CSetgradeControl)this.getControl()).checkGangjwa(gangjwalist);
		if(check == 0){//�������°�������
			System.out.println("������ ���°� �����ϴ�.");
			this.setVuser(vuser);
			EEvent selection = EEvent.eSetGrade;
			return selection;
		}
		System.out.print("���¹�ȣ�� ������ �ּ��� : ");
		String select = scanner.next();
		
		check = ((CSetgradeControl)this.getControl()).checkGangjwa(select, gangjwalist);
		while(check == 0){
			System.out.print("���°����Դϴ� ���Է� ���ּ��� : ");
			select = scanner.next();
			check = ((CSetgradeControl)this.getControl()).checkGangjwa(select, gangjwalist);
		}
		
		suganglist = ((CSetgradeControl)this.getControl()).getSugang(select);
		check = ((CSetgradeControl)this.getControl()).checkStudent(suganglist);
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
		
		System.out.print("�����Է��� �л��� ���̵� �Է��ϼ��� : ");
		String select2 = scanner.next();
		
		check = ((CSetgradeControl)this.getControl()).checkid(select2, suganglist);
		while(check == 0){
			System.out.print("���� ���̵��Դϴ� ���Է� ���ּ��� : ");
			select2 = scanner.next();
			check = ((CSetgradeControl)this.getControl()).checkid(select2, suganglist);
		}
		
		System.out.print("������ �Է��ϼ���(A+,A0 ~ C0,F) : ");
		String hakjeom = scanner.next();
		
		check = ((CSetgradeControl)this.getControl()).checkHakjeom(hakjeom);
		
		while(check==0){
			System.out.print("�߸��Է��ϼ̽��ϴ�. A+, A0, B+, B0, C+, C0, F�� �ϳ� �Է��ϼ��� : ");
			hakjeom = scanner.next();
			
			check = ((CSetgradeControl)this.getControl()).checkHakjeom(hakjeom);
			
		}
		
		((CSetgradeControl)this.getControl()).Setgrade(select, select2, hakjeom);
		System.out.println("�����Է¿Ϸ�.");
		
		this.setVuser(vuser);
		EEvent selection = EEvent.eSetGrade;
		return selection;
	}

	@Override
	public int selectcheck(int select, VUser vuser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
