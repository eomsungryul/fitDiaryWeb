package kr.co.dwebss.fitDiary.model;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "exercise_info")
public class ExerciseInfo  extends SearchVO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7120627854783561878L;

	/**
     * 운동정보ID
     */
    @Id
    @Column(name = "EXERCISE_INFO_ID")
    private Integer exerciseInfoId;

    /**
     * 운동기구코드
     */
    @Column(name = "EXERCISE_EQUIP_CD")
    private Integer exerciseEquipCd;

    /**
     * 운동범위코드
     */
    @Column(name = "EXERCISE_RANGE_CD")
    private Integer exerciseRangeCd;

    /**
     * 운동명
     */
    @Column(name = "EXERCISE_NM")
    private String exerciseNm;

    /**
     * 운동 설명
     */
    @Column(name = "EXERCISE_DESC")
    private String exerciseDesc;

    /**
     * 운동추천영상
     */
    @Column(name = "EXERCISE_VIDEO")
    private String exerciseVideo;

    /**
     * 삭제여부
     */
    @Column(name = "USE_YN")
    private String useYn;

    /**
     * 유산소여부
     */
    @Column(name = "CARDIO_YN")
    private String cardioYn;
    
    @Transient
	private int code = 0;

    @Transient
	private int[] partArray;
    
    
    

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int[] getPartArray() {
		return partArray;
	}

	public void setPartArray(int[] partArray) {
		this.partArray = partArray;
	}

	/**
     * getter운동정보ID
     *
     * @return EXERCISE_INFO_ID - 운동정보ID
     */
    public Integer getExerciseInfoId() {
        return exerciseInfoId;
    }

    /**
     * setter운동정보ID
     *
     * @param exerciseInfoId 운동정보ID
     */
    public void setExerciseInfoId(Integer exerciseInfoId) {
        this.exerciseInfoId = exerciseInfoId;
    }

    /**
     * getter운동기구코드
     *
     * @return EXERCISE_EQUIP_CD - 운동기구코드
     */
    public Integer getExerciseEquipCd() {
        return exerciseEquipCd;
    }

    /**
     * setter운동기구코드
     *
     * @param exerciseEquipCd 운동기구코드
     */
    public void setExerciseEquipCd(Integer exerciseEquipCd) {
        this.exerciseEquipCd = exerciseEquipCd;
    }

    /**
     * getter운동범위코드
     *
     * @return EXERCISE_RANGE_CD - 운동범위코드
     */
    public Integer getExerciseRangeCd() {
        return exerciseRangeCd;
    }

    /**
     * setter운동범위코드
     *
     * @param exerciseRangeCd 운동범위코드
     */
    public void setExerciseRangeCd(Integer exerciseRangeCd) {
        this.exerciseRangeCd = exerciseRangeCd;
    }

    /**
     * getter운동명
     *
     * @return EXERCISE_NM - 운동명
     */
    public String getExerciseNm() {
        return exerciseNm;
    }

    /**
     * setter운동명
     *
     * @param exerciseNm 운동명
     */
    public void setExerciseNm(String exerciseNm) {
        this.exerciseNm = exerciseNm;
    }

    /**
     * getter운동 설명
     *
     * @return EXERCISE_DESC - 운동 설명
     */
    public String getExerciseDesc() {
        return exerciseDesc;
    }

    /**
     * setter운동 설명
     *
     * @param exerciseDesc 운동 설명
     */
    public void setExerciseDesc(String exerciseDesc) {
        this.exerciseDesc = exerciseDesc;
    }

    /**
     * getter운동추천영상
     *
     * @return EXERCISE_VIDEO - 운동추천영상
     */
    public String getExerciseVideo() {
        return exerciseVideo;
    }

    /**
     * setter운동추천영상
     *
     * @param exerciseVideo 운동추천영상
     */
    public void setExerciseVideo(String exerciseVideo) {
        this.exerciseVideo = exerciseVideo;
    }

    /**
     * getter삭제여부
     *
     * @return USE_YN - 삭제여부
     */
    public String getUseYn() {
        return useYn;
    }

    /**
     * setter삭제여부
     *
     * @param useYn 삭제여부
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
     * getter유산소여부
     *
     * @return CARDIO_YN - 유산소여부
     */
    public String getCardioYn() {
        return cardioYn;
    }

    /**
     * setter유산소여부
     *
     * @param cardioYn 유산소여부
     */
    public void setCardioYn(String cardioYn) {
        this.cardioYn = cardioYn;
    }
}