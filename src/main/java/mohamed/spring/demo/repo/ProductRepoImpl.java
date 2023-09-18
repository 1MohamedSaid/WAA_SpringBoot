package mohamed.spring.demo.repo;

import mohamed.spring.demo.domain.Product;
import mohamed.spring.demo.domain.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepoImpl implements ProductRepo {

    private static List<Product> products;
    private static int productId = 300;

    static {
        products = new ArrayList<>();
        Review r1a = new Review(123, "I love it", 5);
        Review r1b = new Review(145, "ordinary", 4);
        List<Review> reviews1 = Arrays.asList(r1a, r1b);

        Review r2a = new Review(223, "not that good", 3);
        Review r2b = new Review(245, "does its job", 4);
        List<Review> reviews2 = Arrays.asList(r2a, r2b);

        Product p1 = new Product(111, "iPhone 13", 1100, reviews1);
        Product p2 = new Product(112, "galaxy note 12", 1300, reviews2);
        products.add(p1);
        products.add(p2);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.stream()
                .filter(l->l.getId()==id)
                .findFirst()
                .orElse(null);
    }

//    @Override
//    public List<Product> findAllPriceGreaterThan(int price){
//        return products.stream().filter(p->p.getPrice()>=price).collect(Collectors.toList());
//    }
//
//    @Override
//    public Review getReviewByProductId(int pId,int reviewID){
//        return getById(pId).getReviews().stream().filter(k->k.getId()==reviewID).findFirst().orElse(null);
//    }
    @Override
    public void update(int id,Product p){
        Product toUpdate=getById(id);
        toUpdate.setName(p.getName());
        toUpdate.setPrice(p.getPrice());
    }
    @Override
    public void delete(int id){
        Product product=products.stream().filter(d->d.getId()==id).findFirst().get();
        products.remove(product);
    }
    @Override
    public void save(Product p){
        p.setId(productId);
        productId++; //we are auto generating id for demo purposes,normally we don't do this
        products.add(p);
    }
}
