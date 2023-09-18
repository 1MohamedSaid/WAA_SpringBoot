package mohamed.spring.demo.repo;

import mohamed.spring.demo.domain.Product;
import mohamed.spring.demo.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product,Integer> {

    List<Product> findAll();

}
