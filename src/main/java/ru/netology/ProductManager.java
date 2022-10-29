package ru.netology;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository){ this.repository = repository; }

    public void add(Product product){ repository.save(product); }

    public void remove(Product product){ repository.removeById(product.id); }
    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                result[result.length - 1] = product;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
         return product.getName().contains(search);
    }
}
