package com.abs.entity.core;

import com.abs.entity.core.constants.UserSexType;
import com.abs.infrastructure.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户详细信息表。
 */
@Entity
@Table(indexes = {
        // 非唯一索引。
        @Index(columnList = "age")
})
public class UserDetails extends BaseEntity {


    private static final long serialVersionUID = -1384159351138305138L;

    /**
     * 用户真实姓名。
     */
    @Column(length = 80)
    private String realName;

    /**
     * 性别。
     */
    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserSexType userSexType;

    /**
     * 年龄。
     */
    @Column(length = 3)
    private Integer age;

    /**
     * 出生时间。
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date bornTime;

    /**
     * 身份证号码。
     */
    @Column(length = 100,unique = true)
    private String idCardNum;

    /**
     * 常住地址。
     */
    @Column(length = 150)
    private String houseAddr;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public UserSexType getUserSexType() {
        return userSexType;
    }

    public void setUserSexType(UserSexType userSexType) {
        this.userSexType = userSexType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBornTime() {
        return bornTime;
    }

    public void setBornTime(Date bornTime) {
        this.bornTime = bornTime;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr;
    }
}
