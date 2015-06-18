package DAOs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import entity.CEntity;
import entity.CGangjwa;
import entity.CSugang;
import entity.CUser;

public class TextDAO implements IDAO{//dao는 로직이 있으면 안된다.
	private Scanner scanner;//read
	private BufferedWriter writer;//write //line까지바꿔준다.
	private String mode;
	private static String TEMP = "temp.txt";
	@Override
	public void connect(String name, String mode) throws IOException, SQLException {
		this.mode = mode;
		if(this.mode.equals("r")){
			this.scanner = new Scanner (new File(name));//read
		} else if(this.mode.equals("w")){
			//create new file
			this.writer = new BufferedWriter(new FileWriter(name, false));
		} else if(this.mode.equals("w+")){//+가 있으면 파일의 내용을 없애지않고 추가하는것.
			//append item to existing file
			this.writer = new BufferedWriter(new FileWriter(name, true));
		}
	}

	@Override
	public void disconnect() throws IOException {
		if(this.mode.equals("r")){
			this.scanner.close();
		} else {
			this.writer.close();
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return scanner.hasNext();
	}

	@Override
	public CEntity read(CEntity entity,String ID) {
		//CEntity entity = new CEntity();//write할때 object를 주는 방법과 아예 파라미터로 object를 주는 방법이 있다.
		while(scanner.hasNext()){
			entity.read(scanner);//스캐너한테 읽으라고 시킴
			if(entity.getID().equals(ID)){
				return entity;
			}
		}
		return null;
	}
	
	@Override
	public CEntity readNext(CEntity entity) {
		
		if(scanner.hasNext()){
			entity.read(scanner);//스캐너한테 읽으라고 시킴
			return entity;
		}
		return null;
	}

	@Override
	public void write(CEntity entity) throws IOException {
		entity.write(writer);
	}

	@Override
	public void create() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAccount() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createDB(String dirname) throws SQLException {
		File directory = new File(dirname);
		if (!directory.exists()) {       // 원하는 경로에 폴더가 있는지 확인
			directory.mkdirs();    // 하위폴더를 포함한 폴더를 전부 생성
		} 
		System.out.println("디렉토리 생성");
	}

	@Override
	public void createTable(String name) throws SQLException, IOException {
		connect(name,"w");
		disconnect();
		System.out.println("파일생성");
	}

	@Override
	public void insertData(String name) throws SQLException, IOException {
		// TODO Auto-generated method stub
		connect(name,"w+");
		this.writer.write("id0");
		this.writer.write(" ");
		this.writer.write("pw0");
		this.writer.write(" ");
		this.writer.write("name0");
		this.writer.newLine();
		
		this.writer.write("id1");
		this.writer.write(" ");
		this.writer.write("pw1");
		this.writer.write(" ");
		this.writer.write("name1");
		this.writer.newLine();
		
		this.writer.write("id2");
		this.writer.write(" ");
		this.writer.write("pw2");
		this.writer.write(" ");
		this.writer.write("name2");
		this.writer.newLine();
		
		this.writer.write("id3");
		this.writer.write(" ");
		this.writer.write("pw3");
		this.writer.write(" ");
		this.writer.write("name3");
		this.writer.newLine();
		
		this.writer.write("id4");
		this.writer.write(" ");
		this.writer.write("pw4");
		this.writer.write(" ");
		this.writer.write("name4");
		this.writer.newLine();
		
		disconnect();

		System.out.println("데이터입력");
	}

	@Override
	public void updateData(String name) throws SQLException, IOException {
		connect(name,"r");
		connect(TEMP,"w");
		while(this.scanner.hasNext()){
			String scan;
			scan=scanner.next();
			if(scan.equals("id0")){
				this.writer.write("id5");
				this.writer.write(" ");
			}else if(scan.equals("pw0")){
				this.writer.write("pw5");
				this.writer.write(" ");
			}else if(scan.equals("name0")){
				this.writer.write("name5");
				this.writer.write(" ");
				this.writer.newLine();
			}else{
				this.writer.write(scan);
				this.writer.write(" ");
				if(scan.matches(".*name.*")){
					this.writer.newLine();
				}
			}
		}
		
		this.scanner.close();
		this.writer.close();
		//변경된 파일을 적용
		connect(TEMP,"r");
		connect(name,"w");
		while(this.scanner.hasNext()){
			String scan;
			scan=scanner.next();
			this.writer.write(scan);
			this.writer.write(" ");
			if(scan.matches(".*name.*")){
				this.writer.newLine();
			}
		}
		
		this.scanner.close();
		this.writer.close();
		dropTable(TEMP);//임시파일삭제
		System.out.println("데이터수정");
	}

	@Override
	public void selectData(String name) throws SQLException, IOException {
		connect(name,"r");
		int count = 0;
		while(this.scanner.hasNext()){
			if(count >= 3){
				System.out.println("");
				count = 0;
			}
			System.out.print(scanner.next() + " ");
			count++;
		}
		disconnect();
		System.out.println("");
	}

	@Override
	public void deleteData(String name) throws SQLException, IOException {
		connect(name,"r");
		connect(TEMP,"w");
		while(this.scanner.hasNext()){
			String scan;
			scan=scanner.next();
			if(!(scan.equals("id5") || scan.equals("pw5") || scan.equals("name5"))){
				this.writer.write(scan);
				this.writer.write(" ");
				if(scan.matches(".*name.*")){
					this.writer.newLine();
				}
			}
		}
		
		this.scanner.close();
		this.writer.close();
		//변경된 파일을 적용
		connect(TEMP,"r");
		connect(name,"w");
		while(this.scanner.hasNext()){
			String scan;
			scan=scanner.next();
			this.writer.write(scan);
			this.writer.write(" ");
			if(scan.matches(".*name.*")){
				this.writer.newLine();
			}
		}
		
		this.scanner.close();
		this.writer.close();
		dropTable(TEMP);//임시파일삭제
		System.out.println("데이터삭제");
	}

	@Override
	public void dropTable(String name) throws SQLException {
		File file = new File(name);
		file.delete();
		if(!name.equals(TEMP)){
			System.out.println("파일삭제");
		}
	}

	@Override
	public void dropDB(String dirname) throws SQLException {
		File directory = new File(dirname);
		directory.delete();
		System.out.println("디렉토리 삭제");
	}

	@Override
	public void dropAccount() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertSignup(String id, String pw, String name, String type)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertGangjwa(String id, String name, String prof_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<CGangjwa> GangjwaRead(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertSugang(String userID, String select) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<CSugang> SugangRead(String userID, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHakjeom(String gangjwaId, String stuId, String hakjeom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<CUser> UserRead() {
		// TODO Auto-generated method stub
		return null;
	}

}
