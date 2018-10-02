package kr.co.dwebss.child.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.child.core.Mapper;
import kr.co.dwebss.child.model.CommonCode;

public interface CommonCodeMapper extends Mapper<CommonCode> {

	List<CommonCode> selectCategory(CommonCode codeVO);

	CommonCode selectCommonCode(CommonCode searchVO);

	List<HashMap> selectList(CommonCode commonCode);

	int selectListCnt(CommonCode commonCode);
}