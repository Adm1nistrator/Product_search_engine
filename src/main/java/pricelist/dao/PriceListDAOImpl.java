package pricelist.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

/**
 * Created by Adm1n on 27.08.2016.
 */

public class PriceListDAOImpl implements PriceListDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ResultPriceList> findByFilter(PriceListFilter priceListFilter) {
        Session session = this.sessionFactory.getCurrentSession();
        List<ResultPriceList> resultPriceLists = session.createQuery("from prod").list();
        return resultPriceLists;

    }
}
