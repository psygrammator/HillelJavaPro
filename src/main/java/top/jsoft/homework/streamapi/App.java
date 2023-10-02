package top.jsoft.homework.streamapi;

import org.checkerframework.checker.units.qual.A;
import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.streamapi.enums.ProductType;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        //1
        products.add(new Product(ProductType.BOOK, 1));
        products.add(new Product(ProductType.BOOK, 150));
        products.add(new Product(ProductType.BOOK, 250));
        products.add(new Product(ProductType.BOOK, 350));
        products.add(new Product(ProductType.BOOK, 450));
        products.add(new Product(ProductType.BOOK, 1000));
        products.add(new Product(ProductType.OTHER, 1000));

        PrintManager.printSection("Task 1");
        List<Product> abovePriceByType = getAbovePriceByType(products, ProductType.BOOK, 250);
        abovePriceByType.forEach(p -> PrintManager.info(p.toString()));
        products.clear();

        //2
        products.add(new Product(ProductType.BOOK, 1, true));
        products.add(new Product(ProductType.BOOK, 150));
        products.add(new Product(ProductType.BOOK, 250, true));
        products.add(new Product(ProductType.BOOK, 350, true));
        products.add(new Product(ProductType.BOOK, 450));
        products.add(new Product(ProductType.BOOK, 1000, true));
        products.add(new Product(ProductType.OTHER, 1000));

        PrintManager.printSection("Task 2");
        List<Product> discountPriceByType = getDiscountsByType(products, ProductType.BOOK);
        discountPriceByType.forEach(p -> PrintManager.info(p.toString()));
        products.clear();

        //3
        PrintManager.printSection("Task 3");
        products.add(new Product(ProductType.BOOK, 1));
        products.add(new Product(ProductType.BOOK, 150));
        products.add(new Product(ProductType.BOOK, 250));
        products.add(new Product(ProductType.BOOK, 350));
        Product lowerPrice = getLowerPriceByType(products, ProductType.BOOK);
        PrintManager.info(lowerPrice.toString());
        products.clear();

        //4
        PrintManager.printSection("Task 4");
        products.add(new Product(ProductType.BOOK, 1, LocalDateTime.of(2023, 1, 1, 15, 0)));
        products.add(new Product(ProductType.BOOK, 2, LocalDateTime.of(2023, 1, 1, 16, 0)));
        products.add(new Product(ProductType.BOOK, 3, LocalDateTime.of(2023, 1, 1, 17, 0)));
        products.add(new Product(ProductType.BOOK, 4, LocalDateTime.of(2023, 1, 1, 18, 0)));
        products.add(new Product(ProductType.BOOK, 5, LocalDateTime.of(2023, 1, 1, 19, 0)));
        products.add(new Product(ProductType.BOOK, 6, LocalDateTime.of(2023, 1, 1, 20, 0)));
        products.add(new Product(ProductType.BOOK, 7, LocalDateTime.of(2023, 1, 1, 21, 0)));

        List<Product> sortDateByType = getLastThreeElementByType(products, ProductType.BOOK);
        sortDateByType.forEach(p -> PrintManager.info(p.toString()));
        products.clear();

        //5
        PrintManager.printSection("Task 5");
        products.add(new Product(ProductType.BOOK, 1, LocalDateTime.of(2023, 1, 1, 15, 0)));
        products.add(new Product(ProductType.BOOK, 2, LocalDateTime.of(2022, 1, 1, 16, 0)));
        products.add(new Product(ProductType.BOOK, 3, LocalDateTime.of(2023, 1, 1, 17, 0)));
        products.add(new Product(ProductType.BOOK, 4, LocalDateTime.of(2021, 1, 1, 18, 0)));
        products.add(new Product(ProductType.BOOK, 5, LocalDateTime.of(2023, 1, 1, 19, 0)));
        products.add(new Product(ProductType.BOOK, 6, LocalDateTime.of(2020, 1, 1, 20, 0)));
        products.add(new Product(ProductType.BOOK, 7, LocalDateTime.of(2023, 1, 1, 21, 0)));

        List<Product> sumPriceProductsThisYear = getSumPriceProductsThisYear(products, ProductType.BOOK);
        sumPriceProductsThisYear.forEach(p -> PrintManager.info(p.toString()));
        products.clear();

        //6
        PrintManager.printSection("Task 6");
        products.add(new Product(ProductType.BOOK, 1));
        products.add(new Product(ProductType.BOOK, 150));
        products.add(new Product(ProductType.PENCIL, 250));
        products.add(new Product(ProductType.PENCIL, 350));
        products.add(new Product(ProductType.ALBUM, 450));
        products.add(new Product(ProductType.ALBUM, 1000));
        products.add(new Product(ProductType.OTHER, 1000));
        Map<ProductType, List<Product>> productsByType = getProductsByType(products);
        productsByType.forEach((k, v) -> PrintManager.info(k.toString() + v.toString()));
    }

    private static List<Product> getAbovePriceByType(List<Product> products, ProductType type, double priceByAbove)
    {
        return products.stream().filter(p -> p.getType() == type)
                .filter(p -> p.getPrice() > priceByAbove)
                .collect(Collectors.toList());
    }

    private static List<Product> getDiscountsByType(List<Product> products, ProductType type)
    {
        return products.stream().filter(p -> p.getType() == type)
                .filter(Product::isDiscount)
                .map(p -> new Product(type, p.getPrice() * 0.9, true))
                .collect(Collectors.toList());
    }

    private static Product getLowerPriceByType(List<Product> products, ProductType type)
    {
        return products.stream()
                .filter(p -> p.getType() == type)
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product type " + type.name() + " not found."));
    }

    private static List<Product> getLastThreeElementByType(List<Product> products, ProductType type)
    {
        return products.stream()
                .filter(p -> p.getType() == type)
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<Product> getSumPriceProductsThisYear(List<Product> products, ProductType type)
    {
        return products.stream().filter(p -> p.getType() == type)
                .filter(p -> p.getDate().getYear() == LocalDate.now().getYear())
                .filter(p -> p.getPrice() < 75)
                .collect(Collectors.toList());
    }

    private static Map<ProductType, List<Product>> getProductsByType(List<Product> products)
    {
        return products.stream().collect(Collectors.groupingBy(Product::getType, Collectors.toList()));
    }
}
