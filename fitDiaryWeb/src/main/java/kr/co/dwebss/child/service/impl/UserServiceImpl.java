package kr.co.dwebss.child.service.impl;

import kr.co.dwebss.child.dao.UserMapper;
import kr.co.dwebss.child.model.User;
import kr.co.dwebss.child.service.UserService;
import kr.co.dwebss.child.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/02.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

	@Override
	public List<User> selectList(User vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectListCnt(User vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectUser(User vo) {
		return userMapper.selectUser(vo);
	}

}
