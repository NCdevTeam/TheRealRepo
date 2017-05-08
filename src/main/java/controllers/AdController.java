package main.java.controllers;

import main.java.entities.*;
import main.java.entities.enums.adStatus;
import main.java.entities.enums.adType;
import main.java.entities.enums.userBookType;
import main.java.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import main.java.DAO.AdsDAO;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import main.java.entities.enums.noteType;


/**
 * Created by Владислав on 24.04.2017.
 */

@Controller
@RequestMapping("/advert")
public class AdController {

    @Autowired private AdService adService;
    @Autowired private UserService userService;
    @Autowired private BookService bookService;
    @Autowired private AuthorService authorService;
    @Autowired private UserBookService userBookService;
    @Autowired private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView AdById(ModelMap map, @PathVariable("id") Integer id) {
        Ad advert = adService.getAd(id);
        map.addAttribute("item", advert);
        map.addAttribute("title",advert.getAdvertName());
        // comment attributes
        map.addAttribute("commentList",commentService.getCommentsByNote(id, noteType.advert));
        map.addAttribute("newComment", new Comment());
        map.addAttribute("noteType",noteType.advert);
        return new ModelAndView("AdDisplay");
    }

    //Как и с книгами нужно будет сделать ограничение на кол-во объявлений в запросе

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getAdverts(ModelMap map) {
        map.addAttribute("item",adService.getAll());
        map.addAttribute("title","Объявления");
        return new ModelAndView("DisplayAdverts");
    }

    @RequestMapping(method=RequestMethod.GET, value="/my")
    public ModelAndView getUserAdverts(ModelMap map, Principal principal) {
        User user = userService.findUserByName(principal.getName());
        map.addAttribute("item",adService.getAdsByUser(user));
        map.addAttribute("title","Мои объявления");
        return new ModelAndView("DisplayAdverts");
    }

    @RequestMapping(method=RequestMethod.GET, value="/create")
    public ModelAndView createAdvert(ModelMap map, Principal principal) {
        List<Book> bookList = bookService.getAll();
        List<Author> authorList = authorService.getAllAuthors();
        map.addAttribute("title","Создание объявления");
        map.addAttribute("newAdvert", new Ad());
        map.addAttribute("bookList",bookList);
        map.addAttribute("bookId");
        // additional attributes
        map.addAttribute("authorId");
        map.addAttribute("requireNewBook",false);
        map.addAttribute("newBook",new Book());
        map.addAttribute("authorList",authorList);
        map.addAttribute("requireNewAuthor",false);
        map.addAttribute("newAuthor",new Author());
        return new ModelAndView("displayAdvertCreation");
    }

    @RequestMapping(method=RequestMethod.POST,value = "/create")
    public String createAdvert(ModelMap map, Principal principal,
                               @ModelAttribute("newAdvert")Ad advert,
                               @ModelAttribute("bookId")Integer bookId,
                               @ModelAttribute("authorId")Integer authorId,
                               @ModelAttribute("requireNewBook")String requireNewBookStr,
                               @ModelAttribute("newBook")Book book,
                               @ModelAttribute("requireNewAuthor")String requireNewAuthorStr,
                               @ModelAttribute("newAuthor")Author author) {
        Book trueBook;
        Author trueAuthor;
        Boolean requireNewBook = Boolean.valueOf(requireNewBookStr);
        Boolean requireNewAuthor = Boolean.valueOf(requireNewAuthorStr);
        if(requireNewBook){
            if(requireNewAuthor) {
                trueAuthor = author;
                authorService.createNewAuthor(trueAuthor);
            }else {
                trueAuthor = authorService.getAuthorById(authorId);
            }
            trueBook = book;
            trueBook.setAuthor(trueAuthor);
            bookService.createBook(trueBook);
        } else {
            trueBook = bookService.getBook(bookId);
        }
        userBookService.addLink(principal.getName(),trueBook.getId(), userBookType.pool); // Добавление книги в список книг пользователя
        advert.setBook(trueBook);
        User user = userService.findUserByName(principal.getName());
        advert.setUser(user);
        advert.setStatus(adStatus.moderate);
        adService.createAdvert(advert);
        return "redirect:/advert";
    }
}
