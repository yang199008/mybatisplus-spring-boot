package com.baomidou.springboot.mapper;

import com.baomidou.springboot.entity.User;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.List;

/**
 *
 * User 表数据库控制层接口
 *
 */
public interface UserMapper extends AutoMapper<User> {

	/**
	 * 自定义注入方法
	 */
	int deleteAll();
	List<User> selectAll();

}