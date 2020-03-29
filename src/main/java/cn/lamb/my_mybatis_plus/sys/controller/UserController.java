package cn.lamb.my_mybatis_plus.sys.controller;


import cn.lamb.my_mybatis_plus.common.State;
import cn.lamb.my_mybatis_plus.sys.entity.User;
import cn.lamb.my_mybatis_plus.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lambert
 * @since 2020-03-29
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private IUserService userService;

    private static User user = new User("张三", 20, "zhangsan@lamb.cn");
    private static List<User> users;

    static {
        users = Arrays.asList(new User[]{
                new User("李四", 21, "lisi@lamb.cn"),
                new User("王五", 22, "wangwu@lamb.cn"),
                new User("赵六", 23, "zhaoliu@lamb.cn"),
                new User("孙七", 24, "sunqi@lamb.cn"),
                new User("周八", 25, "zhouba@lamb.cn")});
    }

    /*****************************************save*****************************************/

    /**
     * 插入一条记录（选择字段，策略插入）
     * @return
     */
    @RequestMapping(value = "/testSave", method = RequestMethod.GET)
    public String save() {
        boolean saveResult = userService.save(user);
        return saveResult ? State.SUCCESS : State.FAILED;
    }

    /**
     * 插入（批量）
     * @return
     */
    @RequestMapping(value = "/testSaveBatch", method = RequestMethod.GET)
    public String saveBatch() {
        boolean saveResult = userService.saveBatch(users);
        return saveResult ? State.SUCCESS : State.FAILED;
    }

    /**
     * 插入（批量，自定义每批次数量）
     * @return
     */
    @RequestMapping(value = "/testSaveBatchWithSize", method = RequestMethod.GET)
    public String saveBatchWithSize() {
        boolean saveResult = userService.saveBatch(users, 2);
        return saveResult ? State.SUCCESS : State.FAILED;
    }



}

