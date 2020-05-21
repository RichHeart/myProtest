package cn.kgc.product.client.service;

import cn.kgc.product.common.entity.Category;
import cn.kgc.product.common.entity.Product;
import cn.kgc.product.common.entity.ProductPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/4/29
 */
//熔断函数：备用函数
@Service
public class ProductFallback implements ProductService{
    @Override
    public List<Category> getAllCategories() {
        System.out.println("category fallback...");

        //方案之一：可以在应用端的redis中缓存一个分类列表，此处从redis中读取
        List<Category> list = new ArrayList<>();
        Category category = new Category();
        category.setId(0);
        category.setName("所有分类");

        list.add(category);

        return list;
    }

    @Override
    public ProductPage getAllProducts(Map<String, Object> parameters) {
        System.out.println("products fallback...");

        //方案之一：将前一天的各个分类的页面数据缓存几页
        List<Product> list = new ArrayList<>();

            //实际应用中从redis中读取
        Product product = new Product();
        product.setId(1);
        product.setName("MP3");
        product.setPrice(208f);
        product.setInfo("MP3播放器");
        product.setCategory(null);
        product.setImage("/images/img.jpg");

        list.add(product);

        ProductPage page = new ProductPage();
        page.setProducts(list);

        return page;
    }

    @Override
    public List<Product> getProductsByIds(String productIds) {
        System.out.println("products fallback...");

        //方案之一：返回一个空列表，在页面提示“系统繁忙，请稍后再试”
        return new ArrayList<>();
    }
}
