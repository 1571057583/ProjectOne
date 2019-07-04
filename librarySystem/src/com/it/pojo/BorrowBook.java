package com.it.pojo;

public class BorrowBook {
	private String studentid;
	private String studentname;
	private int bookid;
	private String bookname;
	private String state;
	private int id;
	
	public BorrowBook() {
		super();
	}
	@Override
	public String toString() {
		return "BorrowBook [studentid=" + studentid + ", studentname="
				+ studentname + ", bookid=" + bookid + ", bookname=" + bookname
				+ ", state=" + state + ", id=" + id + "]";
	}
	public BorrowBook(String studentid, String studentname, int bookid,
			String bookname, String state, int id) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.bookid = bookid;
		this.bookname = bookname;
		this.state = state;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
