package zhi.yest.jibexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping({"/hello", ""})
public class HelloController {
    @GetMapping
    public String hello(Model model) {
        model.addAttribute("caption", "hello");
        return "hello";
    }
}
