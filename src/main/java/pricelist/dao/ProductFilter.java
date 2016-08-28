package pricelist.dao;

import org.springframework.util.StringUtils;

/**
 * Created by Adm1n on 27.08.2016.
 */
public class ProductFilter {
    private String category;
    private String product;
    private double priceFrom;
    private double priceTo;

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

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public boolean isEmpty() {
        return StringUtils.isEmpty(category) && StringUtils.isEmpty(product) && priceFrom == 0 && priceTo == 0;
    }
}
