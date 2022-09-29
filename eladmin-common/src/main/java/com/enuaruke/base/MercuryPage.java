package com.enuaruke.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 05
 * @date: 2022-09-29 21:46
 */
@NoArgsConstructor
@AllArgsConstructor
public class MercuryPage implements Serializable {

    private Integer page;
    private Integer size;
    private Integer total;
    private List list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
