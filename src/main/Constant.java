package main;

import view.CCreateDBView;
import view.CCreateclassEView;
import view.CCreateclassView;
import view.CGetclassEView;
import view.CGetclassView;
import view.CGetgradePEView;
import view.CGetgradePView;
import view.CGetgradeSEView;
import view.CGetgradeSView;
import view.CLoginView;
import view.CMainView;
import view.CProfessorView;
import view.CRegisterclassEView;
import view.CRegisterclassView;
import view.CSetgradeEView;
import view.CSetgradeView;
import view.CSignupEView;
import view.CSignupView;
import view.CStudentView;
import view.CView;

public class Constant {
	 public enum  EEvent{//�̺�Ʈ ������
		 eLogout("����", null), //0
		 eSignIn("�α���", new CLoginView()),//1
		 eSignUp("ȸ�����ȭ��", new CSignupView()),//2
		 eMain("����ȭ��", new CMainView()),//3
		 eProfessor("����ȭ��", new CProfessorView()),//4 
		 eStudent("�л�ȭ��", new CStudentView()),//5
		 eCreateClass("���°���ȭ��", new CCreateclassView()),//6
		 eGetClass("������ȸȭ��", new CGetclassView()),//7
		 eSetGrade("�����Է�ȭ��", new CSetgradeView()),//8
		 eGetGradeP("������ȸȭ��", new CGetgradePView()),//9
		 eRegisterClass("������ûȭ��", new CRegisterclassView()),//10
		 eGetGradeS("������ȸȭ��", new CGetgradeSView()),//11
		 eSignUpE("ȸ�����", new CSignupEView()),//12
		 eCreateClassE("���°���", new CCreateclassEView()),//13
		 eGetClassE("������ȸ", new CGetclassEView()),//14
		 eSetGradeE("�����Է�", new CSetgradeEView()),//15
		 eGetGradePE("������ȸ", new CGetgradePEView()),//16
		 eRegisterClassE("������û", new CRegisterclassEView()),//17
		 eGetGradeSE("������ȸ", new CGetgradeSEView()),//18
		 eCreateDB("DB��������", new CCreateDBView());//19
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private CView view;
		 public CView getView(){return this.view;}
		 
		 private EEvent(String title, CView view){
			 this.title = title;
			 this.view = view;
		 }
	 }
	 
	 
	 
	 public enum EMainView{//����ȭ�������
		 eView1(EEvent.eSignIn,"�α���"),
		 eView2(EEvent.eSignUp,"ȸ������"),
		 eView3(EEvent.eLogout,"����");
		 
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EMainView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum ESignupView{//ȸ������ȭ�������
		 eView1(EEvent.eSignUpE,"ȸ������"),
		 eView2(EEvent.eCreateDB,"DB��������"),
		 eView3(EEvent.eMain,"�����޴��� �̵�"),
		 eView4(EEvent.eLogout,"����");
		 
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private ESignupView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum EStudentView{//�л�ȭ�������
		 eRegisterClassView(EEvent.eRegisterClass,"������û"),
		 eGetGradeView(EEvent.eGetGradeS,"������ȸ"),
		 eMainView(EEvent.eMain,"�����޴��� �̵�"),
		 eLogoutView(EEvent.eLogout,"����");
		 
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EStudentView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum EProfessorView{//����ȭ�������
		 eView1(EEvent.eCreateClass,"���°���"),
		 eView2(EEvent.eGetClass,"������ȸ"),
		 eView3(EEvent.eSetGrade,"�����Է�"),
		 eView4(EEvent.eGetGradeP,"������ȸ"),
		 eView5(EEvent.eMain,"�����޴��� �̵�"),
		 eView6(EEvent.eLogout,"����");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EProfessorView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 public enum ECreateclassView{//���°���ȭ�������
		 eView1(EEvent.eCreateClassE,"���°���"),
		 eView2(EEvent.eProfessor,"�����޴��� �̵�"),
		 eView3(EEvent.eLogout,"����");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private ECreateclassView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 public enum EGetclassView{//����������ȸȭ�������
		 eView1(EEvent.eGetClassE,"����������ȸ"),
		 eView2(EEvent.eProfessor,"�����޴��� �̵�"),
		 eView3(EEvent.eLogout,"����");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EGetclassView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum ESetgradeView{//�����Է�ȭ�������
		 eView1(EEvent.eSetGradeE,"�����Է�"),
		 eView2(EEvent.eProfessor,"�����޴��� �̵�"),
		 eView3(EEvent.eLogout,"����");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private ESetgradeView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum EGetgradePView{//����������ȸȭ�������
		 eView1(EEvent.eGetGradePE,"������ȸ"),
		 eView2(EEvent.eProfessor,"�����޴��� �̵�"),
		 eView3(EEvent.eLogout,"����");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EGetgradePView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum ERegisterclassView{//������ûȭ�������
		 eView1(EEvent.eRegisterClassE,"������û"),
		 eView2(EEvent.eStudent,"�����޴��� �̵�"),
		 eView3(EEvent.eLogout,"����");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private ERegisterclassView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 public enum EGetgradeSView{//�л�������ȸȭ�������
		 eView1(EEvent.eGetGradeSE,"������ȸ"),
		 eView2(EEvent.eStudent,"�����޴��� �̵�"),
		 eView3(EEvent.eLogout,"����");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EGetgradeSView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public final static String MENUSELECTION = "�޴�����";
}
