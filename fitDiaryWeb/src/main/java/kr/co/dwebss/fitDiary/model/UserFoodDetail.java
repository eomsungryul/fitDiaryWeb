package kr.co.dwebss.fitDiary.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "user_food_detail")
public class UserFoodDetail {
    /**
     * 음식사진상세ID
     */
    @Id
    @Column(name = "USER_FOOD_DETAIL_ID")
    private Integer userFoodDetailId;

    /**
     * 음식사진ID
     */
    @Column(name = "USER_FOOD_ID")
    private Integer userFoodId;

    /**
     * 음식ID
     */
    @Column(name = "FOOD_ID")
    private Integer foodId;

    /**
     * 인분
     */
    @Column(name = "AMOUNT_DISH")
    private BigDecimal amountDish;
    
    @Transient
    private BigDecimal kilocalorie;

    @Transient
    private Integer servingSize;
    
    @Transient
    private String foodNm;


    public BigDecimal getKilocalorie() {
		return kilocalorie;
	}

	public void setKilocalorie(BigDecimal kilocalorie) {
		this.kilocalorie = kilocalorie;
	}

	public Integer getServingSize() {
		return servingSize;
	}

	public void setServingSize(Integer servingSize) {
		this.servingSize = servingSize;
	}

	public String getFoodNm() {
		return foodNm;
	}

	public void setFoodNm(String foodNm) {
		this.foodNm = foodNm;
	}

	/**
     * getter음식사진상세ID
     *
     * @return USER_FOOD_DETAIL_ID - 음식사진상세ID
     */
    public Integer getUserFoodDetailId() {
        return userFoodDetailId;
    }

    /**
     * setter음식사진상세ID
     *
     * @param userFoodDetailId 음식사진상세ID
     */
    public void setUserFoodDetailId(Integer userFoodDetailId) {
        this.userFoodDetailId = userFoodDetailId;
    }

    /**
     * getter음식사진ID
     *
     * @return USER_FOOD_ID - 음식사진ID
     */
    public Integer getUserFoodId() {
        return userFoodId;
    }

    /**
     * setter음식사진ID
     *
     * @param userFoodId 음식사진ID
     */
    public void setUserFoodId(Integer userFoodId) {
        this.userFoodId = userFoodId;
    }

    /**
     * getter음식ID
     *
     * @return FOOD_ID - 음식ID
     */
    public Integer getFoodId() {
        return foodId;
    }

    /**
     * setter음식ID
     *
     * @param foodId 음식ID
     */
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    /**
     * getter인분
     *
     * @return AMOUNT_DISH - 인분
     */
    public BigDecimal getAmountDish() {
        return amountDish;
    }

    /**
     * setter인분
     *
     * @param amountDish 인분
     */
    public void setAmountDish(BigDecimal amountDish) {
        this.amountDish = amountDish;
    }
}