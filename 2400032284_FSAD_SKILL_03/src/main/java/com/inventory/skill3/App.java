package com.inventory.skill3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// ---------- SORTING ----------
		System.out.println("Products sorted by price ASC:");
		Query<Product> q1 = session.createQuery("from Product p order by p.price asc", Product.class);
		List<Product> list1 = q1.list();
		list1.forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

		System.out.println("\nProducts sorted by price DESC:");
		Query<Product> q2 = session.createQuery("from Product p order by p.price desc", Product.class);
		q2.list().forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

		System.out.println("\nProducts sorted by quantity DESC:");
		Query<Product> q3 = session.createQuery("from Product p order by p.quantity desc", Product.class);
		q3.list().forEach(p -> System.out.println(p.getName() + " " + p.getQuantity()));

		// ---------- PAGINATION ----------
		System.out.println("\nFirst 3 products:");
		Query<Product> q4 = session.createQuery("from Product", Product.class);
		q4.setFirstResult(0);
		q4.setMaxResults(3);
		q4.list().forEach(p -> System.out.println(p.getName()));

		System.out.println("\nNext 3 products:");
		Query<Product> q5 = session.createQuery("from Product", Product.class);
		q5.setFirstResult(3);
		q5.setMaxResults(3);
		q5.list().forEach(p -> System.out.println(p.getName()));

		// ---------- AGGREGATE FUNCTIONS ----------
		System.out.println("\nTotal products:");
		Query<Long> q6 = session.createQuery("select count(*) from Product", Long.class);
		System.out.println(q6.uniqueResult());

		System.out.println("\nProducts with quantity > 0:");
		Query<Long> q7 = session.createQuery("select count(*) from Product where quantity > 0", Long.class);
		System.out.println(q7.uniqueResult());

		System.out.println("\nMin and Max price:");
		Query<Object[]> q8 = session.createQuery("select min(price), max(price) from Product", Object[].class);
		Object[] result = q8.uniqueResult();
		System.out.println("Min Price: " + result[0] + " Max Price: " + result[1]);

		// ---------- GROUP BY ----------
		System.out.println("\nProducts grouped by description:");
		Query<Object[]> q9 = session.createQuery(
				"select description, count(*) from Product group by description", Object[].class);
		for (Object[] row : q9.list()) {
			System.out.println(row[0] + " : " + row[1]);
		}

		// ---------- WHERE ----------
		System.out.println("\nProducts between price 1000 and 20000:");
		Query<Product> q10 = session.createQuery(
				"from Product where price between 1000 and 20000", Product.class);
		q10.list().forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

		// ---------- LIKE ----------
		System.out.println("\nNames starting with P:");
		Query<Product> q11 = session.createQuery(
				"from Product where name like 'P%'", Product.class);
		q11.list().forEach(p -> System.out.println(p.getName()));

		System.out.println("\nNames ending with r:");
		Query<Product> q12 = session.createQuery(
				"from Product where name like '%r'", Product.class);
		q12.list().forEach(p -> System.out.println(p.getName()));

		System.out.println("\nNames containing 'top':");
		Query<Product> q13 = session.createQuery(
				"from Product where name like '%top%'", Product.class);
		q13.list().forEach(p -> System.out.println(p.getName()));

		System.out.println("\nNames with length = 5:");
		Query<Product> q14 = session.createQuery(
				"from Product where length(name)=5", Product.class);
		q14.list().forEach(p -> System.out.println(p.getName()));

		tx.commit();
		session.close();

		System.out.println("\nHQL operations completed");
	}
}