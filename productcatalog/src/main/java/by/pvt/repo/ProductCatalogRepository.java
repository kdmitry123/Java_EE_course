package by.pvt.repo;

import by.pvt.pojo.ProductItem;
import org.springframework.data.repository.CrudRepository;

public interface ProductCatalogRepository extends CrudRepository<ProductItem, Long> {
}
