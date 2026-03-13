package com.inventory.skill2;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // INSERT
        Product p1 = new Product("Laptop","Gaming Laptop",70000,5);
        Product p2 = new Product("Phone","Android Phone",20000,10);

        session.save(p1);
        session.save(p2);

        // READ
        Product product = session.get(Product.class,1);
        System.out.println(product.getName());

        // UPDATE
        product.setPrice(65000);
        session.update(product);

        // DELETE
        Product deleteProduct = session.get(Product.class,2);
        session.delete(deleteProduct);

        tx.commit();
        session.close();

        System.out.println("CRUD operations completed");
    }
}