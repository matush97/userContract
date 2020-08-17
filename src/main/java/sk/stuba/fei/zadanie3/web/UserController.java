package sk.stuba.fei.zadanie3.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.zadanie3.functionality.SchemeUserService;
import sk.stuba.fei.zadanie3.user.User;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/user")
public class UserController {
    private final SchemeUserService schemeUserService;


    @Autowired
    public UserController(SchemeUserService schemeUserService) {
        this.schemeUserService = schemeUserService;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("schemeUser",schemeUserService.print());
        return "user/allUsers";
    }


    //dostane noveho usera
    @GetMapping("/addUsser")
    public String addUser(Model model){
        User userAdd = new User();
        userAdd.setID(schemeUserService.getUsers().size()+1);
        model.addAttribute("user",userAdd); //pouzil som defaultny som si vytvoril
        return "user/addUsser";

    }

    //ulozi novehoo usera
    @PostMapping("/addUsser")
    public String addToDatabse(@ModelAttribute @Valid User user,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  "user/addUsser";
       }
        schemeUserService.addUser(user);
        return "redirect:/user/";
    }

    //zmenit noveho pouzivatela
    @GetMapping("/changeUsser/{id}")
    public String changeUsser(@PathVariable int id,Model model){
        //model.addAttribute("user",schemeUserService.findUserByContract(id));
        //model.addAttribute();
        Optional<User> userChange = schemeUserService.findUserById(id);
        if(userChange.isPresent()){
            User user = userChange.get();
            model.addAttribute("userID",user);
        }
        return "user/changeUsser";
    }
    //ulozi zmenu pouzivatela
    @PostMapping("/changeUsser/{id}")
    public String changeToDatabse(@PathVariable int id,@ModelAttribute User user){
        schemeUserService.editUserById(id,user);
        return "redirect:/user/";
    }


    @GetMapping("/id/{id}")
    public String detailsUserById(@PathVariable int id, Model model){
        Optional<User> userById = schemeUserService.findUserById(id);
        if(userById.isPresent()){
            User user = userById.get();
            model.addAttribute("user",user);
        }
        return "user/one";
    }

}

