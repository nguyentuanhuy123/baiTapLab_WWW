package iuh.fit.se.bai02.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCart {
    private Product product;
    private int quantity;
}
