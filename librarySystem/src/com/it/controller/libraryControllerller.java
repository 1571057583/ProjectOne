package com.it.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.pojo.Adminastrator;
import com.it.pojo.BookInfo;
import com.it.pojo.BorrowBook;
import com.it.pojo.Reader;
import com.it.service.LibraryService;

@Controller
public class libraryControllerller {

	@Resource
	private LibraryService libraryServiceImpl;

	/**
	 * 管理员登录
	 * 
	 * @param a
	 * @param req
	 * @param session1
	 * @return
	 */
	@RequestMapping("/showbyup")
	public String showByUsernamePwd(Adminastrator adminastrator,
			HttpServletRequest req, HttpSession session1,HttpSession session2) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		adminastrator.setUsername(username);
		adminastrator.setPassword(password);
		Adminastrator show = libraryServiceImpl.showByUserName(adminastrator);
		session1.setAttribute("show", show);
		session2.setAttribute("name", show.getName());
		
		System.out.println(req.getSession().getAttribute("name"));
		if (show == null || "".equals(show)) {
			return "Login.jsp";

		} else {
			return "/show";
		}
	}
	@RequestMapping("/quit")
	public String quit(HttpServletRequest req){
		req.getSession().invalidate();
		return "/Login.jsp";
		
	}
	
	/**
	 * 查询全部书籍信息
	 */
	@RequestMapping("/show")
	public String showAll(HttpSession session,HttpServletRequest req) {
		List<BookInfo> showAll = libraryServiceImpl.showAll();
		session.setAttribute("list", showAll);
		System.out.println(showAll);
		
		return "/main/main.jsp";
	}

	/**
	 * 根据id修改书籍信息
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/udpById")
	public String udpById(HttpServletRequest req, BookInfo bookinfo,
			HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		bookinfo.setId(Integer.parseInt(req.getParameter("id")));
		bookinfo.setBookName(req.getParameter("bookName"));
		bookinfo.setAuthorName(req.getParameter("authorName"));
		bookinfo.setPublisherTime(req.getParameter("publisherTime"));
		bookinfo.setPublisher(req.getParameter("publisher"));
		bookinfo.setProfession(req.getParameter("profession"));
		bookinfo.setPrice(Integer.parseInt(req.getParameter("price")));
		int udpById = libraryServiceImpl.updById(bookinfo);
		if (udpById > 0) {
			return "/book/updBook.jsp";
		} else {
			return "/book/updBook.jsp";
		}
	}

	/**
	 * 增加图书
	 * 
	 * @param resp
	 * @param req
	 * @param bookinfo
	 * @return
	 */
	@RequestMapping("/insBook")
	public String insBook(HttpServletResponse resp, HttpServletRequest req,
			BookInfo bookinfo) {
		bookinfo.setBookName(req.getParameter("bookName"));
		bookinfo.setAuthorName(req.getParameter("authorName"));
		bookinfo.setPublisherTime(req.getParameter("publisherTime"));
		bookinfo.setPublisher(req.getParameter("publisher"));
		bookinfo.setProfession(req.getParameter("profession"));
		bookinfo.setPrice(Integer.parseInt(req.getParameter("price")));
		int insAll = libraryServiceImpl.insBook(bookinfo);
		return "/book/insBook.jsp";

	}

	/**
	 * 删除图书
	 * 
	 * @param resp
	 * @param req
	 * @param bookinfo
	 * @return
	 */
	@RequestMapping("/delBook")
	public String delBook(HttpServletResponse resp, HttpServletRequest req,
			BookInfo bookinfo) {
		bookinfo.setId(Integer.parseInt(req.getParameter("id")));
		bookinfo.setBookName(req.getParameter("bookName"));
		int delBook = libraryServiceImpl.delBook(bookinfo);
		return "/book/delBook.jsp";

	}

	/**
	 * 查看管理员信息
	 * 
	 * @param adminastrator
	 * @param req
	 * @return
	 */
	@RequestMapping("/selPerson")
	public String selPersonalByusername(Adminastrator adminastrator,
			HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("username");
		adminastrator.setUsername(username);
		Adminastrator selPersonalByusername = libraryServiceImpl
				.selPersonalByusername(adminastrator);
		req.setAttribute("selPerson", selPersonalByusername);
		return "/user/showUser.jsp";

	}

	/**
	 * 修改管理员信息
	 * 
	 * @param adminastrator
	 * @param req
	 * @return
	 */
	@RequestMapping("/updUser1")
	public String updUser(Adminastrator adminastrator, HttpServletRequest req,
			HttpSession session) {
		adminastrator.setId(Integer.parseInt(req.getParameter("id")));
		adminastrator.setName(req.getParameter("username"));
		adminastrator.setUsername(req.getParameter("username"));
		adminastrator.setPassword(req.getParameter("password"));
		int updUser = libraryServiceImpl.updUser(adminastrator);
		session.removeAttribute("show");
		return "/Login.jsp";

	}

	/**
	 * 查看读者信息
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/selReader1")
	public String selReader(HttpServletRequest req) {
		List<Reader> selReader = libraryServiceImpl.selReader();
		req.setAttribute("selReader", selReader);
		return "/user/showReader.jsp";

	}

	/**
	 * 修改读者信息
	 * 
	 * @param reader
	 * @param req
	 * @return
	 */
	@RequestMapping("/updByReaderId")
	public String updByReaderId(Reader reader, HttpServletRequest req) {
		reader.setId(Integer.parseInt(req.getParameter("id")));
		reader.setName(req.getParameter("name"));
		reader.setUsername(req.getParameter("username"));
		reader.setPassword(req.getParameter("password"));
		int upByReaderId = libraryServiceImpl.upByReaderId(reader);
		return "/user/updReader.jsp";

	}
	/**
	 * 查询图书借还记录
	 * @param borrowBook
	 * @param req
	 * @return
	 */
	@RequestMapping("/record")
	public String selBorrowBook(BorrowBook borrowBook,HttpServletRequest req){
		borrowBook.setState(req.getParameter("book"));
		if("1".equals(borrowBook.getState())){
			borrowBook.setId(1);
		}else{
			borrowBook.setId(0);
		}
		borrowBook.setBookname(req.getParameter("bookname"));
		borrowBook.setStudentname(req.getParameter("readername"));
		List<BorrowBook> selborrowbook = libraryServiceImpl.selborrowbook(borrowBook);
		System.out.println(borrowBook.getId());
		req.setAttribute("record", selborrowbook);
		return "/borrow/BorrowRecord.jsp";
		
	}
	/**
	 * 借书
	 * @param req
	 * @param borrowBook
	 * @return
	 */
	@RequestMapping("/insBorrowBook")
	public String insBorrowBook(HttpServletRequest req,BorrowBook borrowBook){
		borrowBook.setStudentid(req.getParameter("readerId"));
		borrowBook.setStudentname(req.getParameter("readerName"));
		borrowBook.setBookid(Integer.parseInt(req.getParameter("bookId")));
		borrowBook.setBookname(req.getParameter("bookName"));
		int insBorrowBook = libraryServiceImpl.insBorrowBook(borrowBook);
		return "/borrow/BorrowBook.jsp";
		
	}
	/**
	 * 通过id查询已借书记录
	 * @param req
	 * @param borrowBook
	 * @return
	 */
	@RequestMapping("/selBorrowBookById")
	public String selBorrowBookById(HttpServletRequest req,BorrowBook borrowBook){
		borrowBook.setStudentid(req.getParameter("readId"));
		List<BorrowBook> list = libraryServiceImpl.selBorrowBookById(borrowBook);
		req.setAttribute("showBorrowById", list);
		return "/borrow/BorrowBook.jsp";
		
	}
	/**
	 * 还书
	 * @param req
	 * @param borrowBook
	 * @return
	 */
	@RequestMapping("/updReturnBook")
	public String updReturnBook(HttpServletRequest req,BorrowBook borrowBook){
		borrowBook.setBookid(Integer.parseInt(req.getParameter("returnBook")));
		int updReturnBook = libraryServiceImpl.updReturnBook(borrowBook);
		return "/borrow/BorrowBook.jsp";
		
	}
	/**
	 * 登录
	 * @param reader
	 * @param session
	 * @param req
	 * @return
	 */
	@RequestMapping("/selByusernamepwd")
	public String selByUsernamePwd(Reader reader, HttpSession session,HttpSession session1,HttpServletRequest req){
		reader.setUsername(req.getParameter("username"));
		reader.setPassword(req.getParameter("password"));
		Reader reader2 = libraryServiceImpl.selByusernamepwd(reader);
		session.setAttribute("showname", reader2);
		req.setAttribute("name", reader2.getUsername());
		if(reader2!=null){
		return "/readermain/main.jsp";
		}else{
			return"/readerLogin.jsp";
		}
	}
	/**
	 * 查看全部图书信息
	 * @param reader
	 * @param req
	 * @return
	 */
	@RequestMapping("/showallbook")
	public String showAllBook(Reader reader ,HttpServletRequest req){
		List<BookInfo> showallbook = libraryServiceImpl.showallbook();
		req.setAttribute("showallbook", showallbook);
		return "/reader/showBook.jsp";
		
	}
	/**
	 * 查看图书借还记录
	 * @param borrow
	 * @param req
	 * @return
	 */
	@RequestMapping("/borrowBookByPerson")
	public String borrowBookByPerson(BorrowBook borrow ,HttpServletRequest req){
		borrow.setStudentname((String) req.getSession().getAttribute("name"));
		List<BorrowBook> borrowBookByPerson = libraryServiceImpl.borrowBookByPerson(borrow);
		req.setAttribute("borrowBookByPerson", borrowBookByPerson);
		
		return "/reader/BorrowRecord.jsp";
		
	}
	
	/**
	 * 查看个人信息
	 * @param reader
	 * @param req
	 * @return
	 */
	@RequestMapping("/showMe")
	public String showMe(Reader reader, HttpServletRequest req){
		reader.setUsername((String) req.getSession().getAttribute("name"));
		Reader reader2 = libraryServiceImpl.reader(reader);
		req.setAttribute("reader22", reader2);
		return "/reader/showMe.jsp";
		
	}
	/**
	 * 退出
	 */
	@RequestMapping("/quit1")
	public String readerQuit(HttpServletRequest req){
		req.getSession().invalidate();
		return "/readerLogin.jsp";
		
	}
}
