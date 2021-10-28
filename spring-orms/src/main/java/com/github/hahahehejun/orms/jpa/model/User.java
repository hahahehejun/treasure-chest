package com.github.hahahehejun.orms.jpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author wu
 * @date 2021/10/28 16:34
 */
@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "age", length = 4)
    private int age;
}