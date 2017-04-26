package main.java.controllers;

//import org.library.entities.Book;
//import org.library.services.BookService;

import main.java.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import main.java.services.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/books")
public class HomeController {

    @Autowired private BookService bookService;
    @Autowired private AuthorService authorService;

    @RequestMapping(method=RequestMethod.GET, value="/all")
    public ModelAndView home(ModelMap map) throws SQLException{
        List<Book> tempBook = bookService.getAll();
        //Book tempBook = bookService.getBook(3);
        map.addAttribute("tempBook",tempBook);
        return new ModelAndView("allBooksDisplay");
    }


//    @Resource(name="BookService")
//    private BookService bookService;
//
//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String getBooks(Model model) {
//
//        List<Book> books = bookService.getAll();
//
//        return "home";
//    }


}
