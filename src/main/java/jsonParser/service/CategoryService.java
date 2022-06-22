package jsonParser.service;

import jsonParser.entity.Category;
import jsonParser.jsonParser.Parser;

import java.io.IOException;
import java.util.List;

public class CategoryService {

    public List<Category> getCategories() throws IOException {
        return Parser.jsonParsing().getCategories();
    }
}
