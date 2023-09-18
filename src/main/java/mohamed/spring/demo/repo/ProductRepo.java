package mohamed.spring.demo.repo;

import mohamed.spring.demo.domain.Product;
import java.util.List;

public interface ProductRepo {
    List<Product> findAll();

    Product getById(int id);

    void update(int id,Product p);

    void delete(int id);

    void save(Product p);
}
