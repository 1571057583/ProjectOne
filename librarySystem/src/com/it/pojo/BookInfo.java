package com.it.pojo;
/**
 * 图书信息表
 * @author Administrator
 *
 */
public class BookInfo {
	private int id;					//图书ID
	private String bookName;    	//书名
	private String authorName;		//作者
	private String publisherTime;	//出版时间
	private String publisher;		//出版社
	private String profession;		//专业
	private int price;				//价格
	
	
	public BookInfo() {
		super();
	}


	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", bookName=" + bookName
				+ ", authorName=" + authorName + ", publisherTime="
				+ publisherTime + ", publisher=" + publisher + ", profession="
				+ profession + ", price=" + price + "]";
	}


	public BookInfo(int id, String bookName, String authorName,
			String publisherTime, String publisher, String profession, int price) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherTime = publisherTime;
		this.publisher = publisher;
		this.profession = profession;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getPublisherTime() {
		return publisherTime;
	}


	public void setPublisherTime(String publisherTime) {
		this.publisherTime = publisherTime;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
}
