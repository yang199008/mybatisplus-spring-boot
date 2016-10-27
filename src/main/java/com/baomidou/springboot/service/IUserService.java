package com.baomidou.springboot.service;

import com.baomidou.springboot.entity.User;
import com.baomidou.framework.service.ISuperService;

import java.util.List;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService extends ISuperService<User> {

	boolean deleteAll();

	List<User> selectAll();

}