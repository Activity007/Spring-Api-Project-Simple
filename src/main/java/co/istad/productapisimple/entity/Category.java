package co.istad.productapisimple.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Category {
    private  Integer id;
    private  String name;
    private  String description;
    private Boolean isActive;
    private Integer UserId;
}
