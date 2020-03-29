package cn.lamb.my_mybatis_plus.sys.service;

import cn.lamb.my_mybatis_plus.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lambert
 * @since 2020-03-29
 * @description
 * 说明:
 * 通用 Service CRUD 封装IService接口，进一步封装 CRUD 采用 get 查询单行 remove 删除 list 查询集合 page 分页 前缀命名方式区分 Mapper 层避免混淆，
 * 泛型 T 为任意实体对象
 * 建议如果存在自定义通用 Service 方法的可能，请创建自己的 IBaseService 继承 Mybatis-Plus 提供的基类
 * 对象 Wrapper 为 条件构造器
 */
public interface IUserService extends IService<User> {

}
