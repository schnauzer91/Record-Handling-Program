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
		System.out.println("강좌번호 강좌이름");
		for(CGangjwa gangjwa: gangjwalist){
			System.out.println(gangjwa.getId() + " " + gangjwa.getName());
		}
		check = ((CGetgradePControl)this.getControl()).checkGangjwa(gangjwalist);
		if(check == 0){//개설강좌가없을때
			System.out.println("개설한 강좌가 없습니다.");
			this.setVuser(vuser);
			EEvent selection = EEvent.eSetGrade;
			return selection;
		}
		
		System.out.println("강좌번호를 선택해 주세요");
		String select = scanner.next();
		
		check = ((CGetgradePControl)this.getControl()).checkGangjwa(select, gangjwalist);
		while(check == 0){
			System.out.print("없는강좌입니다 재입력 해주세요 : ");
			select = scanner.next();
			check = ((CGetgradePControl)this.getControl()).checkGangjwa(select, gangjwalist);
		}
		
		suganglist = ((CGetgradePControl)this.getControl()).getSugang(select);
		check = ((CGetgradePControl)this.getControl()).checkStudent(suganglist);
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
