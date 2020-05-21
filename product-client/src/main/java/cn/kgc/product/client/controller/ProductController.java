package cn.kgc.product.client.controller;

import cn.kgc.product.client.service.ProductService;
import cn.kgc.product.common.entity.Category;
import cn.kgc.product.common.entity.Product;
import cn.kgc.product.common.entity.ProductPage;
import cn.kgc.product.common.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/3/24
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //@RequestParam:将页面参数自动装配至map中(参数四五个以上可以使用这种方法)
    @RequestMapping("/")
    public String getAllProducts(@RequestParam Map<String, Object> parameters, Model model) {
        String strPageNum = (String) parameters.get("pageNum");
        String strCategory = (String) parameters.get("categoryId");
        String strProduct = (String) parameters.get("productName");
        String strPriceMax = (String) parameters.get("priceMax");
        String strPriceMin = (String) parameters.get("priceMin");

        //将参数转换数据类型
        Integer pageNum = NumberUtils.strToInt(strPageNum, 1);
        Integer categoryId = NumberUtils.strToInt(strCategory, 0);
        String productName = strProduct == null? "" : strProduct;

        //读取商品信息，products内的元素为Map
        ProductPage productPage = productService.getAllProducts(parameters);
        List<Category> categories = productService.getAllCategories();

        System.out.println("---categories---");
        for (Category category : categories) {
            System.out.println(category.getName());
        }

        System.out.println("---products---");
        for (Product product : productPage.getProducts()) {
            System.out.println(product.getName());
        }

        productPage.setPageNum(pageNum);

        model.addAttribute("productPage", productPage);
        model.addAttribute("categories", categories);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("productName", productName);
        model.addAttribute("priceMax", strPriceMax);
        model.addAttribute("priceMin", strPriceMin);

        return "all_products";
    }
}
