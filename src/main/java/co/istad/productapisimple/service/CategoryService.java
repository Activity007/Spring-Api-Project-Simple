package co.istad.productapisimple.service;

import co.istad.productapisimple.dto.CategoryRequest;
import co.istad.productapisimple.dto.CategoryResponse;
import co.istad.productapisimple.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory (CategoryRequest categoryRequest);
    List<CategoryResponse> findAllCategory();
    CategoryResponse updateCategory(Integer id, Category category);
    CategoryResponse findCategoryById(Integer id);
    boolean deleteCategory(Integer id);
}
