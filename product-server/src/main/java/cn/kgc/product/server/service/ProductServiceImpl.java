package cn.kgc.product.server.service;

import cn.kgc.product.common.entity.Product;
import cn.kgc.product.common.entity.ProductPage;
import cn.kgc.product.server.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/3/24
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductPage getAllProducts(Map<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");

        //设置页码和页面大小
        PageHelper.startPage(pageNum, pageSize);

        List<Product> list = productMapper.selectAllProducts(map);

        //执行查询
        PageInfo<Product> info = new PageInfo<>(list);

        ProductPage page = new ProductPage();
        page.setProducts(info.getList());
        page.setPageCount(info.getPages());
        page.setPageNum(info.getPageNum());
        page.setRowCount(((Long)info.getTotal()).intValue());

        return page;
    }

    @Override
    public List<Product> getProductsByList(List<Integer> list) {
        return productMapper.selectProductsByList(list);
    }
}
