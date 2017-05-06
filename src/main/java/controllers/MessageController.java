package main.java.controllers;

import main.java.entities.Message;
import main.java.entities.User;
import main.java.services.MessageService;
import main.java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * Created by dR34m3r on 05.05.2017.
 */
@Controller
@RequestMapping("/dialog")
public class MessageController {

    @Autowired private MessageService messageService;
    @Autowired private UserService userService;

    @RequestMapping(method= RequestMethod.GET, value = "/{userName}")
    public ModelAndView displayDialog(ModelMap map, @PathVariable("userName") String userName, Principal principal) {
        User sender = userService.findUserByName(principal.getName());
        User receiver = userService.findUserByName(userName);
        List<Message> messageList = messageService.getDialog(sender,receiver);
        map.addAttribute("item",messageList);
        map.addAttribute("title","Диалог с пользователем "+receiver.getUsername());
        map.addAttribute("pageHeader","Диалог с пользователем "+receiver.getUsername());
        map.addAttribute("newMessage",new Message());
        map.addAttribute("receiver",receiver);
        return new ModelAndView("dialogDisplay");
    }

    @RequestMapping(method=RequestMethod.POST, value="/{userName}/send",consumes="application/x-www-form-urlencoded;charset=UTF-8")
    public String sendMessage(ModelMap map
            ,@ModelAttribute("newMessage")Message message
            ,Principal principal
            ,@PathVariable("userName")String userName) {
        User sender = userService.findUserByName(principal.getName());
        User receiver = userService.findUserByName(userName);
        message.setSender(sender);
        message.setReceiver(receiver);
        messageService.addMessage(message);
        return "redirect:/dialog/" + message.getReceiver().getUsername();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView displayDialogs(ModelMap map,Principal principal) {
        User currentUser = userService.findUserByName(principal.getName());
        List<User> userList = messageService.getListOfInterlocutors(currentUser);
        map.addAttribute("item",userList);
        return new ModelAndView("dialogsDisplay");
    }
}
