package pricelist.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pricelist.dao.PriceListDAO;
import pricelist.dao.ProductFilter;
import pricelist.dao.Product;

import java.util.Collections;
import java.util.List;

/**
 * Created by Adm1n on 27.08.2016.
 */
@Service
public class PriceListServiceImpl implements PriceListService {

    private PriceListDAO priceListDAO;
    public void setPriceListDAO(PriceListDAO priceListDAO)
    {
        this.priceListDAO=priceListDAO;
    }

    @Override
    @Transactional
    public List<Product> findByFilter(ProductFilter productFilter) {
        if (productFilter.isEmpty())
        {
            return Collections.emptyList();
        }

   return this.priceListDAO.findByFilter(productFilter);
    }


}
