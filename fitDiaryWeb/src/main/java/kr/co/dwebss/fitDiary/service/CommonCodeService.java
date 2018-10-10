package kr.co.dwebss.fitDiary.service;
import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.fitDiary.core.Service;
import kr.co.dwebss.fitDiary.model.CommonCode;


/**
 * Created by 엄성렬 on 2018/10/02.
 */
public interface CommonCodeService extends Service<CommonCode> {

	CommonCode selectCommonCode(CommonCode searchVO);

	List<HashMap> selectList(CommonCode commonCode);

	int selectListCnt(CommonCode commonCode);

	List<HashMap> selectPart(CommonCode commonCode);

}
