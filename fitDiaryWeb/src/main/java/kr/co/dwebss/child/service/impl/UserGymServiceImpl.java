package kr.co.dwebss.child.service.impl;

import kr.co.dwebss.child.dao.UserGymMapper;
import kr.co.dwebss.child.model.UserGym;
import kr.co.dwebss.child.service.UserGymService;
import kr.co.dwebss.child.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
