package pricelist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
@Controller
public class PriceList {


    @RequestMapping(path = "/")
    public ModelAndView getAllUser(HttpServletRequest request) throws UnsupportedEncodingException {
        return new ModelAndView("pricelist");
    }
}
