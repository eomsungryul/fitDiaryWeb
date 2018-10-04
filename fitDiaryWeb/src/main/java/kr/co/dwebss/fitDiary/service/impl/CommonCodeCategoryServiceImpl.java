package kr.co.dwebss.fitDiary.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dwebss.fitDiary.core.AbstractService;
import kr.co.dwebss.fitDiary.dao.CommonCodeCategoryMapper;
import kr.co.dwebss.fitDiary.model.CommonCodeCategory;
import kr.co.dwebss.fitDiary.service.CommonCodeCategoryService;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/02.
 */
@Service
@Transactional
public class CommonCodeCategoryServiceImpl extends AbstractService<CommonCodeCategory> implements CommonCodeCategoryService {
    @Resource
    private CommonCodeCategoryMapper commonCodeCategoryMapper;

}
