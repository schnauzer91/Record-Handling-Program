package view;

import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CGetgradeSControl;
import entity.CSugang;
import entity.VUser;

public class CGetgradeSEView extends CView {
	public CGetgradeSEView(){
		this.setControl(new CGetgradeSControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		Vector<CSugang> suganglist = new Vector<CSugang>();
		suganglist = ((CGetgradeSControl)this.getControl()).getSugang(vuser);
		System.out.println("강좌번호 평점");
		for(CSugang sugang: suganglist){
			System.out.println(sugang.getGangjwa_id() + " " + sugang.getHakjeom());
		}
		this.setVuser(vuser);
		EEvent selection = EEvent.eGetGradeS;
		return selection;
	}

	@Override
	public int selectcheck(int select, VUser vuser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
