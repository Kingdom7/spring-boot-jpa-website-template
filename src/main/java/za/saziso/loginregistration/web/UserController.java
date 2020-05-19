package za.saziso.loginregistration.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import za.saziso.loginregistration.model.User;
import za.saziso.loginregistration.service.UserService;
import za.saziso.loginregistration.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    } // ----------------------------------------------------------------

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        return "redirect:/services";
    } // --------------------------------------------------------------------------

    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    } // ----------------------------------------------------------------------------
    

    @RequestMapping(value = {"/services"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    } // -------------------------------------------------------------------------------
    
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "index";
    } // -------------------------------------------------------------------------------
    
    
    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String aboutPage(Model model) {
        return "about";
    } // -------------------------------------------------------------------------------
    
    
    @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
    public String contactPage(Model model) {
        return "contact";
    } // -------------------------------------------------------------------------------
    
    
    
} // -------------------- END OF CLASS ------------------------------------------------------------

