package pricelist.dao;

import org.springframework.util.StringUtils;

/**
 * Created by Adm1n on 27.08.2016.
 */
public class ProductFilter {
    private String category;
    private String product;
    private Double priceFrom;
    private Double priceTo;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public boolean isEmpty() {
        return StringUtils.isEmpty(category) && StringUtils.isEmpty(product) && priceFrom==null && priceTo==null;
    }
}
