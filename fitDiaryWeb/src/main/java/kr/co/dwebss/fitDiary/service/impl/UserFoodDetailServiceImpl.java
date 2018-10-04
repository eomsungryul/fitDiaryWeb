package kr.co.dwebss.fitDiary.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dwebss.fitDiary.core.AbstractService;
import kr.co.dwebss.fitDiary.dao.UserFoodDetailMapper;
import kr.co.dwebss.fitDiary.model.UserFoodDetail;
import kr.co.dwebss.fitDiary.service.UserFoodDetailService;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/04.
 */
@Service
@Transactional
public class UserFoodDetailServiceImpl extends AbstractService<UserFoodDetail> implements UserFoodDetailService {
    @Resource
    private UserFoodDetailMapper userFoodDetailMapper;

}
