package co.istad.productapisimple.service;

import co.istad.productapisimple.dto.CategoryRequest;
import co.istad.productapisimple.dto.CategoryResponse;
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
    public CategoryResponse updateCategory(Integer id, Category category) {
        var existingCategory = categoryRepository.findCategoryById(id);
        if(existingCategory == null) {
            // throw exception
            return null;
        }
        if(category.getName()!=null)
            existingCategory.setName(category.getName());
        if(category.getDescription()!=null)
            existingCategory.setDescription(category.getDescription());
        if(category.getIsActive()!=null)
            existingCategory.setIsActive(category.getIsActive());
        // update product
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
        return false;
    }
}
