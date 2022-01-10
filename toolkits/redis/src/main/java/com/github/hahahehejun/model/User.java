package com.github.hahahehejun.model;

import java.io.Serializable;

/**
 * @author wu
 * @date 2022/1/10 13:49
 */
public class User implements Serializable {

    private Integer id;

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
