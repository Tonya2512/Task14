package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product( 17, "ноутбук", 57_000);
        Product product2 = new Product( 36, "плеер", 15_000);
        Product product3 = new Product( 189, "наушники", 1800);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove (189);
        Product[] actual = repo.findAll();
        Product[] expected = {product1,product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveProductWhichNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product( 17, "ноутбук", 57_000);
        Product product2 = new Product( 36, "плеер", 15_000);
        Product product3 = new Product( 189, "наушники", 1800);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(786)
                );
    }

}