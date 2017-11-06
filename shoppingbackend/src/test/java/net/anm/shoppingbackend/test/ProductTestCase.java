package net.anm.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.anm.shoppingbackend.dao.ProductDAO;
import net.anm.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.anm.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("ProductDAO");

	}

	@Test
	public void testCRUDProduct() {
		product = new Product();
		product.setName("lg12");
		product.setBrand("LG");
		product.setDescription("best led television");
		product.setUnitPrice(55000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);
		assertEquals("something went wrong while inserting a new product!", true, productDAO.add(product));
		/*
		 * reading and updating
		 */
		product = productDAO.get(1);
		product.setName("samsung");
		assertEquals("something went wrong while updating", true, productDAO.update(product));

		assertEquals("something went wrong while deleting", true, productDAO.delete(product));
		assertEquals("something went wrong ", 6, productDAO.list().size());
	}

}
