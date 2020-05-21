package cn.kgc.product.server.mapper;

import cn.kgc.product.common.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/3/24
 */
@Mapper
public interface ProductMapper {
    public List<Product> selectAllProducts(Map<String, Object> map);
    public Product selectProductById(Integer id);
    public List<Product> selectProductsByList(List<Integer> list);
}
