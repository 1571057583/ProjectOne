package com.it.mapper;

import java.util.List;

import com.it.pojo.Adminastrator;
import com.it.pojo.BookInfo;
import com.it.pojo.BorrowBook;
import com.it.pojo.Reader;

public interface libraryMapper {
	/**
	 * 登录 通过用户名密码登录
	 * 
	 * @param adminastrator
	 * @return
	 */
	Adminastrator selByUsernamePwd(Adminastrator adminastrator);

	/**
	 * 查询全部书籍信息
	 * 
	 * @return
	 */
	List<BookInfo> selAll();

	/**
	 * 通过Id更换书籍信息
	 * 
	 * @param bookInfo
	 * @return
	 */
	int updById(BookInfo bookinfo);

	/**
	 * 增加图书
	 * 
	 * @param bookinfo
	 * @return
	 */
	int insBook(BookInfo bookinfo);

	/**
	 * 删除书籍(通过id和书名)
	 * 
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
	 * @param bookinfo
	 * @return
	 */
	List<Reader> selReader();
	
	/**
	 * 修改读者信息
	 * @param reader
	 * @return
	 */
	int updByReaderId(Reader reader);
	
	/**
	 * 查询借还记录 
	 * @param borrowBook
	 * @return
	 */
	List<BorrowBook> selborrowbook(BorrowBook borrowBook);
	
	/**
	 * 借书
	 * @param borrowBook
	 * @return
	 */
	int insBorrowBook(BorrowBook borrowBook);
	
	/**
	 * 通过读者id查询已借书记录
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
	 * 读者查看全部图书
	 * @return
	 */
	List<BookInfo> showall();
	
	/**
	 * 查看自己借还书记录
	 * @return
	 */
	List<BorrowBook> borrowBookByPerson(BorrowBook borrowBook);
	
	/**
	 * 查看自己信息
	 * @param reader
	 * @return
	 */
	Reader showMe(Reader reader);
	
}

	
