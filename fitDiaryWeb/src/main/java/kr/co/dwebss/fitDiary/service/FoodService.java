package kr.co.dwebss.fitDiary.service;
import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.fitDiary.core.Service;
import kr.co.dwebss.fitDiary.model.Food;


/**
 * Created by 엄성렬 on 2018/10/04.
 */
public interface FoodService extends Service<Food> {

	List<HashMap> selectList(Food food);

	int selectListCnt(Food food);

	List<HashMap> selectFood(Food food);

}
