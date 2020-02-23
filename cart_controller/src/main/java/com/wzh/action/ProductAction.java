package com.wzh.action;

import com.wzh.entity.Product;
import com.wzh.service.ProductService;
import com.wzh.service.impl.ProductServiceImpl;

import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class ProductAction {
    private List<Product> products;
    private Integer index;
    private Integer page;

    public String queryProducts() {
        if (index == null) {
            index = 1;
        }
        ProductService service = new ProductServiceImpl();
        products = service.queryAll(index);
        Integer count = service.queryCount();
        page = count % 2 == 0 ? count / 2 : count / 2 + 1;
        return SUCCESS;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
