package by.pvt.service;

import by.pvt.controller.CreateProductCmd;
import by.pvt.controller.UpdateProductCmd;
import by.pvt.dto.ProductDto;
import by.pvt.pojo.ProductItem;
import by.pvt.repo.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ProductCatalogService {

    private static Logger log = Logger.getLogger("b.p.s.ProductCatalogService");

    @Autowired
    ProductCatalogRepository productCatalogRepository;


    public List<ProductDto> getProducts(int i) {
        final List<ProductDto> productDtos = new ArrayList<>();
        productCatalogRepository.findAll().forEach(
                productItem -> {
                    ProductDto dto = new ProductDto();
                    dto.id = productItem.getId();
                    dto.name = productItem.getName();
                    dto.price = productItem.getPrice();
                    dto.serialNumber = productItem.getSerialNumber();
                    if (productDtos.size() < i) productDtos.add(dto);
                });
        return productDtos;
    }

    public void create(CreateProductCmd cmd) {
        ProductItem item = new ProductItem();
        item.setId((long) (Math.random() * 100));
        item.setCreatedDate(new Date());
        item.setName(cmd.getName());
        item.setPrice(cmd.getPrice());
        item.setSerialNumber("N/A");
        productCatalogRepository.save(item);
    }

    public void update(long id, UpdateProductCmd updateProductCmd) {
        ProductItem item = productCatalogRepository.findById(id).get();
        item.setSerialNumber(updateProductCmd.getSerialNumber());
        productCatalogRepository.save(item);
    }

    public ProductDto get(long id) {
        ProductItem productItem = productCatalogRepository.findById(id).get();
        ProductDto dto = new ProductDto();
        dto.id = productItem.getId();
        dto.serialNumber = productItem.getSerialNumber();
        dto.price = productItem.getPrice();
        dto.name = productItem.getName();
        return dto;
    }
}
