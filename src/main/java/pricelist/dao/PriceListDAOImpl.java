package pricelist.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
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

        if (productFilter.isEmpty())
        {
            return Collections.emptyList();

        }
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT cat.name AS categoryName, prod.id, prod.cat_id, prod.name, prod.price " +
                "FROM prod INNER JOIN cat on prod.cat_id=cat.id " +
                "where LOWER(cat.name) like LOWER(:categoryName) || '%' and LOWER(prod.name) LIKE LOWER(:productName) || '%' " +
                "and prod.price between :priceFrom and :priceTo").addEntity(Product.class);

        query.setString("categoryName", productFilter.getCategory());
        query.setString("productName", productFilter.getProduct());

        Double priceFrom = productFilter.getPriceFrom();
        query.setDouble("priceFrom", priceFrom==null ? 0.0:priceFrom);

        Double priceTo = productFilter.getPriceTo();
        query.setDouble("priceTo", priceTo==null ? Double.MAX_VALUE:priceTo);


        return query.list();

    }
}
