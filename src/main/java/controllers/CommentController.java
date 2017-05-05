package main.java.controllers;

import main.java.entities.Comment;
import main.java.entities.User;
import main.java.services.CommentService;
import main.java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by dR34m3r on 05.05.2017.
 */

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addComment(@ModelAttribute("newComment")Comment comment,ModelMap map,Principal principal) {
        User user = userService.findUserByName(principal.getName());
        commentService.addComment(comment,user);
        return "redirect:/"+comment.getNoteType().name()+"/"+comment.getNoteId();
    }
}
