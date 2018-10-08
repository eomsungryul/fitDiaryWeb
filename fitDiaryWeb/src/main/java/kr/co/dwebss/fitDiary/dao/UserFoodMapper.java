package kr.co.dwebss.fitDiary.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.fitDiary.core.Mapper;
import kr.co.dwebss.fitDiary.model.UserFood;

public interface UserFoodMapper extends Mapper<UserFood> {

//	List<HashMap> selectList(UserFood userFood);
	List<UserFood> selectList(UserFood userFood);

	int selectListCnt(UserFood userFood);
}