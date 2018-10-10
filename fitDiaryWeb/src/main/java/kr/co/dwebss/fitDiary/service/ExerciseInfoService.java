package kr.co.dwebss.fitDiary.service;
import kr.co.dwebss.fitDiary.model.ExerciseInfo;
import kr.co.dwebss.fitDiary.core.Service;


/**
 * Created by 엄성렬 on 2018/10/10.
 */
public interface ExerciseInfoService extends Service<ExerciseInfo> {

	void updateUseN(ExerciseInfo exerciseInfo);

	int selectCnt(ExerciseInfo exerciseInfo);

	ExerciseInfo selectExerciseInfo(ExerciseInfo exerciseInfo);

}
