package com.github.hahahehejun.orms.mybatis.service.impl;

import com.github.hahahehejun.orms.mybatis.entity.User;
import com.github.hahahehejun.orms.mybatis.mapper.UserMapper;
import com.github.hahahehejun.orms.mybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user 服务实现类
 * </p>
 *
 * @author wu
 * @since 2021-12-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
