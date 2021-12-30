package com.github.hahahehejun.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author wu
 * @date 2021/12/30 15:03
 */
@Data
@AllArgsConstructor
public class School {
    private  String schoolName;
    private List<Student> students;
}
