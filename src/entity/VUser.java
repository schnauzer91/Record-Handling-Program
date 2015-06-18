package entity;

public class VUser {
	public enum EUserType{
		EProfessor, EStudent
	}
	// attributes
	private String userID;
	private String name;
	private String type;
	private EUserType eUserType;
	
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public EUserType geteUserType() {return eUserType;}
	public void seteUserType(EUserType eUserType) {this.eUserType = eUserType;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
}
