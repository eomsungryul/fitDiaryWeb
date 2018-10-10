package kr.co.dwebss.fitDiary.dao;

import kr.co.dwebss.fitDiary.core.Mapper;
import kr.co.dwebss.fitDiary.model.ExerciseInfo;

public interface ExerciseInfoMapper extends Mapper<ExerciseInfo> {

	int selectCnt(ExerciseInfo exerciseInfo);

	void updateUseN(ExerciseInfo exerciseInfo);

	ExerciseInfo selectExerciseInfo(ExerciseInfo exerciseInfo);
}