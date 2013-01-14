package QnA.android;

public class Content {
	private String number;
	private String writer;
	private String book;
	private String title;

	public Content (String number, String writer, String book, String title) {
		super();
		this.number = number;
		this.writer = writer;
		this.book = book;
		this.title = title;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
