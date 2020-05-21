package cn.kgc.product.client.service;

import cn.kgc.product.common.entity.Category;
import cn.kgc.product.common.entity.Product;
import cn.kgc.product.common.entity.ProductPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/4/7
 */
//调用product-server服务的客户端
//所有函数的参数都必须有注解，无注解的查询参数使用@RequestParam
@FeignClient(value = "product-server", fallback = ProductFallback.class)
public interface ProductService {
    @RequestMapping(value = "/product/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories();

    @RequestMapping(value = "/product/products", method = RequestMethod.GET)
    public ProductPage getAllProducts(@RequestParam("parameters") Map<String, Object> parameters);

    @RequestMapping(value = "/product/products/{productIds}", method = RequestMethod.GET)
    public List<Product> getProductsByIds(@PathVariable("productIds") String productIds);
}
