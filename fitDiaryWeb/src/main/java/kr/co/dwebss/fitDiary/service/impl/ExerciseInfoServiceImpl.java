package kr.co.dwebss.fitDiary.service.impl;

import kr.co.dwebss.fitDiary.dao.ExerciseInfoMapper;
import kr.co.dwebss.fitDiary.model.ExerciseInfo;
import kr.co.dwebss.fitDiary.service.ExerciseInfoService;
import kr.co.dwebss.fitDiary.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/10.
 */
@Service
@Transactional
public class ExerciseInfoServiceImpl extends AbstractService<ExerciseInfo> implements ExerciseInfoService {
    @Resource
    private ExerciseInfoMapper exerciseInfoMapper;

	@Override
	public ExerciseInfo selectExerciseInfo(ExerciseInfo exerciseInfo) {
		return exerciseInfoMapper.selectExerciseInfo(exerciseInfo);
	}

	@Override
	public void updateUseN(ExerciseInfo exerciseInfo) {
		exerciseInfoMapper.updateUseN(exerciseInfo);
	}

	@Override
	public int selectCnt(ExerciseInfo exerciseInfo) {
		return exerciseInfoMapper.selectCnt(exerciseInfo);
	}

}
