package pricelist.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Adm1n on 27.08.2016.
 */
public class ResultPriceList {
    private String category;
    private String product;
    private double price;

    public ResultPriceList(@JsonProperty String category, @JsonProperty String product,@JsonProperty double price) {
        this.category = category;
        this.product = product;
        this.price = price;
    }

    public ResultPriceList() {

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
