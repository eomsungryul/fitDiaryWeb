package kr.co.dwebss.fitDiary.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Food extends SearchVO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4102478676226582931L;

	/**
     * 음식ID
     */
    @Id
    @Column(name = "FOOD_ID")
    private Integer foodId;

    /**
     * 음식종류
     */
    @Column(name = "FOOD_TYPE")
//    private Integer foodType;
    private String foodType;

    /**
     * 음식명
     */
    @Column(name = "FOOD_NM")
    private String foodNm;

    /**
     * 1회제공량
     */
    @Column(name = "SERVING_SIZE")
    private Integer servingSize;

    /**
     * 열량
     */
    @Column(name = "KILOCALORIE")
    private BigDecimal kilocalorie;

    /**
     * 탄수화물
     */
    @Column(name = "CARBOHYDRATE")
    private BigDecimal carbohydrate;

    /**
     * 단백질
     */
    @Column(name = "PROTEIN")
    private BigDecimal protein;

    /**
     * 지방
     */
    @Column(name = "FAT")
    private BigDecimal fat;

    /**
     * 당류
     */
    @Column(name = "SUGAR")
    private BigDecimal sugar;

    /**
     * 나트륨
     */
    @Column(name = "SODIUM")
    private BigDecimal sodium;

    /**
     * 콜레스테롤
     */
    @Column(name = "CHOLESTEROL")
    private BigDecimal cholesterol;

    /**
     * 포화지방산
     */
    @Column(name = "SATURATED_FATTY_ACID")
    private BigDecimal saturatedFattyAcid;

    /**
     * 트랜스지방산
     */
    @Column(name = "TRANS_FATTY_ACIDS")
    private BigDecimal transFattyAcids;

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
     * getter음식종류
     *
     * @return FOOD_TYPE - 음식종류
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * setter음식종류
     *
     * @param foodType 음식종류
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    /**
     * getter음식명
     *
     * @return FOOD_NM - 음식명
     */
    public String getFoodNm() {
        return foodNm;
    }

    /**
     * setter음식명
     *
     * @param foodNm 음식명
     */
    public void setFoodNm(String foodNm) {
        this.foodNm = foodNm;
    }

    /**
     * getter1회제공량
     *
     * @return SERVING_SIZE - 1회제공량
     */
    public Integer getServingSize() {
        return servingSize;
    }

    /**
     * setter1회제공량
     *
     * @param servingSize 1회제공량
     */
    public void setServingSize(Integer servingSize) {
        this.servingSize = servingSize;
    }

    /**
     * getter열량
     *
     * @return KILOCALORIE - 열량
     */
    public BigDecimal getKilocalorie() {
        return kilocalorie;
    }

    /**
     * setter열량
     *
     * @param kilocalorie 열량
     */
    public void setKilocalorie(BigDecimal kilocalorie) {
        this.kilocalorie = kilocalorie;
    }

    /**
     * getter탄수화물
     *
     * @return CARBOHYDRATE - 탄수화물
     */
    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    /**
     * setter탄수화물
     *
     * @param carbohydrate 탄수화물
     */
    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    /**
     * getter단백질
     *
     * @return PROTEIN - 단백질
     */
    public BigDecimal getProtein() {
        return protein;
    }

    /**
     * setter단백질
     *
     * @param protein 단백질
     */
    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    /**
     * getter지방
     *
     * @return FAT - 지방
     */
    public BigDecimal getFat() {
        return fat;
    }

    /**
     * setter지방
     *
     * @param fat 지방
     */
    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    /**
     * getter당류
     *
     * @return SUGAR - 당류
     */
    public BigDecimal getSugar() {
        return sugar;
    }

    /**
     * setter당류
     *
     * @param sugar 당류
     */
    public void setSugar(BigDecimal sugar) {
        this.sugar = sugar;
    }

    /**
     * getter나트륨
     *
     * @return SODIUM - 나트륨
     */
    public BigDecimal getSodium() {
        return sodium;
    }

    /**
     * setter나트륨
     *
     * @param sodium 나트륨
     */
    public void setSodium(BigDecimal sodium) {
        this.sodium = sodium;
    }

    /**
     * getter콜레스테롤
     *
     * @return CHOLESTEROL - 콜레스테롤
     */
    public BigDecimal getCholesterol() {
        return cholesterol;
    }

    /**
     * setter콜레스테롤
     *
     * @param cholesterol 콜레스테롤
     */
    public void setCholesterol(BigDecimal cholesterol) {
        this.cholesterol = cholesterol;
    }

    /**
     * getter포화지방산
     *
     * @return SATURATED_FATTY_ACID - 포화지방산
     */
    public BigDecimal getSaturatedFattyAcid() {
        return saturatedFattyAcid;
    }

    /**
     * setter포화지방산
     *
     * @param saturatedFattyAcid 포화지방산
     */
    public void setSaturatedFattyAcid(BigDecimal saturatedFattyAcid) {
        this.saturatedFattyAcid = saturatedFattyAcid;
    }

    /**
     * getter트랜스지방산
     *
     * @return TRANS_FATTY_ACIDS - 트랜스지방산
     */
    public BigDecimal getTransFattyAcids() {
        return transFattyAcids;
    }

    /**
     * setter트랜스지방산
     *
     * @param transFattyAcids 트랜스지방산
     */
    public void setTransFattyAcids(BigDecimal transFattyAcids) {
        this.transFattyAcids = transFattyAcids;
    }
}