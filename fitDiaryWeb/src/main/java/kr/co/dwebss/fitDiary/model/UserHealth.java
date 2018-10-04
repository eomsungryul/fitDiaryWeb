package kr.co.dwebss.fitDiary.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_health")
public class UserHealth {
    /**
     * 헬시포인트ID
     */
    @Id
    @Column(name = "USER_HEALTH_ID")
    private Integer userHealthId;

    /**
     * 사용자ID
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 금일섭취한칼로리 
     */
    @Column(name = "DAY_KILOCALORIE")
    private Date dayKilocalorie;

    /**
     * 체중
     */
    @Column(name = "WEIGHT")
    private BigDecimal weight;

    /**
     * 체지방
     */
    @Column(name = "FAT")
    private BigDecimal fat;

    /**
     * 근육량
     */
    @Column(name = "MUSCLE")
    private BigDecimal muscle;

    /**
     * 날짜
     */
    @Column(name = "REGIST_D")
    private Date registD;

    /**
     * getter헬시포인트ID
     *
     * @return USER_HEALTH_ID - 헬시포인트ID
     */
    public Integer getUserHealthId() {
        return userHealthId;
    }

    /**
     * setter헬시포인트ID
     *
     * @param userHealthId 헬시포인트ID
     */
    public void setUserHealthId(Integer userHealthId) {
        this.userHealthId = userHealthId;
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
     * getter금일섭취한칼로리 
     *
     * @return DAY_KILOCALORIE - 금일섭취한칼로리 
     */
    public Date getDayKilocalorie() {
        return dayKilocalorie;
    }

    /**
     * setter금일섭취한칼로리 
     *
     * @param dayKilocalorie 금일섭취한칼로리 
     */
    public void setDayKilocalorie(Date dayKilocalorie) {
        this.dayKilocalorie = dayKilocalorie;
    }

    /**
     * getter체중
     *
     * @return WEIGHT - 체중
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * setter체중
     *
     * @param weight 체중
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * getter체지방
     *
     * @return FAT - 체지방
     */
    public BigDecimal getFat() {
        return fat;
    }

    /**
     * setter체지방
     *
     * @param fat 체지방
     */
    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    /**
     * getter근육량
     *
     * @return MUSCLE - 근육량
     */
    public BigDecimal getMuscle() {
        return muscle;
    }

    /**
     * setter근육량
     *
     * @param muscle 근육량
     */
    public void setMuscle(BigDecimal muscle) {
        this.muscle = muscle;
    }

    /**
     * getter날짜
     *
     * @return REGIST_D - 날짜
     */
    public Date getRegistD() {
        return registD;
    }

    /**
     * setter날짜
     *
     * @param registD 날짜
     */
    public void setRegistD(Date registD) {
        this.registD = registD;
    }
}