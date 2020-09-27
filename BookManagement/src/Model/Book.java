package Model;

public class Book {
	private static int id=100000;
	private int bookID;
	private String bookName;
	private String author;
	private String specialization;
	private int publishYear;
	private int quantity;
	public Book() {
		
	}
	public Book(int bookID, String bookName, String author, String specialization, int publishYear, int quantity) {
	
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.specialization = specialization;
		this.publishYear = publishYear;
		this.quantity = quantity;
	}
	
	
	
}
