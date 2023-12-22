package ugtsic.sesaprn.testedesenv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ugtsic.sesaprn.testedesenv.models.Curriculo;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/home","/index"}, method = RequestMethod.GET)
    public String getIndex(Model model) {
        Curriculo c = new Curriculo();
        model.addAttribute("curriculo", c);
        return "index";
    }

    @RequestMapping(value = {"/ok"}, method = RequestMethod.GET)
    public String getOk() {
        return "mensagem";
    }

}

