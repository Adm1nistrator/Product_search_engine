package pricelist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pricelist.dao.Product;
import pricelist.dao.ProductFilter;
import pricelist.service.PriceListService;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class PriceListController {

    private PriceListService priceListService;


    @Autowired(required = true)
    @Qualifier(value = "priceListService")
    public void setPriceListService(PriceListService priceListService) {
        this.priceListService = priceListService;
    }


    @RequestMapping(path = "/price", method = RequestMethod.GET)
    public ModelAndView filter(@ModelAttribute("filter") @Validated ProductFilter filter, Model model) throws UnsupportedEncodingException {

        List<Product> products = this.priceListService.findByFilter(filter);

      //  model.addAttribute("products", Collections.EMPTY_LIST);
        model.addAttribute("products", products);
        model.addAttribute("emptyFilter", filter.isEmpty());
//       products.forEach(product -> System.out.println(product.getName()));

        return new ModelAndView("pricelist");
    }
}
