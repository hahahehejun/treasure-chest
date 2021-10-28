package com.github.hahahehejun.orms.jpa.dao;

import com.github.hahahehejun.orms.jpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wu
 * @date 2021/10/28 17:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepo {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll(){
        System.out.println(userRepository.findByAge(1));
    }

    @Test
    public void findBySpecification(){
        Specification<User> systemUserSpecification = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.greaterThanOrEqualTo(root.get("age"),"1"));
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        System.out.println(userRepository.findAll(systemUserSpecification));
    }
}
