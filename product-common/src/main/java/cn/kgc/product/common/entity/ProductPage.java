package cn.kgc.product.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tiler on 2020/4/8
 */
public class ProductPage extends BasePage implements Serializable {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
