package by.pvt.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
public class ProductItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isTopProduct;

    private Double price;

    @Column
    @Lob
    private byte[] picture;

    public ProductItem() {
    }

    public ProductItem(Long id, String name, boolean isTopProduct, Double price) {
        this.id = id;
        this.name = name;
        this.isTopProduct = isTopProduct;
        this.price = price;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTopProduct() {
        return isTopProduct;
    }

    public void setTopProduct(boolean topProduct) {
        isTopProduct = topProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isTopProduct=" + isTopProduct +
                ", price=" + price +
                ", picture=" + picture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductItem that = (ProductItem) o;

        if (isTopProduct != that.isTopProduct) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isTopProduct ? 1 : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }
}
