package com.abs.entity.core;

import com.abs.entity.core.constants.UserUsableType;
import com.abs.entity.core.constants.UserType;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户基础信息表。
 */
@Entity
public class User extends BaseEntity {

    private static final long serialVersionUID = 7582369102930562542L;

    /**
     * 用户登录名。
     */
    @Column(length = 100, unique = true)
    private String userName;

    /**
     * 登录密码。
     */
    @Column(length = 180, nullable = false)
    private String password;

    /**
     * 手机号码。可用手机号码登录。
     */
    @Column(length = 15,unique = true,nullable = false)
    private String mobile;

    /**
     * 用户别名。
     */
    @Column(length = 50)
    private String nickName;

    /**
     * 会员类型。默认是普通会员。
     */
    @Column(length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.ORDINARY;

    /**
     * 会员可用状态。默认不可用。
     */
    @Column(length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserUsableType userUsableType = UserUsableType.DISABLE;

    /**
     * 登录状态。1-在线；0-不在线;
     */
    @Column(nullable = false, columnDefinition = "decimal(1,0)")
    private Boolean loginStatus;

    /**
     * 最近登录时间。
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;

    /**
     * 最近登出时间。
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutTime;

    /**
     * 用户详情。
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserUsableType getUserUsableType() {
        return userUsableType;
    }

    public void setUserUsableType(UserUsableType userUsableType) {
        this.userUsableType = userUsableType;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
}
