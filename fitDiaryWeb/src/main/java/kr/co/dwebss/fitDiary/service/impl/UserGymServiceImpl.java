package kr.co.dwebss.fitDiary.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dwebss.fitDiary.core.AbstractService;
import kr.co.dwebss.fitDiary.dao.UserGymMapper;
import kr.co.dwebss.fitDiary.model.UserGym;
import kr.co.dwebss.fitDiary.service.UserGymService;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/10/02.
 */
@Service
@Transactional
public class UserGymServiceImpl extends AbstractService<UserGym> implements UserGymService {
    @Resource
    private UserGymMapper userGymMapper;

}
