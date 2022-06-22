package jsonParser.service;

import jsonParser.entity.National_menu;
import jsonParser.entity.Product;
import jsonParser.jsonParser.Parser;

import java.io.IOException;
import java.util.List;

public class ProductService {

    public List<Product>getProduct() throws IOException {
        National_menu national_menu = Parser.jsonParsing();
        return national_menu.getProducts();
    }
}
