package com.baomidou.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.mapper.UserMapper;
import com.baomidou.springboot.service.IUserService;

import java.util.List;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

	@Override
	public List<User> selectAll() {
		return super.baseMapper.selectAll();
	}

}