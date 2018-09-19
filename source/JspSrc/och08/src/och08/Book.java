package och08;

public class Book extends Product {
	private String writer;
	private int page;

	public String getWriter() {
		return writer;
	}

	public int getPage() {
		return page;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
