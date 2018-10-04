package kr.co.dwebss.fitDiary.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dwebss.fitDiary.core.AbstractService;
import kr.co.dwebss.fitDiary.dao.CommonCodeMapper;
import kr.co.dwebss.fitDiary.model.CommonCode;
import kr.co.dwebss.fitDiary.service.CommonCodeService;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/02.
 */
@Service
@Transactional
public class CommonCodeServiceImpl extends AbstractService<CommonCode> implements CommonCodeService {
    @Resource
    private CommonCodeMapper commonCodeMapper;

	@Override
	public List<CommonCode> selectCategory(CommonCode codeVO) {
		return commonCodeMapper.selectCategory(codeVO);
	}

	@Override
	public CommonCode selectCommonCode(CommonCode searchVO) {
		return commonCodeMapper.selectCommonCode(searchVO);
	}

	@Override
	public List<HashMap> selectList(CommonCode commonCode) {
		return commonCodeMapper.selectList(commonCode);
	}

	@Override
	public int selectListCnt(CommonCode commonCode) {
		return commonCodeMapper.selectListCnt(commonCode);
	}

}
