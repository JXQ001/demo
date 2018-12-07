package demo.xml.entity;

import lombok.Data;

@Data
public class Book {
	private String id;
	private String name;
	private String author;
	private String year;
	private String price;
	private String language;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", year=" + year + ", price=" + price
				+ ", language=" + language + "]";
	}
}
