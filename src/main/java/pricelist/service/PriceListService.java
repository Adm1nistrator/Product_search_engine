package pricelist.service;

import pricelist.dao.ProductFilter;
import pricelist.dao.Product;

import java.util.List;

/**
 * Created by Adm1n on 27.08.2016.
 */
public interface PriceListService {
    List<Product> findByFilter(ProductFilter productFilter);
}
