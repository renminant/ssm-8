package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.Book;
import pojo.User;
import service.BookDao;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Controller
public class BookController {
    @Autowired
    BookDao bookDao;
    @Autowired
    HttpServletRequest request;

    //点击“图书管理”or"查询"后
    @RequestMapping("/billList.action")
    public ModelAndView billList(Book book, @RequestParam(required = false,defaultValue = "1",value = "page")int page, Model model) throws SQLException {
        ModelAndView mad = new ModelAndView();
        //首先是设置第几页，第二个参数是每页的记录数
        PageHelper.startPage(page,5);
        List<Book> bookList = bookDao.getBookList(book);
        PageInfo pageinfo = new PageInfo(bookList);
        model.addAttribute("name",book.getName());
        model.addAttribute("author",book.getAuthor());
        mad.addObject("pageinfo",pageinfo);
        mad.setViewName("billList");
        return mad;
    }

    @RequestMapping("/billList2.action")
    public ModelAndView billList2(Book book, @RequestParam(required = false,defaultValue = "1",value = "page")int page, Model model) throws SQLException {
        ModelAndView mad = new ModelAndView();
        //首先是设置第几页，第二个参数是每页的记录数
        PageHelper.startPage(page,5);
        List<Book> bookList = bookDao.getBookList(book);
        PageInfo pageinfo = new PageInfo(bookList);
        model.addAttribute("name",book.getName());
        model.addAttribute("author",book.getAuthor());
        mad.addObject("pageinfo",pageinfo);
        mad.setViewName("bill2");
        return mad;
    }


    //添加图书 点击"保存"后
    @RequestMapping("/RegisterBook.action")
    public ModelAndView RegisterProduct(Book book, @RequestParam(required = false,defaultValue = "1",value = "page")int page) throws SQLException {
        ModelAndView mad = new ModelAndView();
        PageHelper.startPage(page,5);
        List<Book> bookList = bookDao.getBookList(null);
        PageInfo pageinfo = new PageInfo(bookList);
        boolean register = bookDao.RegisterBook(book);//用Register进行判断
        if (register){//注册成功
            mad.addObject("pageinfo",pageinfo);
            mad.setViewName("redirect:billList.action");
        }else{//注册失败
            mad.setViewName("billAdd");
        }
        return mad;
    }

    //点击书名后
    @RequestMapping("/selectBillViewByid.action")
    public String selectBillViewByid(Integer book_id,Model model) throws SQLException {
        Book book = bookDao.getBookByid(id);
            if (book != null){
                model.addAttribute("book",book);
                return "billView";
            }else{
                return "billList";
            }

    }

    //进入billView页面 点击“修改”后
//    @RequestMapping("/selectProductByid.action")
//        public String selectProductByid(Integer id,Model model) throws SQLException {
//        Book product = bookDao.getProductByid(id);
//            if (product != null){
//                model.addAttribute("product",product);
//                return "billUpdate";
//            }else{
//                return "redirect:productList.action";
//            }
//    }
    @RequestMapping("/selectBookByid.action")
    public ModelAndView selectUserByid(Integer book_id,Model model) throws SQLException {
        ModelAndView mad = new ModelAndView();
        Book book = bookDao.getBookByid(book_id);
        if (book != null){
            mad.addObject("book",book);
            mad.setViewName("billUpdate");//回填页面数据
        }else{
            model.addAttribute("errorMsg","修改失败");
            mad.setViewName("billList");//跳转至列表页面
        }
        return mad;
    }
    //    //进入billUpdate页面 点击 “保存”后
    @RequestMapping("/bookUpdate.action")
    public ModelAndView bookUpdate(Book book, MultipartFile pictureFile) throws IOException, SQLException {
        ModelAndView mad = new ModelAndView();
        String filname = UUID.randomUUID().toString().replaceAll("-","");
        String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        filname = filname +"."+ extension;
        pictureFile.transferTo(new File("D:\\upload\\" + filname));
        book.setHeadpathbook(filname);
        boolean update = bookDao.updateBook(book);
        if (update){//修改成功
            mad.setViewName("redirect:billList.action");
        }else{//修改失败
            mad.setViewName("billUpdate");
        }
        return mad;
    }

//    //进入billUpdate页面 点击 “保存”后
//    @RequestMapping("/productUpdate.action")
//    public String productUpdate(Book book) throws SQLException {
//        boolean update = bookDao.updateBook(book);//通过updateProduct方法进行判断
//        if (update){//修改成功
//            return "redirect:billList.action";
//        }else{//修改失败
//            return "billUpdate";
//        }
//    }

    //点击"删除"后
    @RequestMapping("/deleteBook.action")
    public String deleteBook(Integer book_id) throws SQLException {
       bookDao.deleteBookByid(book_id);//用deleteProductByid进行判断
        return "redirect:billList.action";
    }

    //点击“图书借阅”后
    @RequestMapping("/bill2.action")
    public ModelAndView bill2(@RequestParam(required = false,defaultValue = "1",value = "page")int page,Borrow borrow) throws SQLException {
        PageHelper.startPage(page,5);
        ModelAndView mad = new ModelAndView();
        List<Book> bookList = bookDao.getBookList(null);
        Integer user_id = (Integer) request.getSession().getAttribute("user_id");
        borrow.setUser_id(user_id);
        bookDao.borrower(borrow)
        bookDao.lendUpdate(borrow.getBook_id());
        return "redirect:/billList2.action";
        PageInfo pageinfo = new PageInfo(bookList);
        mad.addObject("pageinfo",pageinfo);
//        mad.setViewName("bill2");
        return mad;
    }

//    @RequestMapping("/borrow.action")
//    public String borrow(Product product) throws Exception {
//        productDao.borrow(product);
//        productDao.borrowUpdate(product);
//        return "redirect:/bill2.action";
//    }

}
