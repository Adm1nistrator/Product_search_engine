package pricelist.service;

import pricelist.dao.PriceListFilter;
import pricelist.dao.ResultPriceList;

import java.util.List;

/**
 * Created by Adm1n on 27.08.2016.
 */
public interface PriceLisrService {
    List<ResultPriceList> findByFilter(PriceListFilter priceListFilter);
}
