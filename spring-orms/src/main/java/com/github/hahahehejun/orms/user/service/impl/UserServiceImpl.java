package com.github.hahahehejun.orms.user.service.impl;

import com.github.hahahehejun.orms.user.entity.User;
import com.github.hahahehejun.orms.user.mapper.UserMapper;
import com.github.hahahehejun.orms.user.service.IUserService;
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
