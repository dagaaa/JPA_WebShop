package com.daga.repository;

import com.daga.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryByName(String name);

}
