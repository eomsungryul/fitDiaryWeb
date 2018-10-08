package kr.co.dwebss.fitDiary.dao;

import java.util.List;

import kr.co.dwebss.fitDiary.core.Mapper;
import kr.co.dwebss.fitDiary.model.UserFoodDetail;

public interface UserFoodDetailMapper extends Mapper<UserFoodDetail> {

	void deleteUserFoodDetail(int userFoodId);

	List<UserFoodDetail> selectUserFoodDetail(int userFoodId);
}