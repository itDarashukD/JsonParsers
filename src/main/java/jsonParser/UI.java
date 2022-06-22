package jsonParser;

import jsonParser.service.CategoryService;
import jsonParser.service.ProductService;

import java.io.IOException;

public class UI {
    public static void main(String[] args) throws IOException {
        new CategoryService().getCategories().forEach(System.out::println);
        new ProductService().getProduct().forEach(System.out::println);
    }
}
