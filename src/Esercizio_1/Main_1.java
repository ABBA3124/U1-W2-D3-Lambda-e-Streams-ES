package Esercizio_1;


import entities.Product;

import java.util.Arrays;
import java.util.List;

public class Main_1 {
    public static void main(String[] args) {

        //prodotti
        List<Product> products = Arrays.asList(
                new Product("libro1", "Books", 119.99),
                new Product("libro2", "Books", 129.99),
                new Product("lenovo legion go", "Electronics", 799.99),
                new Product("libro3", "Books", 59.99),
                new Product("phone 15 pro max", "Electronics", 1049.99),
                new Product("libro4", "Books", 32.99)
        );
        List<Product> filtraProdotti = products.stream()
                .filter(product -> "Books".equals(product.getCategory()) && product.getPrice() > 100).toList();

        System.out.println("\n\tLibri con il price > 100€:  ");
        filtraProdotti.forEach(product -> System.out.println(product.getName() + " - " + product.getPrice() + "€" + " " + product.getId()));
    }
}
