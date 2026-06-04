package co.istad.productapisimple.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer userId;
}
