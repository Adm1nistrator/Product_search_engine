package pricelist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private FilterValidator filterValidator;

    private PriceListService priceListService;


    @Autowired(required = true)
    @Qualifier(value = "priceListService")
    public void setPriceListService(PriceListService priceListService) {
        this.priceListService = priceListService;
    }


    @RequestMapping(path = "/price", method = RequestMethod.GET)
    public ModelAndView filter(@ModelAttribute("filter") @Validated ProductFilter filter) throws UnsupportedEncodingException {
        List<Product> products = this.priceListService.findByFilter(filter);
        products.forEach(product -> System.out.println(product.getName()));
        return new ModelAndView("pricelist");
    }

    /*
    TODO вернуть валидатор
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(filterValidator);
    }*/
}
