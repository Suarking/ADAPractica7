package model;

public class Book {
    protected int id;
	protected String title;
	protected String author;
	protected String editorial;
	protected int yearb;

	public Book() {
	}

	public Book(int id) {
		this.id = id;
	}

	public Book(int id, String title, String author, String editorial, int year) {
		this(title, author, editorial, year);
		this.id = id;
	}
	
	public Book(String title, String author, String editorial, int year) {
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.yearb = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getAuthor() {
		return author;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setYear(int year) {
		this.yearb = year;
	}

	public int getYear() {
		return yearb;
	}
}
