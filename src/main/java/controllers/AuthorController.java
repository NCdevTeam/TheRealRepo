package main.java.controllers;

import main.java.entities.Author;
import main.java.entities.Comment;
import main.java.entities.enums.noteType;
import main.java.services.AuthorService;
import main.java.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by dR34m3r on 08.05.2017.
 */

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired private AuthorService authorService;
    @Autowired private CommentService commentService;

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView allAuthors(ModelMap map) {
        List<Author> authorList = authorService.getAllAuthors();
        map.addAttribute("item",authorList);
        map.addAttribute("title","Все авторы");
        return new ModelAndView("displayAuthors");
    }

    @RequestMapping(method=RequestMethod.GET, value = "/{id}")
    public ModelAndView getAuthor(ModelMap map, @PathVariable("id") Integer id) {
        Author author = authorService.getAuthorById(id);
        map.addAttribute("item",author);
        map.addAttribute("title","Автор, "+author.getNickName());
        map.addAttribute("commentList",commentService.getCommentsByNote(id, noteType.author));
        map.addAttribute("newComment", new Comment());
        map.addAttribute("noteType",noteType.author);
        return new ModelAndView("displayAuthor");
    }
}
