package co.istad.productapisimple.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
    private int id;
    private String name;
    private String description;
    private float price;
    private int userId;
}
