package net.anm.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.anm.shoppingbackend.dao.CategoryDAO;
import net.anm.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	static {

		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This iis some description for television");
		category.setImageURL("CAT_1.png");
		category.setActive(true);
		categories.add(category);

		category = new Category();

		// adding second category
		category.setId(2);
		category.setName("mobile");
		category.setDescription("This iis some description for mobile");
		category.setImageURL("CAT_2.png");
		category.setActive(true);
		categories.add(category);

		category = new Category();

		// adding third category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This iis some description for Laptop");
		category.setImageURL("CAT_3.png");
		category.setActive(true);
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// enhanced for loop
		for(Category category : categories) {
			if(category.getId()==id) return category;
		}
		return null;
	}

}
