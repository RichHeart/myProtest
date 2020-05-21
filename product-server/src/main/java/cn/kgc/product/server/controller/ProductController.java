package cn.kgc.product.server.controller;

import cn.kgc.product.common.entity.Category;
import cn.kgc.product.common.entity.Product;
import cn.kgc.product.common.entity.ProductPage;
import cn.kgc.product.common.utils.NumberUtils;
import cn.kgc.product.server.service.CategoryService;
import cn.kgc.product.server.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/4/7
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("查询所有商品分类")
    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @ApiOperation("查询所有商品信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum", value = "页码", required = false, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "pageSize", value = "页面大小", required = false, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "categoryId", value = "商品分类", required = false, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "productName", value = "商品名称", required = false, paramType = "query", dataType = "string"),
        @ApiImplicitParam(name = "priceMax", value = "最高价格", required = false, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "priceMin", value = "最低价格", required = false, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ProductPage getAllProducts(@ApiIgnore @RequestParam Map<String, Object> parameters) {
        //map中的参数值为字符串类型
        String strPageNum = (String)parameters.get("pageNum");
        String strPageSize = (String)parameters.get("pageSize");
        String strCategory = (String) parameters.get("categoryId");
        String strProduct = (String) parameters.get("productName");
        String strPriceMax = (String) parameters.get("priceMax");
        String strPriceMin = (String) parameters.get("priceMin");

        //将参数转换数据类型
        Integer pageNum = NumberUtils.strToInt(strPageNum, 1);
        Integer pageSize = NumberUtils.strToInt(strPageSize, 10);
        Integer priceMax = NumberUtils.strToInt(strPriceMax, null);
        Integer priceMin = NumberUtils.strToInt(strPriceMin, null);
        Integer categoryId = NumberUtils.strToInt(strCategory, 0);
        String productName = strProduct == null? "" : strProduct;

        parameters.put("pageNum", pageNum);
        parameters.put("pageSize", pageSize);
        parameters.put("priceMax", priceMax);
        parameters.put("priceMin", priceMin);
        parameters.put("categoryId", categoryId);
        parameters.put("productName", productName);

        return productService.getAllProducts(parameters);
    }

    @ApiOperation("根据ID查询商品信息")
    @ApiImplicitParam(name = "productIds", value = "商品ID列表", required = true, paramType = "path", example = "1,2,3")
    @RequestMapping(value = "/products/{productIds}", method = RequestMethod.GET)
    public List<Product> getProductsByIds(@PathVariable("productIds") String productIds) {
        String test = "\t\t\r\n";
        if (productIds == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();

        String array[] = productIds.split(",");
        for (String s : array) {
            list.add(Integer.parseInt(s));
        }

        return productService.getProductsByList(list);
    }
}
