package p07.file_class;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {
	public static void main(String[] args) throws Exception {
		//	new File(filename or directory)
		//	dir, file1들은 실제로 file이나 directory를 생성하지 않은 상태의 변수임 
		File dir = new File("C:/temp/dir");
		File file1 = new File("C:/temp/file1.txt");
		File file2 = new File("C:/temp/file2.txt");
		File file3 = new File(new URI("file:///c:/temp/file3.txt"));

		//	exists을 통해 return이 true이면 file이나 directory가 존재함
		if (dir.exists() == false) {
			//	mkdirs() : 실제로 directory 생성하는 메소드
			dir.mkdirs();
		}
		if (file1.exists() == false) {
			//	createNewFile() : 실제로 file을 생성하는 메소드
			file1.createNewFile();
		}
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		if (file3.exists() == false) {
			file3.createNewFile();
		}

		File temp = new File("C:/temp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd	a HH:mm");
		File[] contents = temp.listFiles();
		System.out.println("날짜		시간		형태		크기		이름");
		System.out.println("--------------------------------------------------------------------------");
		for (File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if (file.isDirectory()) {
				System.out.println("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.println("\t\t\t" + file.length() + "\t\t" + file.getName());
			}
			System.out.println();
		}
	}
}
