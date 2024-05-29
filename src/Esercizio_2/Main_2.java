package Esercizio_2;

import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main_2 {
    public static void main(String[] args) {


        //lista prodotti mista che come categoria abbiano anche Baby
        List<Product> products = Arrays.asList(
                new Product("libro1", "Books", 119.99),
                new Product("libro2", "Books", 129.99),
                new Product("prodottoBambini4", "Baby", 59.99),
                new Product("prodottoBambini1", "Baby", 19.99),
                new Product("Laptop", "Electronics", 145.99),
                new Product("libro3", "Books", 59.99),
                new Product("prodottoBambini2", "Baby", 9.99),
                new Product("prodottoBambini3", "Baby", 5.99),
                new Product("Phone", "Electronics", 139.99),
                new Product("libro4", "Books", 32.99)

        );

        // Lista di ordini
        List<Order> orders = Arrays.asList(
                new Order("Consegnato", LocalDate.now().minusDays(10), LocalDate.now().minusDays(5),
                        Arrays.asList(products.get(0), products.get(1))),

                new Order("In attesa", LocalDate.now().minusDays(2), LocalDate.now().plusDays(3),
                        Arrays.asList(products.get(2), products.get(3), products.get(4), products.get(5))),

                new Order("Spedito", LocalDate.now().minusDays(7), LocalDate.now().plusDays(6),
                        Arrays.asList(products.get(6), products.get(8), products.get(9))),

                new Order("Consegnato", LocalDate.now().minusDays(6), LocalDate.now().plusDays(10),
                        Arrays.asList(products.get(7)))


        );

        //ordini che contengono prodotti della categoria "Baby"
        List<Order> filteredOrders = orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Baby".equals(product.getCategory()))).toList();
        System.out.println("\n----Lista di tutti gli ordini che contengono prodotti che contengono la categoria Baby: ----");
        filteredOrders.forEach(order -> System.out.println("\t\n-- ID ordine: " + order.getId() + " - " + "Stato: " + order.getStatus() + " - " + "Ordinato il: " + order.getOrderDate() + " - " + "Data di consegna: " + order.getDeliveryDate() + " \n\t- " + "Prodotti ordinato/i: " + order.getProducts()));

    }
}
