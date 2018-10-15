package kr.co.dwebss.fitDiary.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_food")
public class UserFood  extends SearchVO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 473624288219210287L;

	/**
     * 음식사진ID
     */
    @Id
    @Column(name = "USER_FOOD_ID")
    private Integer userFoodId;

    /**
     * 사용자ID
     */
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 날짜
     */
    @Column(name = "REGIST_D")
    private Date registD;

    /**
     * 시간
     */
    @Column(name = "REGIST_TIME")
    private Date registTime;

    /**
     * 파일원본이름
     */
    @Column(name = "FILE_NM")
    private String fileNm;
    
    @Column(name = "FIREBASE_STORAGE_PATH")
    private String firebaseStoragePath;

    @Column(name = "FIREBASE_DOWNLOAD_URL")
    private String firebaseDownloadUrl;
    
    @Column(name = "DEVICE_LOCAL_FILE_PATH")
    private String deviceLocalFilePath;
    
    @Transient
    private UserFoodDetail userFoodDetail;
    

    public UserFoodDetail getUserFoodDetail() {
		return userFoodDetail;
	}

	public void setUserFoodDetail(UserFoodDetail userFoodDetail) {
		this.userFoodDetail = userFoodDetail;
	}

	public String getFirebaseStoragePath() {
		return firebaseStoragePath;
	}

	public void setFirebaseStoragePath(String firebaseStoragePath) {
		this.firebaseStoragePath = firebaseStoragePath;
	}

	public String getFirebaseDownloadUrl() {
		return firebaseDownloadUrl;
	}

	public void setFirebaseDownloadUrl(String firebaseDownloadUrl) {
		this.firebaseDownloadUrl = firebaseDownloadUrl;
	}

	public String getDeviceLocalFilePath() {
		return deviceLocalFilePath;
	}

	public void setDeviceLocalFilePath(String deviceLocalFilePath) {
		this.deviceLocalFilePath = deviceLocalFilePath;
	}

	/**
     * 실제경로
     */
    @Column(name = "FILE_PATH")
    private String filePath;
    
    @Transient
    private String insertYn;

    public String getInsertYn() {
		return insertYn;
	}

	public void setInsertYn(String insertYn) {
		this.insertYn = insertYn;
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

    /**
     * getter시간
     *
     * @return REGIST_TIME - 시간
     */
    public Date getRegistTime() {
        return registTime;
    }

    /**
     * setter시간
     *
     * @param registTime 시간
     */
    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    /**
     * getter파일원본이름
     *
     * @return FILE_NM - 파일원본이름
     */
    public String getFileNm() {
        return fileNm;
    }

    /**
     * setter파일원본이름
     *
     * @param fileNm 파일원본이름
     */
    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }

    /**
     * getter실제경로
     *
     * @return FILE_PATH - 실제경로
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * setter실제경로
     *
     * @param filePath 실제경로
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}