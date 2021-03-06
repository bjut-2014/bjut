package cn.internship.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 * @author dreamlate
 */
@Entity
@Table(name="user")
public class User {
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	//用户类型
	private Integer userType;
	//权限
	private Integer rights;

	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getRights() {
		return rights;
	}
	public void setRights(Integer rights) {
		this.rights = rights;
	}
	
	
}
