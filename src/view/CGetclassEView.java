package view;

import java.util.Scanner;
import java.util.Vector;

import control.CGetclassControl;
import main.Constant.EEvent;
import entity.CGangjwa;
import entity.VUser;

public class CGetclassEView extends CView {
	public CGetclassEView(){
		this.setControl(new CGetclassControl());
	}
	@Override
	public EEvent show(Scanner scanner, String title, VUser vuser) {
		Vector<CGangjwa> gangjwalist = new Vector<CGangjwa>();
		
		gangjwalist = ((CGetclassControl)this.getControl()).getGangjwa(vuser);
		System.out.println("°­ÁÂ¹øÈ£ °­ÁÂÀÌ¸§");
		for(CGangjwa gangjwa: gangjwalist){
			System.out.println(gangjwa.getId() + " " + gangjwa.getName());
		}
		this.setVuser(vuser);
		EEvent selection = EEvent.eGetClass;
		return selection;
	}

	@Override
	public int selectcheck(int select, VUser vuser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
