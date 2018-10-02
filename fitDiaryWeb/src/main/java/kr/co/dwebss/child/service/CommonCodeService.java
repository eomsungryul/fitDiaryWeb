package kr.co.dwebss.child.service;
import kr.co.dwebss.child.model.CommonCode;

import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.child.core.Service;


/**
 * Created by 엄성렬 on 2018/10/02.
 */
public interface CommonCodeService extends Service<CommonCode> {

	List<CommonCode> selectCategory(CommonCode codeVO);

	CommonCode selectCommonCode(CommonCode searchVO);

	List<HashMap> selectList(CommonCode commonCode);

	int selectListCnt(CommonCode commonCode);

}
