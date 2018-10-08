package kr.co.dwebss.fitDiary.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.fitDiary.core.Mapper;
import kr.co.dwebss.fitDiary.model.Food;

public interface FoodMapper extends Mapper<Food> {

	List<HashMap> selectList(Food food);

	int selectListCnt(Food food);
}