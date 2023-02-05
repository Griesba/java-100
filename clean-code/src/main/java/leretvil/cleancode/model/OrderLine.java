package leretvil.cleancode.model;

import lombok.Data;

@Data
public class OrderLine {
    private Product product;
    private int itemCount;
}
