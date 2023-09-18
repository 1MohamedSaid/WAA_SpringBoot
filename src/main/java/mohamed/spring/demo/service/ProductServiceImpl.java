package mohamed.spring.demo.service;

import mohamed.spring.demo.domain.Product;
import mohamed.spring.demo.domain.dto.ProductDto;
import mohamed.spring.demo.helper.ListMapper;
import mohamed.spring.demo.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ListMapper<Product,ProductDto> listMapperProductToDto;

    @Override
    public List<ProductDto> findAll() {
        var s = listMapperProductToDto.mapList(productRepo.findAll(),new ProductDto());
        return (List<ProductDto>) s;
    }

    @Override
    public ProductDto getById(int id) {
        return modelMapper.map(productRepo.findById(id),ProductDto.class);
    }


    @Override
    public void save(Product p) {
        productRepo.save(p);
    }
}
