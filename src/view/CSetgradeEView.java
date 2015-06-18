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
		System.out.println("강좌번호 강좌이름");
		for(CGangjwa gangjwa: gangjwalist){
			System.out.println(gangjwa.getId() + " " + gangjwa.getName());
		}
		check = ((CSetgradeControl)this.getControl()).checkGangjwa(gangjwalist);
		if(check == 0){//개설강좌가없을때
			System.out.println("개설한 강좌가 없습니다.");
			this.setVuser(vuser);
			EEvent selection = EEvent.eSetGrade;
			return selection;
		}
		System.out.print("강좌번호를 선택해 주세요 : ");
		String select = scanner.next();
		
		check = ((CSetgradeControl)this.getControl()).checkGangjwa(select, gangjwalist);
		while(check == 0){
			System.out.print("없는강좌입니다 재입력 해주세요 : ");
			select = scanner.next();
			check = ((CSetgradeControl)this.getControl()).checkGangjwa(select, gangjwalist);
		}
		
		suganglist = ((CSetgradeControl)this.getControl()).getSugang(select);
		check = ((CSetgradeControl)this.getControl()).checkStudent(suganglist);
		if(check == 0){//수강학생이 없을때
			System.out.println("현재 수강중인 학생이 없습니다.");
			this.setVuser(vuser);
			EEvent selection = EEvent.eSetGrade;
			return selection;
		}
		System.out.println("학생아이디 평점");
		for(CSugang sugang: suganglist){
			System.out.println(sugang.getId() + " " + sugang.getHakjeom());
		}
		
		System.out.print("성적입력할 학생의 아이디를 입력하세요 : ");
		String select2 = scanner.next();
		
		check = ((CSetgradeControl)this.getControl()).checkid(select2, suganglist);
		while(check == 0){
			System.out.print("없는 아이디입니다 재입력 해주세요 : ");
			select2 = scanner.next();
			check = ((CSetgradeControl)this.getControl()).checkid(select2, suganglist);
		}
		
		System.out.print("성적을 입력하세요(A+,A0 ~ C0,F) : ");
		String hakjeom = scanner.next();
		
		check = ((CSetgradeControl)this.getControl()).checkHakjeom(hakjeom);
		
		while(check==0){
			System.out.print("잘못입력하셨습니다. A+, A0, B+, B0, C+, C0, F중 하나 입력하세요 : ");
			hakjeom = scanner.next();
			
			check = ((CSetgradeControl)this.getControl()).checkHakjeom(hakjeom);
			
		}
		
		((CSetgradeControl)this.getControl()).Setgrade(select, select2, hakjeom);
		System.out.println("성적입력완료.");
		
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
