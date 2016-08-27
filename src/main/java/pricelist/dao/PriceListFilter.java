package pricelist.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Adm1n on 27.08.2016.
 */
public class PriceListFilter {
    private String category;
    private String product;
    private double priceFrom;
    private double priceTo;

    public PriceListFilter(@JsonProperty String category, @JsonProperty  String product, @JsonProperty  double priceFrom, @JsonProperty  double priceTo) {
        this.category = category;
        this.product = product;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
    }

    public PriceListFilter() {

    }

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
}
