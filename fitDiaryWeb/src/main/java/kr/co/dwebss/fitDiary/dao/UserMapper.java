package kr.co.dwebss.fitDiary.dao;

import kr.co.dwebss.fitDiary.core.Mapper;
import kr.co.dwebss.fitDiary.model.User;

public interface UserMapper extends Mapper<User> {

	User selectUser(User vo);
}