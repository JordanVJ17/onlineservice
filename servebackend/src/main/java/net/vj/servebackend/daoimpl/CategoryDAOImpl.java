package net.vj.servebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.vj.servebackend.dao.CategoryDAO;
import net.vj.servebackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	public static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		// Adding first Category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some Discription for TV");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// Adding Second Category
		category = new Category();
		category.setId(2);
		category.setName("Mobiles");
		category.setDescription("This is some Discription for SmartPhone");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		// Adding Third Category
		category = new Category();
		category.setId(3);
		category.setName("Laptops");
		category.setDescription("This is some Discription for ACe");
		category.setImageURL("CAT_3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		//Enhanced for loop
		for(Category category : categories) {
			if (category.getId() == id) return category;
		}
		return null;
	}

}
