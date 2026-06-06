package co.istad.productapisimple.restController;

import co.istad.productapisimple.dto.*;
import co.istad.productapisimple.service.CategoryService;
import co.istad.productapisimple.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryRestController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public List<CategoryResponse> getCategories(){
        return categoryService.findAllCategory();
    }
    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Integer id){
        return categoryService.findCategoryById(id);
    }
    @PostMapping
    public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);
    }
    @PatchMapping("/{id}")
    public CategoryResponse updateCategory(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCategoryRequest categoryRequest) {

        return categoryService.updateCategory(id, categoryRequest);
    }


}
