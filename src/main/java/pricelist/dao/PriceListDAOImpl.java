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
       // SELECT cat.name, prod.name, price FROM prod INNER JOIN cat on prod.cat_id=cat.id
       //Query query = session.createQuery("select c.name,p.name,p.price from Product p, Category c inner join p.category where c.name=:category and p.name = :name and p.price between :priceFrom and :priceTo ");
      Query query = session.createSQLQuery("SELECT cat.name,prod.id,prod.cat_id, prod.name, prod.price FROM prod INNER JOIN cat on prod.cat_id=cat.id").addEntity(Product.class);

     /*   query.setParameter("category", productFilter.getCategory());
        query.setParameter("name", productFilter.getProduct());
        query.setDouble("priceFrom", productFilter.getPriceFrom());
        query.setDouble("priceTo", productFilter.getPriceTo());*/

        return query.list();

    }
}
