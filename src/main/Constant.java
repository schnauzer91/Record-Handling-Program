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
	 public enum  EEvent{//이벤트 디자인
		 eLogout("종료", null), //0
		 eSignIn("로그인", new CLoginView()),//1
		 eSignUp("회원등록화면", new CSignupView()),//2
		 eMain("메인화면", new CMainView()),//3
		 eProfessor("교수화면", new CProfessorView()),//4 
		 eStudent("학생화면", new CStudentView()),//5
		 eCreateClass("강좌개설화면", new CCreateclassView()),//6
		 eGetClass("강좌조회화면", new CGetclassView()),//7
		 eSetGrade("성적입력화면", new CSetgradeView()),//8
		 eGetGradeP("성적조회화면", new CGetgradePView()),//9
		 eRegisterClass("수강신청화면", new CRegisterclassView()),//10
		 eGetGradeS("성적조회화면", new CGetgradeSView()),//11
		 eSignUpE("회원등록", new CSignupEView()),//12
		 eCreateClassE("강좌개설", new CCreateclassEView()),//13
		 eGetClassE("강좌조회", new CGetclassEView()),//14
		 eSetGradeE("성적입력", new CSetgradeEView()),//15
		 eGetGradePE("성적조회", new CGetgradePEView()),//16
		 eRegisterClassE("수강신청", new CRegisterclassEView()),//17
		 eGetGradeSE("성적조회", new CGetgradeSEView()),//18
		 eCreateDB("DB계정생성", new CCreateDBView());//19
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private CView view;
		 public CView getView(){return this.view;}
		 
		 private EEvent(String title, CView view){
			 this.title = title;
			 this.view = view;
		 }
	 }
	 
	 
	 
	 public enum EMainView{//메인화면디자인
		 eView1(EEvent.eSignIn,"로그인"),
		 eView2(EEvent.eSignUp,"회원가입"),
		 eView3(EEvent.eLogout,"종료");
		 
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EMainView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum ESignupView{//회원가입화면디자인
		 eView1(EEvent.eSignUpE,"회원가입"),
		 eView2(EEvent.eCreateDB,"DB계정생성"),
		 eView3(EEvent.eMain,"이전메뉴로 이동"),
		 eView4(EEvent.eLogout,"종료");
		 
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private ESignupView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum EStudentView{//학생화면디자인
		 eRegisterClassView(EEvent.eRegisterClass,"수강신청"),
		 eGetGradeView(EEvent.eGetGradeS,"성적조회"),
		 eMainView(EEvent.eMain,"이전메뉴로 이동"),
		 eLogoutView(EEvent.eLogout,"종료");
		 
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EStudentView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum EProfessorView{//교수화면디자인
		 eView1(EEvent.eCreateClass,"강좌개설"),
		 eView2(EEvent.eGetClass,"강좌조회"),
		 eView3(EEvent.eSetGrade,"성적입력"),
		 eView4(EEvent.eGetGradeP,"성적조회"),
		 eView5(EEvent.eMain,"이전메뉴로 이동"),
		 eView6(EEvent.eLogout,"종료");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EProfessorView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 public enum ECreateclassView{//강좌개설화면디자인
		 eView1(EEvent.eCreateClassE,"강좌개설"),
		 eView2(EEvent.eProfessor,"이전메뉴로 이동"),
		 eView3(EEvent.eLogout,"종료");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private ECreateclassView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 public enum EGetclassView{//개설강좌조회화면디자인
		 eView1(EEvent.eGetClassE,"개설강좌조회"),
		 eView2(EEvent.eProfessor,"이전메뉴로 이동"),
		 eView3(EEvent.eLogout,"종료");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EGetclassView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum ESetgradeView{//성적입력화면디자인
		 eView1(EEvent.eSetGradeE,"성적입력"),
		 eView2(EEvent.eProfessor,"이전메뉴로 이동"),
		 eView3(EEvent.eLogout,"종료");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private ESetgradeView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum EGetgradePView{//교수성적조회화면디자인
		 eView1(EEvent.eGetGradePE,"성적조회"),
		 eView2(EEvent.eProfessor,"이전메뉴로 이동"),
		 eView3(EEvent.eLogout,"종료");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EGetgradePView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public enum ERegisterclassView{//수강신청화면디자인
		 eView1(EEvent.eRegisterClassE,"수강신청"),
		 eView2(EEvent.eStudent,"이전메뉴로 이동"),
		 eView3(EEvent.eLogout,"종료");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private ERegisterclassView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 public enum EGetgradeSView{//학생성적조회화면디자인
		 eView1(EEvent.eGetGradeSE,"성적조회"),
		 eView2(EEvent.eStudent,"이전메뉴로 이동"),
		 eView3(EEvent.eLogout,"종료");
		 private EEvent eventID;
		 public EEvent getEventID(){return this.eventID;}
		 
		 private String title;
		 public String getTitle(){return this.title;}
		 
		 private EGetgradeSView(EEvent eventID, String title){
			 this.eventID = eventID;
			 this.title= title;
		 }
	 }
	 
	 public final static String MENUSELECTION = "메뉴선택";
}
