package co.istad.productapisimple.service;

import co.istad.productapisimple.dto.CategoryRequest;
import co.istad.productapisimple.dto.CategoryResponse;
import co.istad.productapisimple.dto.UpdateCategoryRequest;
import co.istad.productapisimple.dto.UpdateProductRequest;
import co.istad.productapisimple.entity.Category;
import co.istad.productapisimple.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private Integer nextId = 104;
    private Category mapToEntity(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.name());
        category.setDescription(categoryRequest.description());
        category.setIsActive(categoryRequest.isActive());
        return category;
    }
    private CategoryResponse mapToResponse(Category category){
        return  new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getIsActive()
        );

    }

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        var category = mapToEntity(categoryRequest);
        category.setUserId(1);
        category.setId(nextId++);
        return mapToResponse(categoryRepository.createCategory(category));
    }

    @Override
    public List<CategoryResponse> findAllCategory() {
        return categoryRepository.getAllCategory()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest categoryRequest) {
        var existingCategory = categoryRepository.findCategoryById(id);

        if (existingCategory == null) {
            return null;
        }
        if (categoryRequest.name() != null)
            existingCategory.setName(categoryRequest.name());
        if (categoryRequest.description() != null)
            existingCategory.setDescription(categoryRequest.description());
        if (categoryRequest.isActive()!= null)
            existingCategory.setIsActive(Boolean.valueOf(categoryRequest.isActive()));
        categoryRepository.updateCategory(existingCategory);
        return mapToResponse(existingCategory);
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
        var categories = categoryRepository.findCategoryById(id);
        if (categories == null){
            return null;
        }
        return mapToResponse(categories);
    }

    @Override
    public boolean deleteCategory(Integer id) {
        var existingCategory = categoryRepository.findCategoryById(id);
        if (existingCategory == null) {
            return false;
        }
        categoryRepository.isDeleteCategory(id);
        return true;
    }
}
