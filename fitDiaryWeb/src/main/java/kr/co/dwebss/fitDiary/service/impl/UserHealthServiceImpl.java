package kr.co.dwebss.fitDiary.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dwebss.fitDiary.core.AbstractService;
import kr.co.dwebss.fitDiary.dao.UserHealthMapper;
import kr.co.dwebss.fitDiary.model.UserHealth;
import kr.co.dwebss.fitDiary.service.UserHealthService;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/04.
 */
@Service
@Transactional
public class UserHealthServiceImpl extends AbstractService<UserHealth> implements UserHealthService {
    @Resource
    private UserHealthMapper userHealthMapper;

}
