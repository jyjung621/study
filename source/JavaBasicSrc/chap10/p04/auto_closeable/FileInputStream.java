package p04.auto_closeable;

public class FileInputStream implements AutoCloseable {

	public String file;
	
	public FileInputStream(String file) {
		this.file = file;
	}
	
	public void read()
	{
		System.out.println(file + "을 읽습니다.");
	}

	//	Autocloseable Interface의 추상메소드를 override
	@Override
	public void close() throws Exception {
		System.out.println(file + "을 닫습니다.");
	}

}
