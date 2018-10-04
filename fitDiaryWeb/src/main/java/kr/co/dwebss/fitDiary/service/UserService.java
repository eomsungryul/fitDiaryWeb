package kr.co.dwebss.fitDiary.service;
import java.util.List;

import kr.co.dwebss.fitDiary.core.Service;
import kr.co.dwebss.fitDiary.model.User;


/**
 * Created by 엄성렬 on 2018/10/02.
 */
public interface UserService extends Service<User> {

	List<User> selectList(User vo);

	int selectListCnt(User vo);

	User selectUser(User vo);

}
