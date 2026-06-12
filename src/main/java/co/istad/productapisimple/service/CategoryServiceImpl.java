package co.istad.productapisimple.service;

import co.istad.productapisimple.advisor.ResourceAlreadyExistException;
import co.istad.productapisimple.dto.CategoryRequest;
import co.istad.productapisimple.dto.CategoryResponse;
import co.istad.productapisimple.entity.Category;
import co.istad.productapisimple.mapper.CategoryMapper;
import co.istad.productapisimple.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public Page<CategoryResponse> findAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(categoryMapper::toResponse);
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {

        if (categoryRepository.existsByName(request.name())) {
            throw new ResourceAlreadyExistException(
                    "Category with name = " + request.name() + " already exists"
            );
        }

        Category category = categoryMapper.toEntity(request);
        Category newCategory = categoryRepository.save(category);

        return categoryMapper.toResponse(newCategory);
    }

    @Override
    public CategoryResponse updateCategory(Integer id, CategoryRequest request) {

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Category with id = " + id + " not found"
                        ));

        if (request.name() != null) {

            if (categoryRepository.existsByName(request.name())
                    && !existingCategory.getName().equals(request.name())) {

                throw new ResourceAlreadyExistException(
                        "Category with name = " + request.name() + " already exists"
                );
            }

            existingCategory.setName(request.name());
        }

        if (request.description() != null) {
            existingCategory.setDescription(request.description());
        }

        Category updatedCategory = categoryRepository.save(existingCategory);

        return categoryMapper.toResponse(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer id) {

        if (!categoryRepository.existsById(id)) {
            throw new NoSuchElementException(
                    "Category with id = " + id + " does not exist"
            );
        }

        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponse findById(Integer id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Category with id = " + id + " not found"
                        ));

        return categoryMapper.toResponse(category);
    }

    @Override
    public List<CategoryResponse> findByName(String name) {

        Category category = categoryRepository.findByName(name);

        if (category == null) {
            throw new NoSuchElementException(
                    "Category with name = " + name + " not found"
            );
        }

        return List.of(categoryMapper.toResponse(category));
    }
}