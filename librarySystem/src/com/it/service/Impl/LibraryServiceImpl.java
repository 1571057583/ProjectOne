package com.it.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.it.mapper.libraryMapper;
import com.it.pojo.Adminastrator;
import com.it.pojo.BookInfo;
import com.it.pojo.BorrowBook;
import com.it.pojo.Reader;
import com.it.service.LibraryService;
@Service
public class LibraryServiceImpl implements LibraryService{
	@Resource	
	private libraryMapper libraryMapper;
	
	/**
	 * 通过用户名密码查询(登录)
	 */
	public Adminastrator showByUserName(Adminastrator adminastrator) {
		Adminastrator a =adminastrator;
	
		return libraryMapper.selByUsernamePwd(a);
	}
	/**
	 * 查询全部书籍信息
	 */
	public List<BookInfo> showAll() {
		
		return libraryMapper.selAll();
	}
	
	/**
	 * 根据id修改书籍信息
	 */
	@Override
	public int updById(BookInfo bookinfo) {
		BookInfo book = bookinfo;
		return libraryMapper.updById(book);
	}
	
	/**
	 * 增加图书
	 */
	@Override
	public int insBook(BookInfo bookinfo) {
		
		return libraryMapper.insBook(bookinfo);
	}
	
	/**
	 *删除图书 
	 */
	@Override
	public int delBook(BookInfo bookinfo) {
		
		return libraryMapper.delBook(bookinfo);
	}
	
	/**
	 * 查询管理员信息
	 */
	@Override
	public Adminastrator selPersonalByusername(Adminastrator adminastrator) {
		
		return libraryMapper.selByUsernamePwd(adminastrator);
	}
	/**
	 * 修改管理员信息
	 */
	@Override
	public int updUser(Adminastrator adminastrator) {

		return libraryMapper.updUser(adminastrator);
	}
	/**
	 * 查询读者信息
	 */
	@Override
	public List<Reader> selReader() {
		return libraryMapper.selReader();
	}
	/**
	 * 修改读者信息
	 */
	@Override
	public int upByReaderId(Reader reader) {
		
		return libraryMapper.updByReaderId(reader);
	}
	/**
	 * 查询借还记录 
	 */
	@Override
	public List<BorrowBook> selborrowbook(BorrowBook borrowbook) {
			
		return libraryMapper.selborrowbook(borrowbook);
	}
	/**
	 * 借书
	 */
	@Override
	public int insBorrowBook(BorrowBook borrowbook) {
		
		return libraryMapper.insBorrowBook(borrowbook);
	}
	
	/**
	 * 通过读者id查询已借书情况
	 */
	@Override
	public List<BorrowBook> selBorrowBookById(BorrowBook borrowBook) {

		return libraryMapper.selBorrowBookById(borrowBook);
	}
	/**
	 * 还书
	 */
	@Override
	public int updReturnBook(BorrowBook borrowBook) {
		
		return libraryMapper.updReturnBook(borrowBook);
	}
	/**
	 * 读者登录
	 */
	@Override
	public Reader selByusernamepwd(Reader reader) {
		return libraryMapper.selByusernamepwd(reader);
	}
	/**
	 * 读者查看所有书籍
	 */
	@Override
	public List<BookInfo> showallbook() {
		return libraryMapper.showall();
	}
	/**
	 * 查看借还书记录
	 */
	@Override
	public List<BorrowBook> borrowBookByPerson(BorrowBook borrowBook) {
		return libraryMapper.borrowBookByPerson(borrowBook);
	}
	/**
	 * 查看个人信息
	 */
	@Override
	public Reader reader(Reader reader) {

		return libraryMapper.showMe(reader);
	}


}
