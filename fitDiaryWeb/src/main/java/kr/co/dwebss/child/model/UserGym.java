package kr.co.dwebss.child.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_gym")
public class UserGym extends SearchVO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4037524185729879566L;

	/**
     * 사용자 헬스장 매핑 ID
     */
    @Id
    @Column(name = "USER_GYM_ID")
    private Integer userGymId;

    /**
     * 헬스장ID
     */
    @Column(name = "GYM_ID")
    private Integer gymId;

    /**
     * 사용자ID
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 사용자유형코드
     */
    @Column(name = "USER_ROLE_CD")
    private Integer userRoleCd;

    /**
     * 운동목표코드
     */
    @Column(name = "USER_EXERCISE_CD")
    private Integer userExerciseCd;

    /**
     * 회원제코드
     */
    @Column(name = "USER_MEMBERSHIP_CD")
    private Integer userMembershipCd;

    /**
     * 휴면회원여부
     */
    @Column(name = "DORMANCY_YN")
    private String dormancyYn;

    /**
     * 락커번호
     */
    @Column(name = "LOCKER_NUM")
    private Integer lockerNum;

    /**
     * PT여부
     */
    @Column(name = "PT_YN")
    private String ptYn;

    /**
     * OT여부
     */
    @Column(name = "OT_YN")
    private String otYn;

    /**
     * 헬스장 가입일
     */
    @Column(name = "GYM_START_D")
    private Date gymStartD;

    /**
     * 헬스장 종료일
     */
    @Column(name = "GYM_END_D")
    private Date gymEndD;

    /**
     * 사용자운동요일선택(0,1,2,3,4,5)
     */
    @Column(name = "USER_EXERCISING_D")
    private String userExercisingD;

    /**
     * 사용자 사진
     */
    @Column(name = "GYM_USER_IMAGE")
    private String gymUserImage;

    /**
     * 디바이스앱ID
     */
    @Column(name = "DEVICE_APP_ID")
    private String deviceAppId;

    /**
     * 승인여부
     */
    @Column(name = "APPROVAL_YN")
    private String approvalYn;

    /**
     * 유산소비율
     */
    @Column(name = "USER_CARDIO_RATIO")
    private BigDecimal userCardioRatio;

    /**
     * getter사용자 헬스장 매핑 ID
     *
     * @return USER_GYM_ID - 사용자 헬스장 매핑 ID
     */
    public Integer getUserGymId() {
        return userGymId;
    }

    /**
     * setter사용자 헬스장 매핑 ID
     *
     * @param userGymId 사용자 헬스장 매핑 ID
     */
    public void setUserGymId(Integer userGymId) {
        this.userGymId = userGymId;
    }

    /**
     * getter헬스장ID
     *
     * @return GYM_ID - 헬스장ID
     */
    public Integer getGymId() {
        return gymId;
    }

    /**
     * setter헬스장ID
     *
     * @param gymId 헬스장ID
     */
    public void setGymId(Integer gymId) {
        this.gymId = gymId;
    }

    /**
     * getter사용자ID
     *
     * @return USER_ID - 사용자ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * setter사용자ID
     *
     * @param userId 사용자ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * getter사용자유형코드
     *
     * @return USER_ROLE_CD - 사용자유형코드
     */
    public Integer getUserRoleCd() {
        return userRoleCd;
    }

    /**
     * setter사용자유형코드
     *
     * @param userRoleCd 사용자유형코드
     */
    public void setUserRoleCd(Integer userRoleCd) {
        this.userRoleCd = userRoleCd;
    }

    /**
     * getter운동목표코드
     *
     * @return USER_EXERCISE_CD - 운동목표코드
     */
    public Integer getUserExerciseCd() {
        return userExerciseCd;
    }

    /**
     * setter운동목표코드
     *
     * @param userExerciseCd 운동목표코드
     */
    public void setUserExerciseCd(Integer userExerciseCd) {
        this.userExerciseCd = userExerciseCd;
    }

    /**
     * getter회원제코드
     *
     * @return USER_MEMBERSHIP_CD - 회원제코드
     */
    public Integer getUserMembershipCd() {
        return userMembershipCd;
    }

    /**
     * setter회원제코드
     *
     * @param userMembershipCd 회원제코드
     */
    public void setUserMembershipCd(Integer userMembershipCd) {
        this.userMembershipCd = userMembershipCd;
    }

    /**
     * getter휴면회원여부
     *
     * @return DORMANCY_YN - 휴면회원여부
     */
    public String getDormancyYn() {
        return dormancyYn;
    }

    /**
     * setter휴면회원여부
     *
     * @param dormancyYn 휴면회원여부
     */
    public void setDormancyYn(String dormancyYn) {
        this.dormancyYn = dormancyYn;
    }

    /**
     * getter락커번호
     *
     * @return LOCKER_NUM - 락커번호
     */
    public Integer getLockerNum() {
        return lockerNum;
    }

    /**
     * setter락커번호
     *
     * @param lockerNum 락커번호
     */
    public void setLockerNum(Integer lockerNum) {
        this.lockerNum = lockerNum;
    }

    /**
     * getterPT여부
     *
     * @return PT_YN - PT여부
     */
    public String getPtYn() {
        return ptYn;
    }

    /**
     * setterPT여부
     *
     * @param ptYn PT여부
     */
    public void setPtYn(String ptYn) {
        this.ptYn = ptYn;
    }

    /**
     * getterOT여부
     *
     * @return OT_YN - OT여부
     */
    public String getOtYn() {
        return otYn;
    }

    /**
     * setterOT여부
     *
     * @param otYn OT여부
     */
    public void setOtYn(String otYn) {
        this.otYn = otYn;
    }

    /**
     * getter헬스장 가입일
     *
     * @return GYM_START_D - 헬스장 가입일
     */
    public Date getGymStartD() {
        return gymStartD;
    }

    /**
     * setter헬스장 가입일
     *
     * @param gymStartD 헬스장 가입일
     */
    public void setGymStartD(Date gymStartD) {
        this.gymStartD = gymStartD;
    }

    /**
     * getter헬스장 종료일
     *
     * @return GYM_END_D - 헬스장 종료일
     */
    public Date getGymEndD() {
        return gymEndD;
    }

    /**
     * setter헬스장 종료일
     *
     * @param gymEndD 헬스장 종료일
     */
    public void setGymEndD(Date gymEndD) {
        this.gymEndD = gymEndD;
    }

    /**
     * getter사용자운동요일선택(0,1,2,3,4,5)
     *
     * @return USER_EXERCISING_D - 사용자운동요일선택(0,1,2,3,4,5)
     */
    public String getUserExercisingD() {
        return userExercisingD;
    }

    /**
     * setter사용자운동요일선택(0,1,2,3,4,5)
     *
     * @param userExercisingD 사용자운동요일선택(0,1,2,3,4,5)
     */
    public void setUserExercisingD(String userExercisingD) {
        this.userExercisingD = userExercisingD;
    }

    /**
     * getter사용자 사진
     *
     * @return GYM_USER_IMAGE - 사용자 사진
     */
    public String getGymUserImage() {
        return gymUserImage;
    }

    /**
     * setter사용자 사진
     *
     * @param gymUserImage 사용자 사진
     */
    public void setGymUserImage(String gymUserImage) {
        this.gymUserImage = gymUserImage;
    }

    /**
     * getter디바이스앱ID
     *
     * @return DEVICE_APP_ID - 디바이스앱ID
     */
    public String getDeviceAppId() {
        return deviceAppId;
    }

    /**
     * setter디바이스앱ID
     *
     * @param deviceAppId 디바이스앱ID
     */
    public void setDeviceAppId(String deviceAppId) {
        this.deviceAppId = deviceAppId;
    }

    /**
     * getter승인여부
     *
     * @return APPROVAL_YN - 승인여부
     */
    public String getApprovalYn() {
        return approvalYn;
    }

    /**
     * setter승인여부
     *
     * @param approvalYn 승인여부
     */
    public void setApprovalYn(String approvalYn) {
        this.approvalYn = approvalYn;
    }

    /**
     * getter유산소비율
     *
     * @return USER_CARDIO_RATIO - 유산소비율
     */
    public BigDecimal getUserCardioRatio() {
        return userCardioRatio;
    }

    /**
     * setter유산소비율
     *
     * @param userCardioRatio 유산소비율
     */
    public void setUserCardioRatio(BigDecimal userCardioRatio) {
        this.userCardioRatio = userCardioRatio;
    }
}