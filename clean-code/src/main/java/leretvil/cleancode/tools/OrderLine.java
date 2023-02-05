package leretvil.cleancode.tools;

import lombok.Data;

@Data
public class OrderLine {
    private Product product;
    private int itemCount;
}
