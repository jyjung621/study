package sam08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String fileName;

//	public FileOutputter(String fileName) {
//		this.fileName = fileName;
//	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void ouput(String msg) {
		try {
			System.out.println("fileName : " + fileName);
			FileWriter fw = new FileWriter(new File(fileName));
//			FileWriter fw = new FileWriter(fileName);
			fw.write(msg);
			fw.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
