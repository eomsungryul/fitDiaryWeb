package kr.co.dwebss.fitDiary.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dwebss.fitDiary.core.AbstractService;
import kr.co.dwebss.fitDiary.dao.UserFoodMapper;
import kr.co.dwebss.fitDiary.model.UserFood;
import kr.co.dwebss.fitDiary.service.UserFoodService;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/04.
 */
@Service
@Transactional
public class UserFoodServiceImpl extends AbstractService<UserFood> implements UserFoodService {
    @Resource
    private UserFoodMapper userFoodMapper;

}
