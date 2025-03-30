// File: src/main/java/ut/edu/entity/Product.java
package ut.edu.webjava.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ut.edu.webjava.models.Category;

@Entity
@Getter
@Setter
public class CreateProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Quan hệ với Image (nếu cần)
    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    // private Set<Image> images;
}