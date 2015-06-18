package exception;

import java.util.TimerTask;

public class MainTimer extends TimerTask{
	@Override
	public void run() {
		System.out.println("문제로 인하여 다시 메인으로 돌아갑니다 재선택 해주세요.");
		System.out.print("메뉴선택: ");
	}

}
