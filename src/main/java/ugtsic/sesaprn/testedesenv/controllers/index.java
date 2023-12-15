package ugtsic.sesaprn.testedesenv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ugtsic.sesaprn.testedesenv.models.Curriculo;

@Controller
public class index {

    @RequestMapping(value = {"/", "/home","/index"}, method = RequestMethod.GET)
    public String getIndex(Model model) {
        Curriculo c = new Curriculo();
        model.addAttribute("curriculo", c);
        return "index";
    }


}
