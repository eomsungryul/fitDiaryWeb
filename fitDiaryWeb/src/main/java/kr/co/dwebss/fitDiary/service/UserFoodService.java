package kr.co.dwebss.fitDiary.service;
import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.fitDiary.core.Service;
import kr.co.dwebss.fitDiary.model.Food;
import kr.co.dwebss.fitDiary.model.UserFood;


/**
 * Created by 엄성렬 on 2018/10/04.
 */
public interface UserFoodService extends Service<UserFood> {

//	List<HashMap> selectList(UserFood userFood);
	List<UserFood> selectList(UserFood userFood);

	int selectListCnt(UserFood userFood);

}
