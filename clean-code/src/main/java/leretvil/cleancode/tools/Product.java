package leretvil.cleancode.tools;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private ProductCategory category;

    private LocalDateTime createDate;
    private boolean premium;
    private boolean deleted;


    public Product(String name, ProductCategory category) {
        this.name = name;
        this.category = category;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product() {
    }


    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isNotDeleted() {
        return !this.deleted;
    }
}
