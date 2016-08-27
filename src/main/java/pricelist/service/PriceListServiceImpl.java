package pricelist.service;

import org.springframework.transaction.annotation.Transactional;
import pricelist.dao.PriceListDAO;
import pricelist.dao.PriceListFilter;
import pricelist.dao.ResultPriceList;

import java.util.List;

/**
 * Created by Adm1n on 27.08.2016.
 */
public class PriceListServiceImpl implements PriceLisrService {

    private PriceListDAO priceListDAO;

    @Override
    @Transactional
    public List<ResultPriceList> findByFilter(PriceListFilter priceListFilter) {
   return this.priceListDAO.findByFilter(priceListFilter);
    }


}
