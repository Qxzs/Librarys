package po;

public class book {
 private int book_id;
 private String book_name;
 private String book_face;
 private String book_create;
 private int book_num;
 private String book_author;
 private String book_address;
public int getBook_id() {
	return book_id;
}
public void setBook_id(int book_id) {
	this.book_id = book_id;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
}
public String getBook_face() {
	return book_face;
}
public void setBook_face(String book_face) {
	this.book_face = book_face;
}
public String getBook_create() {
	return book_create;
}
public void setBook_create(String book_create) {
	this.book_create = book_create;
}
public int getBook_num() {
	return book_num;
}
public void setBook_num(int book_num) {
	this.book_num = book_num;
}
public String getBook_author() {
	return book_author;
}
public void setBook_author(String book_author) {
	this.book_author = book_author;
}
public String getBook_address() {
	return book_address;
}
public void setBook_address(String book_address) {
	this.book_address = book_address;
}
@Override
public String toString() {
	return "book [book_id=" + book_id + ", book_name=" + book_name + ", book_face=" + book_face + ", book_create="
			+ book_create + ", book_num=" + book_num + ", book_author=" + book_author + ", book_address=" + book_address
			+ "]";
}
 
 
}
