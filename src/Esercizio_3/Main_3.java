package Esercizio_3;

import entities.Product;

import java.util.Arrays;
import java.util.List;

public class Main_3 {
    public static void main(String[] args) {

        //lista prodotti mista che contiene alcuni prodotti che hanno categoria Boys
        List<Product> products = Arrays.asList(
                new Product("libro1", "Books", 119.99),
                new Product("libro2", "Books", 129.99),
                new Product("prodottoBambini4", "Baby", 59.99),
                new Product("prodottoBambini1", "Baby", 19.99),
                new Product("lenovo legion go", "Electronics", 799.99),
                new Product("libro3", "Books", 59.99),
                new Product("prodottoBambini2", "Baby", 9.99),
                new Product("prodottoBambini3", "Baby", 5.99),
                new Product("Phone 15 pro max", "Electronics", 1049.99),
                new Product("libro4", "Books", 32.99),
                //boys
                new Product("prodottoUomo1", "Boys", 48.00),
                new Product("prodottoUomo2", "Boys", 348.00),
                new Product("prodottoUomo3", "Boys", 300.00)

        );
//        System.out.println(products);

        List<Product> filtraProdottiBoys = products.stream()
                .filter(product -> "Boys".equals(product.getCategory())).toList();
        filtraProdottiBoys.forEach(product -> System.out.println(product.getPrice() + "€" + " questo è senza sconto"));


        filtraProdottiBoys.forEach(product -> product.setPrice(product.getPrice() * 0.90));

        System.out.println("\n\tProdotti che appartengono alla categoria Boys con lo sconto del 10% già applicato:  ");
        filtraProdottiBoys.forEach(product -> System.out.println("Id prodotto: " + product.getId() + " - " + "Nome prodotto: " + product.getName() + " - " + product.getPrice() + "€"));

    }
}
