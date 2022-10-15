package com.cr192.processdataapplication.DataAccesLayer;

import com.cr192.processdataapplication.ComminLayer.Entity.Product;
import com.cr192.processdataapplication.ComminLayer.Entity.ProductNew;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProdRep {
    @PersistenceContext
    EntityManager manager;
    @Autowired
    interfase interfase;

    public void print() {
        String str = "select p.name_product, c.name_company from Product p left join Company c on c.id_company = p.company_id";

        Query query = manager.createQuery(str, Object.class)
                .unwrap(Query.class)
                .setTupleTransformer((ResultTransformer) (tuple, aliases) -> new ProductNew(tuple[0].toString(),tuple[1].toString()));
        Iterable<Product> list = interfase.findAll();
        List list1 = query.list();

        System.out.println(list1);
    }
}
