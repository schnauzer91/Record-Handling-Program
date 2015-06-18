package exception;

public class InputTypeNotMatchException extends Exception{
	public InputTypeNotMatchException() {
		System.out.println("Input Type Not Match Exception.");
		System.out.println("잘못된 입력으로 메인으로 돌아갑니다.");
		System.out.println("숫자로 입력해주시기 바랍니다.");
	}
}
