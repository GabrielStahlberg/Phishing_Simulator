package br.com.phishing.phishing.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/failed")
public class SuccessResource {

    @GetMapping
    public String getPage() {
        return "failed";
    }
}
