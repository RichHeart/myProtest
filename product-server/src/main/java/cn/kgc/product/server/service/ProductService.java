package cn.kgc.product.server.service;

import cn.kgc.product.common.entity.Product;
import cn.kgc.product.common.entity.ProductPage;

import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/3/24
 */
public interface ProductService {
    public ProductPage getAllProducts(Map<String, Object> map);
    public List<Product> getProductsByList(List<Integer> list);
}
