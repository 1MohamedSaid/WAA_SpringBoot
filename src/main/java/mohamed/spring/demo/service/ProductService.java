package mohamed.spring.demo.service;

import mohamed.spring.demo.domain.Product;
import mohamed.spring.demo.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto getById(int id);

    void save(Product p);
}

