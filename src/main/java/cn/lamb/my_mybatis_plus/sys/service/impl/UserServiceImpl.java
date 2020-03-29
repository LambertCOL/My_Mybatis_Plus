package cn.lamb.my_mybatis_plus.sys.service.impl;

import cn.lamb.my_mybatis_plus.sys.entity.User;
import cn.lamb.my_mybatis_plus.sys.mapper.UserMapper;
import cn.lamb.my_mybatis_plus.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lambert
 * @since 2020-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
