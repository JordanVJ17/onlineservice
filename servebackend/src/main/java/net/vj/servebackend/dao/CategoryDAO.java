package net.vj.servebackend.dao;

import java.util.List;

import net.vj.servebackend.dto.Category;

public interface CategoryDAO {
	
	
	List<Category> list();
	Category get(int id);
}
