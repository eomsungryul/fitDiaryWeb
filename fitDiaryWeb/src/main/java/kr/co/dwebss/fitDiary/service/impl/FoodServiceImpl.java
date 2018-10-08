package kr.co.dwebss.fitDiary.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dwebss.fitDiary.core.AbstractService;
import kr.co.dwebss.fitDiary.dao.FoodMapper;
import kr.co.dwebss.fitDiary.model.Food;
import kr.co.dwebss.fitDiary.service.FoodService;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/04.
 */
@Service
@Transactional
public class FoodServiceImpl extends AbstractService<Food> implements FoodService {
    @Resource
    private FoodMapper foodMapper;

	@Override
	public List<HashMap> selectList(Food food) {
		return foodMapper.selectList(food);
	}

	@Override
	public int selectListCnt(Food food) {
		return foodMapper.selectListCnt(food);
	}

}
