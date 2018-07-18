package p04.auto_closeable;

public class TryWithResourceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	try에 file open을 넣으면 수행중 에러가 발생하면 자동적으로 close 해줌
		try (FileInputStream fis = new FileInputStream("file.txt")){
			fis.read();
			throw new Exception();	//	강제적으로 예외 발생시킴
		} catch (Exception e) {
			System.out.println("예외 처리 코드가 실행되었습니다.");
		}
	}

}
