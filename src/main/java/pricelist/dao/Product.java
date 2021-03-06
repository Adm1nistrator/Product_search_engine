package pricelist.dao;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adm1n on 28.08.2016.
 */
@Entity
@Table(name="prod")
public class Product implements Serializable {

    @Id
    @Column
    private Integer id;

    @ManyToOne(optional=false)
    @JoinColumn(name = "cat_id")
    private Category category;

    @Column
    private String name;

    @Column
    private Double price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
