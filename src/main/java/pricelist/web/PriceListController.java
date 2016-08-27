package pricelist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
@Controller
public class PriceListController {

    @RequestMapping(path = "/")
    public ModelAndView filter(HttpServletRequest request) throws UnsupportedEncodingException {
       request.setCharacterEncoding("UTF-8");



        return new ModelAndView("pricelist");
    }
}
