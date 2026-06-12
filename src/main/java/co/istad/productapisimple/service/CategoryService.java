package co.istad.productapisimple.service;

import co.istad.productapisimple.dto.CategoryRequest;
import co.istad.productapisimple.dto.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface CategoryService {
    Page<CategoryResponse> findAllCategory(Pageable pageable);

    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategory(Integer id,CategoryRequest request);
    void deleteCategory(Integer id);

    List<CategoryResponse> findAll();

    // get all with Pagination ( follow products sample )
    // soft delete category ( changing the value of isDeleted )
//    List<CategoryResponse> findAll();
    CategoryResponse findById(Integer id);
    List<CategoryResponse> findByName(String name);
}
