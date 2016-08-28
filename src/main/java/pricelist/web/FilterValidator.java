package pricelist.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pricelist.dao.ProductFilter;

/**
 * Created by Adm1n on 28.08.2016.
 */
@Component
public class FilterValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ProductFilter.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductFilter filter = (ProductFilter) o;

        if(filter.isEmpty()){
            errors.reject("category", "FilterIsEmpty.filter.category");
        }



    }
}
