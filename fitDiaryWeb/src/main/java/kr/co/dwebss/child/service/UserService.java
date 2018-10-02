package kr.co.dwebss.child.service;
import kr.co.dwebss.child.model.User;

import java.util.List;

import kr.co.dwebss.child.core.Service;


/**
 * Created by 엄성렬 on 2018/10/02.
 */
public interface UserService extends Service<User> {

	List<User> selectList(User vo);

	int selectListCnt(User vo);

	User selectUser(User vo);

}
