package cn.kgc.product.server.mapper;

import cn.kgc.product.common.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Tiler on 2020/3/24
 */
@Mapper
public interface CategoryMapper {
    public List<Category> selectAllCategories();
    public Category selectCategoryById(Integer id);
}
