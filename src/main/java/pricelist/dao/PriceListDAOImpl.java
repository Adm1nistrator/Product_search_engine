package pricelist.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adm1n on 27.08.2016.
 */
@Repository
public class PriceListDAOImpl implements PriceListDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> findByFilter(ProductFilter productFilter) {
        Session session = this.sessionFactory.getCurrentSession();
      //  List<Product> product= session.createQuery("from Product").list();

        Query query = session.createQuery("from Product where name = :name ");
        query.setParameter("name", productFilter.getProduct());
        List<Product> products = query.list();
        return products;

    }
}
