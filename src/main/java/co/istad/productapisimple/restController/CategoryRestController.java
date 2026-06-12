package co.istad.productapisimple.restController;

import co.istad.productapisimple.dto.*;
import co.istad.productapisimple.service.CategoryService;
import co.istad.productapisimple.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryRestController {
    private final CategoryService categoryService;

    @GetMapping
    public Page<CategoryResponse> findAllCategory(Pageable pageable){
        return categoryService.findAllCategory(pageable);
    }

    @GetMapping("id/{id}")
    public CategoryResponse findById( @PathVariable Integer id){
        return categoryService.findById(id);
    }
    @GetMapping("name/{name}")
    public List<CategoryResponse> findByName(@PathVariable String name){
        return categoryService.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest request){
        return categoryService.createCategory(request);
    }
    @PatchMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable Integer id,
                                           @RequestBody CategoryRequest request){
        return categoryService.updateCategory(id,request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);

    }
}
