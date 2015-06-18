package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;

import DAOs.IDAO;
import DAOs.MySQL;
import main.Constant.EEvent;
import view.CView;
import entity.VUser;
import exception.MainTimer;

public class CMain {

	public static void main(String[] args) throws SQLException, IOException{
		
				Scanner scanner = new Scanner(System.in); 
				EEvent selection = EEvent.eMain;
				VUser vuser = new VUser();
				while(selection != EEvent.eLogout){
					try{
						CView view = selection.getView();//����������(������) ���� ���� �ڵ������ �� 2�ٷ� �پ�����.
						selection = view.show(scanner, selection.getTitle(), vuser);
						vuser = view.getVuser();
					}catch(java.lang.NullPointerException e){
						Timer t = new Timer();
						MainTimer mt = new MainTimer();
						t.schedule(mt, 100);
						selection = EEvent.eMain;
					}
				}
				scanner.close();
			
	}
}
