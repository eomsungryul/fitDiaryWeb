package kr.co.dwebss.fitDiary.service;
import kr.co.dwebss.fitDiary.core.Service;
import kr.co.dwebss.fitDiary.model.UserHealth;


/**
 * Created by 엄성렬 on 2018/10/04.
 */
public interface UserHealthService extends Service<UserHealth> {

	UserHealth selectInsertList(UserHealth userHealth);

}
