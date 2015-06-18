package DAOs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entity.CEntity;
import entity.CGangjwa;
import entity.CSugang;
import entity.CUser;

public class MySQL implements IDAO{
	private final static String DRIVER = "com.mysql.jdbc.Driver";//JDBC�� mysql driver�� �����ϵ��� ������
	private final static String URL = "jdbc:mysql://localhost:3306";//JDBC�� mysql�ϰ� ����ǰ� �� ��Ҵ� ip:localhost port : 3306 �� ���̴�. db�̸�������(0513)
	private final static String ID = "root";
	private final static String PASSWORD = "mju12345";	
	private final static String JAVAURL = "jdbc:mysql://localhost:3306/javalms";
	
	private Connection connection;//����
	private Statement statement;//������ ä��
	private ResultSet resultSet;//�޴� ä��
	private String tableName;
	
	public MySQL() throws ClassNotFoundException{//������ �ٷ� ����
		Class.forName(DRIVER);
	}
	
	@Override
	public void create() throws SQLException {//DB��������
		connection = DriverManager.getConnection(URL, ID, PASSWORD);//root���� ����
		String sql = "grant all privileges on *.* to javaacc@localhost identified by 'mju12345' with grant option;";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();//������ ���� ����.
	}
	
	@Override
	public void connect(String name, String mode) throws IOException, SQLException {
		connection = DriverManager.getConnection(JAVAURL, ID, PASSWORD);
		this.tableName = name;//connet���� �޾ƿ� name�� ������ tableName�� �־��ش�.
	}

	@Override
	public void disconnect() throws IOException, SQLException {
		if(connection == null){
			return;
		}
		if(resultSet != null){
			resultSet.close();
		}
		if(statement != null){
			statement.close();
		}
		connection.close();
	}

	@Override
	public CEntity read(CEntity entity, String ID) throws SQLException {//���� ã��
		while(resultSet.next()){//������ �� ��ŭ �ݺ�
			entity.DBRead(resultSet);//entity�� �����Ǿ� �ִ�.
			if(entity.getID().equals(ID)){//�Է��� ���̵� ������ ���� ��ȯ�Ѵ�.
				return entity;
			}
		}
		return null;//ã�Ҵµ� ������ null��ȯ
	}
	@Override
	public Vector<CGangjwa> GangjwaRead(String prof_ID) throws SQLException{
		Vector<CGangjwa> gangjwalist = new Vector<CGangjwa>();
		while(resultSet.next()){
			CGangjwa gangjwa = new CGangjwa();
			gangjwa.DBRead(resultSet);
			if(gangjwa.getProf_ID().equals(prof_ID)){
				gangjwalist.add(gangjwa);
			}
			if(prof_ID.equals("ALL")){
				gangjwalist.add(gangjwa);
			}
		}
		if(gangjwalist!=null){
			return gangjwalist;
		}else{
			return null;
		}
	}

	@Override
	public Vector<CSugang> SugangRead(String userID, String type) throws SQLException {
		Vector<CSugang> suganglist = new Vector<CSugang>();
		while(resultSet.next()){//������ �� ��ŭ �ݺ�
			CSugang sugang = new CSugang();
			sugang.DBRead(resultSet);//entity�� �����Ǿ� �ִ�.
			if(type.equals("stu")){//�л�������ȸ
				if(sugang.getId().equals(userID)){
					suganglist.add(sugang);
				}
			}else if(type.equals("prof")){//����������ȸ
				if(sugang.getGangjwa_id().equals(userID)){//�������̵��� ���������� ���¹�ȣ�� �����°��̴�.
					suganglist.add(sugang);
				}
			}
		}
		if(suganglist!=null){
			return suganglist;
		}else{
			return null;
		}
	}


	@Override
	public Vector<CUser> UserRead() throws SQLException {
		Vector<CUser> users = new Vector<CUser>();
		while(resultSet.next()){//������ �� ��ŭ �ݺ�
			CUser user = new CUser();
			user.DBRead(resultSet);//entity�� �����Ǿ� �ִ�.
			users.add(user);
		}
		return users;//ã�Ҵµ� ������ null��ȯ
	}
	@Override
	public CEntity readNext(CEntity entity) {
		return null;
	}

	@Override
	public void write(CEntity entity) throws IOException {
		
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void createAccount() throws SQLException {
		connection = DriverManager.getConnection(URL, ID, PASSWORD);//root���� ����
		String sql = "grant all privileges on *.* to javaacc@localhost identified by 'mju12345' with grant option;";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();//������ ���� ����.	
	}

	@Override
	public void createDB(String dirname) throws SQLException {
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "create database javalms;";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();//������ ���� ����.	
	}

	@Override
	public void createTable(String name) throws SQLException {
		connection = DriverManager.getConnection(JAVAURL, ID, PASSWORD);//root���� ����
		//member���̺� ����
		String sql = "create table member(no int(11) not null auto_increment primary key, id varchar(10), pw varchar(10), name varchar(10), type varchar(10));";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		//gangjwa���̺� ����
		sql = "create table gangjwa (no int(11) not null auto_increment primary key, id varchar(10), name varchar(30), prof_id varchar(10));";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		//sugang���̺� ����
		sql = "create table sugang (no int(11) not null auto_increment primary key, id varchar(10), gangjwa_id varchar(10), hakjeom varchar(10));";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		
		statement.close();//������ ���� ����.
		
	}

	@Override
	public void insertData(String name) throws SQLException {
		connection = DriverManager.getConnection(JAVAURL, ID, PASSWORD);//root���� ����
		String sql = "insert into member (id, pw, name, type) values ('prof1', 'profpw1', 'kim1', 'prof');";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		
		sql = "insert into member (id, pw, name, type) values ('stu1', 'stupw1', 'kim2', 'stu');";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		
		sql = "insert into gangjwa (id, name, prof_id) values ('1', 'OrientedProgramming2AClass', 'prof1');";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		
		sql = "insert into gangjwa (id, name, prof_id) values ('2', 'SoftwareAClass', 'prof1');";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		
		sql = "insert into sugang(id, gangjwa_id) values ('stu1', '1');";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		
		statement.close();//������ ���� ����.
	}
	
	@Override
	public void insertSignup(String id, String pw, String name, String type) throws SQLException{
		String sql = "insert into member(id, pw, name, type) values ('" + id + "','" + pw + "','" + name + "','" + type + "');";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();
	}
	@Override
	public void insertGangjwa(String id, String name, String prof_id) throws SQLException {
		String sql = "insert into gangjwa(id, name, prof_id) values ('" + id + "','" + name + "','" + prof_id + "');";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();
	}
	@Override
	public void insertSugang(String userID, String select) throws SQLException {
		String sql = "insert into sugang(id, gangjwa_id) values ('" + userID + "','" + select + "');";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();
		
	}
	@Override
	public void updateData(String name) throws SQLException {
		connection = DriverManager.getConnection(JAVAURL, ID, PASSWORD);//root���� ����
		String sql = "update user set id='id5', password='pw5', name='name5' where id='id0';";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();//������ ���� ����.
		
	}
	@Override
	public void updateHakjeom(String gangjwaId, String stuId, String hakjeom) throws SQLException {
		String sql = "update sugang set hakjeom='" + hakjeom + "' where id='" + stuId + "' and gangjwa_id='" + gangjwaId + "';";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();
	}

	@Override
	public void selectData(String name) throws SQLException {
		connection = DriverManager.getConnection(JAVAURL, ID, PASSWORD);//root���� ����
		String sql = "select * from " + name + ";";
		statement = connection.createStatement();//������ ä���� ����
		resultSet = statement.executeQuery(sql);
		

	}

	@Override
	public void deleteData(String name) throws SQLException {
		connection = DriverManager.getConnection(JAVAURL, ID, PASSWORD);//root���� ����
		String sql = "delete from user ;";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();//������ ���� ����.
		
	}

	@Override
	public void dropTable(String name) throws SQLException {
		connection = DriverManager.getConnection(JAVAURL, ID, PASSWORD);//root���� ����
		String sql = "drop table user;";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();//������ ���� ����.
		
	}

	@Override
	public void dropDB(String dirname) throws SQLException {
		connection = DriverManager.getConnection(URL, ID, PASSWORD);//root���� ����
		String sql = "drop database javalms;";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();//������ ���� ����.
		
	}

	@Override
	public void dropAccount() throws SQLException {
		connection = DriverManager.getConnection(URL, ID, PASSWORD);//root���� ����
		String sql = "drop account javaacc;";
		statement = connection.createStatement();//������ ä���� ����
		statement.executeUpdate(sql);//CRUD�� executeUpdate�� ������ �Ѵ�.
		statement.close();//������ ���� ����.
		
	}

}
