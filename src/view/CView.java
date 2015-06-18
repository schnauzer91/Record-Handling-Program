package view;

import java.util.Scanner;

import main.Constant.EEvent;
import control.CControl;
import entity.VUser;

abstract public class CView {
	// association
	private CControl control;
	public CControl getControl() {return control;}
	public void setControl(CControl control) {this.control = control;}
	
	private VUser vuser;
	public VUser getVuser() {return vuser;}
	public void setVuser(VUser vuser) {this.vuser = vuser;}
	
	abstract public EEvent show(Scanner scanner, String title, VUser vuser);
	abstract public int selectcheck(int select, VUser vuser);
}
