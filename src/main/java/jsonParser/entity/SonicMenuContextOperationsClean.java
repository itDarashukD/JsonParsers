package jsonParser.entity;//package com.music_player_client.music_player_rest_client.xexperimtntal.jsonParser.entity;
//
//import lombok.experimental.UtilityClass;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@UtilityClass
//public class SonicMenuContextOperationsClean {
//
//    public Collection<Product> getProducts(National_menu menu) {
//        Map<String, Product> idToProductMap = toMap(menu.getProducts(), Product::getProductId);
//
//        List<Product> collect = Optional.ofNullable(menu.getMenu())
//                .map(Menu::getRootCategoryId)
//                .map(rootCategoryId -> getChildCategories(rootCategoryId, menu)).orElse(Stream.empty())
//                .map(Category::getProducts)
//                .flatMap(Collection::toStream)
//                .map(Product::getProductId)
//                .map(idToProductMap::get)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//        return collect;
//    }
//
//    public Stream<Category> getChildCategories(String categoryId, National_menu menu) {    //start with root category
//        Map<String, Category> idToCategoryMap = toMap(menu.getCategories(), Category::getCategoryId);
//        Stream<Category> childCategories = getChildCategories(categoryId, idToCategoryMap);
//        return childCategories;
//    }
//
//    private Stream<Category> getChildCategories(String categoryId, Map<String, Category> idToCategoryMap) { //recursive
//        Stream<Category> categoryStream = Optional.ofNullable(idToCategoryMap.get(categoryId))
//                .map(Category::getCategories)
//                .stream().flatMap(CollectionUtil::toStream)
//                .map(itemCategory -> idToCategoryMap.get(itemCategory.getCategoryId()))
//                .filter(Objects::nonNull)
//                .flatMap(category -> Stream.concat(Stream.of(category), getChildCategories(category.getCategoryId(), idToCategoryMap)))
//                .filter(Objects::nonNull);
//        return categoryStream;
//    }
//
//    private <T> Stream<T> toStream(Collection<T> collection) {
//        if (collection == null) {
//            return Stream.empty();
//        } else {
//            return collection.stream().filter(Objects::nonNull);
//        }
//    }
//
//    private <T, K> Map<K, T> toMap(Collection<T> collection, Function<T, K> keyExtractor) {//list products, product Id's
//        Map<K, T> collect = toStream(collection)
//                .filter(t -> keyExtractor.apply(t) != null)
//                .collect(Collectors.toMap(keyExtractor, Function.identity()));
//        return collect;
//    }
//}
