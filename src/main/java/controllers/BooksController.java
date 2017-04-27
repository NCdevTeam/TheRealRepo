package main.java.controllers;

//import org.library.entities.Book;
//import org.library.services.BookService;

import main.java.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
public class BooksController {

    @Autowired private BookService bookService;

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView allBooks(ModelMap map) throws SQLException{
        map.addAttribute("tempBook",bookService.getAll());
        map.addAttribute("title","Список всех книг.");
        return new ModelAndView("allBooksDisplay");
    }

    @RequestMapping(method=RequestMethod.GET, value="/author/{id}")
    public ModelAndView allBooksByAuthorId(ModelMap map, @PathVariable("id") Integer id) throws SQLException{
        map.addAttribute("tempBook",bookService.getBooksByAuthorId(id));
        map.addAttribute("title","Книги автора");
        return new ModelAndView("allAuthorsBooksDisplay");
    }

    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public ModelAndView BookById(ModelMap map, @PathVariable("id") Integer id) throws SQLException{
        map.addAttribute("tempBook",bookService.getBook(id));
        map.addAttribute("title","Паспорт книги");
        return new ModelAndView("BookDisplay");
    }

}
