package com.it.service;

import java.util.List;

import com.it.pojo.Adminastrator;
import com.it.pojo.BookInfo;
import com.it.pojo.BorrowBook;
import com.it.pojo.Reader;

public interface LibraryService {
	
	/**
	 * 登录
	 * 通过用户名密码查询
	 * @param adminastrator
	 * @return
	 */
	Adminastrator showByUserName(Adminastrator adminastrator);
	
	/**
	 * 查询全部书籍信息
	 * @return
	 */
	List<BookInfo> showAll();
	
	/**
	 * 根据id修改书籍信息
	 * @param bookinfo
	 * @return
	 */
	int updById(BookInfo bookinfo);
	
	/**
	 * 增加图书
	 * @param bookinfo
	 * @return
	 */
	int insBook(BookInfo bookinfo);
	/**
	 * 删除图书
	 * @param bookinfo
	 * @return
	 */
	int delBook(BookInfo bookinfo);
	
	/**
	 * 查询管理员信息
	 * @param adminastrator
	 * @return
	 */
	Adminastrator selPersonalByusername(Adminastrator adminastrator);
	/**
	 * 修改管理员信息
	 * @param adminastrator
	 * @return
	 */
	int updUser(Adminastrator adminastrator);
	
	/**
	 * 查询读者信息
	 * @return
	 */
	List<Reader> selReader();
	
	/**
	 * 修改读者信息
	 * @param reader
	 * @return
	 */
	int upByReaderId(Reader reader);
	
	/**
	 * 查询借还记录 
	 * @param borrowbook
	 * @return
	 */
	List<BorrowBook> selborrowbook(BorrowBook borrowbook);
	
	/**
	 * 借书
	 * @param borrowbook
	 * @return
	 */
	int insBorrowBook(BorrowBook borrowbook);
	/**
	 * 通过读者id查询已借书情况
	 * @param borrowBook
	 * @return
	 */
	List<BorrowBook> selBorrowBookById(BorrowBook borrowBook);
	
	/**
	 * 还书
	 * @param borrowBook
	 * @return
	 */
	int updReturnBook(BorrowBook borrowBook);
	
	/**
	 * 读者登录
	 * @param reader
	 * @return
	 */
	Reader selByusernamepwd(Reader reader);
	
	/**
	 * 读者查看所有书籍
	 * @return
	 */
	List<BookInfo> showallbook();
	
	/**
	 * 查看所有图书借还记录
	 * @param borrowBook
	 * @return
	 */
	List<BorrowBook> borrowBookByPerson(BorrowBook borrowBook);
	/**
	 * 查看个人信息
	 * @param reader
	 * @return
	 */
	Reader reader(Reader reader);
}
