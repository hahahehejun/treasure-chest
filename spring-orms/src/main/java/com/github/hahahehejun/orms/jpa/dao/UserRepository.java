package com.github.hahahehejun.orms.jpa.dao;

import com.github.hahahehejun.orms.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wu
 * @date 2021/10/28 16:37
 */
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    List<User> findByAge(int age);
}
