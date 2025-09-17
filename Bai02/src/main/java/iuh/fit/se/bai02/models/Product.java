package iuh.fit.se.bai02.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private double price;
    private String image;

}
