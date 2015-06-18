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
	
	public void create() throws SQLException;//계정생성을 위한 
	
	public CEntity read(CEntity entity, String ID) throws SQLException;
	public CEntity readNext(CEntity entity);
	public void write(CEntity entity) throws IOException;
	public boolean hasNext();
	//주석은 파일이라고 가정할때 그 역할
	public void createAccount() throws SQLException;//계정생성
	public void createDB(String dirname) throws SQLException;//디렉토리생성
	public void createTable(String name) throws SQLException, IOException;//파일생성
	public void insertData(String name) throws SQLException, IOException;//데이터입력(수정)
	public void updateData(String name) throws SQLException, IOException;//데이터수정
	public void selectData(String name) throws SQLException, IOException;//데이터찾기
	public void deleteData(String name) throws SQLException, IOException;//데이터수정
	public void dropTable(String name) throws SQLException;//파일삭제
	public void dropDB(String dirname) throws SQLException;//디렉토리삭제
	public void dropAccount() throws SQLException;//계정삭제
	public void insertSignup(String id, String pw, String name, String type)
			throws SQLException;
	public void insertGangjwa(String id, String name, String prof_id) throws SQLException;
	public Vector<CGangjwa> GangjwaRead(String ID) throws SQLException;
	public void insertSugang(String userID, String select) throws SQLException;
	public Vector<CSugang> SugangRead(String userID, String type) throws SQLException;
	public void updateHakjeom(String gangjwaId, String stuId, String hakjeom) throws SQLException;
	public Vector<CUser> UserRead() throws SQLException;
}
