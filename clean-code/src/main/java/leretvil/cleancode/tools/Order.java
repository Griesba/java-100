package leretvil.cleancode.tools;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private Long id;
    private List<OrderLine> orderLines;
    private LocalDate creationDate;
    private boolean active;
    private int price;
}
