package pricelist.dao;

import java.util.List;

/**
 * Created by Adm1n on 27.08.2016.
 */
public interface PriceListDAO {
    List<ResultPriceList> findByFilter(PriceListFilter priceListFilter);

}
