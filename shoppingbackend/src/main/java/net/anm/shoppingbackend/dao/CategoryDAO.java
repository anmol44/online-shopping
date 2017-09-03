package net.anm.shoppingbackend.dao;

import java.util.List;

import net.anm.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
