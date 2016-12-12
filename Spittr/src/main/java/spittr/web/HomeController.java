package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    @RequestMapping(method = GET)
    public String home() {
        // 返回一个名为home的视图,home.jsp
        return "home";
    }

}
