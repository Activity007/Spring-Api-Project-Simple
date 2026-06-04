package co.istad.productapisimple.repository;

import co.istad.productapisimple.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Repository
public class CategoryRepository {
    private final List<Category> categoryList = new ArrayList<>(){{
        add(new Category(1001,"Drink","good for health",true,1));
        add(new Category(1002,"Food","good for Body",true,2));
        add(new Category(1003,"Electronic","good for study",true,3));
    }};
    public List<Category> getAllCategory(){
        return categoryList;
    }
    public Category createCategory(Category category){
        categoryList.add(category);
        return category;
    }
    public Category updateCategory(Category category){
        Category oldCategory = categoryList.stream()
                .filter(u->u.getId()== category.getId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category not found !!"));
        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
        oldCategory.setIsActive(category.getIsActive());

        return oldCategory;
    }
    public Category findCategoryById(Integer id){
        return categoryList.stream()
                .filter(u->Objects.equals(u.getId(),id))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Category with Id" +id+" is not Found!! "));
    }
    public boolean isDeleteCategory(Integer id){
        return categoryList.removeIf(c->c.getId().equals(id));
    }
}
