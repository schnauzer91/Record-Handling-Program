package DAOs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import entity.CEntity;
import entity.CGangjwa;
import entity.CSugang;
import entity.CUser;

public interface IDAO {
	public void connect(String name, String mode) throws IOException, SQLException;
	public void disconnect() throws IOException, SQLException;
	
	public void create() throws SQLException;//���������� ���� 
	
	public CEntity read(CEntity entity, String ID) throws SQLException;
	public CEntity readNext(CEntity entity);
	public void write(CEntity entity) throws IOException;
	public boolean hasNext();
	//�ּ��� �����̶�� �����Ҷ� �� ����
	public void createAccount() throws SQLException;//��������
	public void createDB(String dirname) throws SQLException;//���丮����
	public void createTable(String name) throws SQLException, IOException;//���ϻ���
	public void insertData(String name) throws SQLException, IOException;//�������Է�(����)
	public void updateData(String name) throws SQLException, IOException;//�����ͼ���
	public void selectData(String name) throws SQLException, IOException;//������ã��
	public void deleteData(String name) throws SQLException, IOException;//�����ͼ���
	public void dropTable(String name) throws SQLException;//���ϻ���
	public void dropDB(String dirname) throws SQLException;//���丮����
	public void dropAccount() throws SQLException;//��������
	public void insertSignup(String id, String pw, String name, String type)
			throws SQLException;
	public void insertGangjwa(String id, String name, String prof_id) throws SQLException;
	public Vector<CGangjwa> GangjwaRead(String ID) throws SQLException;
	public void insertSugang(String userID, String select) throws SQLException;
	public Vector<CSugang> SugangRead(String userID, String type) throws SQLException;
	public void updateHakjeom(String gangjwaId, String stuId, String hakjeom) throws SQLException;
	public Vector<CUser> UserRead() throws SQLException;
}
