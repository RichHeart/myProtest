package cn.kgc.product.common.entity;

import java.io.Serializable;

/**
 * Created by Tiler on 2020/3/24
 */
public class Category implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
