package Springmvc.springmvc.basic;

import lombok.Data;

@Data //@Getter , @Setter , @ToString , @EqualsAndHashCode , @RequiredArgsConstructor 자동적용
public class HelloDataModelAttribute {

    private String username;
    private int age;
}
