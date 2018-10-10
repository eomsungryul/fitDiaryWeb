package kr.co.dwebss.fitDiary.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.fitDiary.core.Mapper;
import kr.co.dwebss.fitDiary.model.CommonCode;

public interface CommonCodeMapper extends Mapper<CommonCode> {

	CommonCode selectCommonCode(CommonCode searchVO);

	List<HashMap> selectList(CommonCode commonCode);

	int selectListCnt(CommonCode commonCode);
}