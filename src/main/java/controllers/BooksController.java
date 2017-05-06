package main.java.controllers;

//import org.library.entities.Book;
//import org.library.services.BookService;

import main.java.entities.Book;
import main.java.entities.Comment;
import main.java.entities.User;
import main.java.entities.enums.userBookType;
import main.java.entities.enums.noteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import main.java.services.*;

import java.security.Principal;
import java.sql.SQLException;

@Controller
@RequestMapping("/book")
public class BooksController {

    @Autowired private BookService bookService;
    @Autowired private AuthorService authorService;
    @Autowired private CommentService commentService;
    @Autowired private UserBookService userBookService;
    @Autowired private UserService userService;

    //Все книги в базе (стоит сделать путь вроде books/pg?{id}, и выводить по X книг на каждый id, /books выводит первые Х книг)
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView allBooks(ModelMap map) throws SQLException{
        map.addAttribute("tempBook",bookService.getAll());
        map.addAttribute("title","Список всех книг.");
        map.addAttribute("pageHeader","Все книги в системе.");
        return new ModelAndView("BooksDisplay");
    }

    //Все книги за авторством Id
    @RequestMapping(method=RequestMethod.GET, value="/author/{id}")
    public ModelAndView allBooksByAuthorId(ModelMap map, @PathVariable("id") Integer id) {
        map.addAttribute("tempBook",bookService.getBooksByAuthor(authorService.getAuthorById(id)));
        map.addAttribute("title","Книги автора");
        map.addAttribute("pageHeader","Книги за авторством: ");
        return new ModelAndView("BooksDisplay");
    }

    //Страница книги по Id
    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public ModelAndView BookById(ModelMap map, @PathVariable("id") Integer id, Principal principal) {
        Book book = bookService.getBook(id);
        if(principal != null) {
            Boolean hasWish = userBookService.isLinked(principal.getName(),id,userBookType.wish);
            Boolean hasBought = userBookService.isLinked(principal.getName(),id,userBookType.pool);
            map.addAttribute("hasWish",hasWish);
            map.addAttribute("hasBought",hasBought);
        }
        map.addAttribute("item",book);
        map.addAttribute("title","Паспорт книги");
        map.addAttribute("commentList",commentService.getCommentsByNote(book.getId(), noteType.book));
        map.addAttribute("newComment",new Comment());
        map.addAttribute("noteType",noteType.book);
        return new ModelAndView("BookDisplay");
    }

    //Добавление книги в список желаемых
    @RequestMapping(method=RequestMethod.GET, value="/wish/{id}")
    public String addToWishPool(ModelMap map, @PathVariable("id") Integer id, Principal principal) {
        userBookService.addLink(principal.getName(),id, userBookType.wish);
        return "redirect:/book/"+id;
    }

    //Удаление книги из списка пожеланий
    @RequestMapping(method=RequestMethod.GET,value="/deleteWish/{id}")
    public String deleteFromWishPool(ModelMap map, @PathVariable("id") Integer id, Principal principal) {
        userBookService.deleteLink(principal.getName(),id,userBookType.wish);
        return "redirect:/book/"+id;
    }

}
