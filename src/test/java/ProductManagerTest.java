import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ProductManagerTest {
    Product first = new Product(1, "Cleaning means", 999);
    Book firstBook = new Book(2, "Morning dawn", 1109, "Nietzsche");
    Smartphone firstSmartphone = new Smartphone(3, "Iphone", 4500, "Apple");

    @Test
    public void ProductRepositoryRemoveTest() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(firstBook);
        repo.save(firstSmartphone);
        Product[] actual = repo.removeById(1);
        Product[] expected = {firstBook, firstSmartphone};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ProductManagerSeveralSearchByTest() {
        ProductManager manage = new ProductManager(new ProductRepository());
        manage.add(first);
        manage.add(firstBook);
        manage.add(firstSmartphone);
        Product[] actual = manage.searchBy("ing");
        Product[] expected = {first, firstBook};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ProductManagerOneSearchByTest() {
        ProductManager manage = new ProductManager(new ProductRepository());
        manage.add(first);
        manage.add(firstBook);
        manage.add(firstSmartphone);
        Product[] actual = manage.searchBy("Iphone");
        Product[] expected = {firstSmartphone};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ProductManagerZeroSearchByTest() {
        ProductManager manage = new ProductManager(new ProductRepository());
        manage.add(first);
        manage.add(firstBook);
        manage.add(firstSmartphone);
        Product[] actual = manage.searchBy("Zero");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}
