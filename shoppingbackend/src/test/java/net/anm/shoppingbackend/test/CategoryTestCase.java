package net.anm.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.anm.shoppingbackend.dao.CategoryDAO;
import net.anm.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass

	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.anm.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * category.setName("Laptop");
	 * category.setDescription("This iis some description for laptop");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * 
	 * assertEquals("successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(3);
	 * assertEquals("successfully fetched a category from the table!", "mobile",
	 * category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(3);
	 * category.setName("TV");
	 * assertEquals("successfully updated a category from the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(4);
	 * assertEquals("successfully deleted a category from the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("successfully fetcheded the list of a category from the table!",
	 * 4, categoryDAO.list().size());
	 * 
	 * }
	 */

	// test crud

	@Test
	public void testCRUDCategory() {
		// add operation
		/*category = new Category();
		category.setName("Laptop");
		category.setDescription("This iis some description for laptop");
		category.setImageURL("CAT_1.png");

		assertEquals("successfully added a category inside the table!", true, categoryDAO.add(category));
*/
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_2.png");

		assertEquals("successfully added a category inside the table!", true, categoryDAO.add(category));

		

		assertEquals("successfully fetcheded the list of a category from the table!", 4, categoryDAO.list().size());
	}
}
