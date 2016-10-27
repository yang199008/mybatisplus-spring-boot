package com.baomidou.springboot.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 增删改查 CRUD
     */
    @RequestMapping("/test1")
    public User test1() {
        //System.err.println("删除一条数据：" + userService.deleteById(791193918018543616L));
        //System.err.println("deleteAll：" + userService.deleteAll());
        //System.err.println("插入一条数据：" + userService.insertSelective(new User(1L, "张三", 17, 1)));
        User user = new User("张三", 17, 1);
        boolean result = userService.insert(user);
        //自动回写的ID
        Long id = user.getId();
        System.err.println("插入一条数据：" + result + ", 插入信息：" + user.toString());
        System.err.println("查询：" + userService.selectById(id).toString());
        System.err.println("更新一条数据：" + userService.updateSelectiveById(new User(1L, "三毛", 18, 2)));
        return userService.selectById(id);
    }

    /**
     * 插入 OR 修改
     */
    @RequestMapping("/test2")
    public User test2() {
        userService.insertOrUpdateSelective(new User(1L, "王五", 19, 3));
        return userService.selectById(1L);
    }

    /**
     * 分页 PAGE
     */
    @RequestMapping("/test3")
    public Page<User> test3() {
        EntityWrapper entityWrapper = new EntityWrapper(new User(),"test_id as id,name")
                .and("test_id=791209286145417216")
                .or("test_id={0}", 791209285495300096L)
                .orderBy("test_id");
        return userService.selectPage(new Page<User>(0, 1), entityWrapper);
    }

    @RequestMapping("/test4")
    public List<User> test4() {
        EntityWrapper entityWrapper = new EntityWrapper(new User(),"test_id as id,name")
                .and("test_id=791209286145417216")
                .or("test_id={0}", 791209285495300096L)
                .orderBy("test_id");
        System.out.println(entityWrapper.getSqlSegment());
        return userService.selectList(entityWrapper);
    }

}
