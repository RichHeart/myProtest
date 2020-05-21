package cn.kgc.product.common.entity;

/**
 * Created by Tiler on 2020/4/9
 */
public class BasePage {
    private Integer rowCount;
    private Integer pageCount;
    private Integer pageNum;

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
