package com.github.hahahehejun.test.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wu
 * @since 2021-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OnlyService implements Serializable {

    private static final long serialVersionUID = 1L;

    private String classPath;

    private String onlyKey;

    private String name;

    private String project;

    private String methonName;


}
