package kr.co.dwebss.fitDiary.service;
import java.util.List;

import kr.co.dwebss.fitDiary.core.Service;
import kr.co.dwebss.fitDiary.model.UserFoodDetail;


/**
 * Created by 엄성렬 on 2018/10/04.
 */
public interface UserFoodDetailService extends Service<UserFoodDetail> {

	void deleteUserFoodDetail(int parseInt);

	List<UserFoodDetail> selectUserFoodDetail(int parseInt);

}
