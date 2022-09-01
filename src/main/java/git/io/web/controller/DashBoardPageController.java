package git.io.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class  DashBoardPageController {

    @GetMapping({"/","main"})
    public String main(){
        return "main";
    }
    @GetMapping("sign")
    public String sign(){
        return "sign";
    }
    @GetMapping("view")
    public String view(){
        return "view";
    }
}
