package com.hotent.platform.model.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import com.hotent.core.cache.ICache;
import com.hotent.core.model.BaseModel;
import com.hotent.core.util.AppUtil;
import com.hotent.core.util.BeanUtils;
import com.hotent.core.util.ContextUtil;
import com.hotent.platform.auth.ISysOrg;
import com.hotent.platform.auth.ISysRole;
import com.hotent.platform.auth.ISysUser;
import com.hotent.platform.service.system.SecurityUtil;
import com.hotent.platform.service.system.SysOrgRoleService;
import com.hotent.platform.service.system.SysOrgService;
import com.hotent.platform.service.system.SysRoleService;
import com.hotent.platform.webservice.api.util.adapter.GrantedAuthorityAdapter;

/**
 * 对象功能:用户表 Model对象 开发公司: 开发人员:hotent 创建时间:2011-11-03 16:02:45
 */
public class SysUser extends BaseModel implements ISysUser{
	public final static String SEARCH_BY_ROL = "1";// 从角色
	public final static String SEARCH_BY_ORG = "2";// 从组织
	public final static String SEARCH_BY_POS = "3";// 从岗位
	public final static String SEARCH_BY_ONL = "4";// 从在线

	/**
	 * 账号未锁定
	 */
	public final static Short UN_LOCKED = 0;
	/**
	 * 账号被锁定
	 */
	public final static Short LOCKED = 1;

	/**
	 * 账号未期
	 */
	public final static Short UN_EXPIRED = 0;

	/**
	 * 账号过期
	 */
	public final static Short EXPIRED = 1;

	/**
	 * 账号激活
	 */
	public final static Short STATUS_OK = 1;

	/**
	 * 账号禁用
	 */
	public final static Short STATUS_NO = 0;
	/**
	 * 账号删除
	 */
	public final static Short STATUS_Del = -1;
	
	/**
	 * 数据来自系统添加
	 */
	public final static Short FROMTYPE_DB=0;
	/**
	 * 数据来自AD同步,并在系统中未被设置
	 */
	public final static Short FROMTYPE_AD=1;
	/**
	 * 数据来自AD同步,并在系统中被设置过
	 */
	public final static Short FROMTYPE_AD_SET=2;

	// userOrgId
	protected Long userOrgId;
	// userId
	protected Long userId;
	// 姓名
	protected String fullname;
	// 帐号
	protected String account;
	// 短帐号
	protected String  shortAccount;
	// 密码
	protected String password;
	// 是否过期
	protected Short isExpired;
	// 是否锁定
	protected Short isLock;
	// 创建时间
	protected java.util.Date createtime;
	// 状态
	protected Short status;
	// 邮箱
	protected String email;
	// 手机
	protected String mobile;
	// 电话
	protected String phone;

	// 性别
	protected String sex;
	// 照片
	protected String picture;

	// 类型
	protected String retype;
	
	/**
	 * 数据来源
	 */
	protected short fromType;
	// orgId
	protected Long  orgId;
	
	// orgSn
	protected Long  orgSn;

	protected String psnSecretLevel;

	public String getPsnSecretLevel() {
		return psnSecretLevel;
	}

	public void setPsnSecretLevel(String psnSecretLevel) {
		this.psnSecretLevel = psnSecretLevel;
	}

	public Short getFromType() {
		return fromType;
	}
	
	public void setFromType(Short fromType) {
		this.fromType = fromType;
	}

	public String getRetype() {
		return retype;
	}

	public void setRetype(String retype) {
		this.retype = retype;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	// 组织名称
	protected String orgName;

	public Long getUserOrgId() {
		return userOrgId;
	}

	public void setUserOrgId(Long userOrgId) {
		this.userOrgId = userOrgId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 返回 userId
	 * 
	 * @return
	 */
	public Long getUserId() {
		return userId;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * 返回 姓名
	 * 
	 * @return
	 */
	public String getFullname() {
		return fullname;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 返回 帐号
	 * 
	 * @return
	 */
	public String getAccount() {
		return account;
	}

	public String getShortAccount() {
		return shortAccount;
	}

	public void setShortAccount(String shortAccount) {
		this.shortAccount = shortAccount;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 返回 密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	public void setIsExpired(Short isExpired) {
		this.isExpired = isExpired;
	}

	/**
	 * 返回 是否过期
	 * 
	 * @return
	 */
	public Short getIsExpired() {
		return isExpired;
	}

	public void setIsLock(Short isLock) {
		this.isLock = isLock;
	}

	/**
	 * 返回 是否锁定
	 * 
	 * @return
	 */
	public Short getIsLock() {
		return isLock;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 返回 创建时间
	 * 
	 * @return
	 */
	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	/**
	 * 返回 状态
	 * 
	 * @return
	 */
	public Short getStatus() {
		return status;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 返回 邮箱
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 返回 手机
	 * 
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 返回 电话
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	public static String getSearchByRol() {
		return SEARCH_BY_ROL;
	}

	public static String getSearchByOrg() {
		return SEARCH_BY_ORG;
	}

	public static String getSearchByPos() {
		return SEARCH_BY_POS;
	}

	public static String getSearchByOnl() {
		return SEARCH_BY_ONL;
	}

	public static Short getUnLocked() {
		return UN_LOCKED;
	}

	public static Short getLocked() {
		return LOCKED;
	}

	public static Short getUnExpired() {
		return UN_EXPIRED;
	}

	public static Short getExpired() {
		return EXPIRED;
	}

	public static Short getStatusOk() {
		return STATUS_OK;
	}

	public static Short getStatusNo() {
		return STATUS_NO;
	}

	public static Short getStatusDel() {
		return STATUS_Del;
	}
	public void setOrgId(Long orgId) 
	{
		this.orgId = orgId;
	}
	/**
	 * 返回 orgId
	 * @return
	 */
	public Long getOrgId() 
	{
		return this.orgId;
	}
	public void setOrgSn(Long orgSn) 
	{
		this.orgSn = orgSn;
	}
	/**
	 * 返回 orgSn
	 * @return
	 */
	public Long getOrgSn() 
	{
		return this.orgSn;
	}
	/**
	 * @see Object#equals(Object)
	 */
	
	@Override
	public boolean equals(Object rhs) {
		
        if (rhs instanceof SysUser) {
            return this.account.equals(((SysUser) rhs).account);
        }
        return false;
    }

	/**
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.account.hashCode();

		
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("userId", this.userId).append("fullname", this.fullname).append("account", this.account)
				.append("password", this.password).append("isExpired", this.isExpired).append("isLock", this.isLock).append("createtime", this.createtime)
				.append("status", this.status).append("email", this.email).append("mobile", this.mobile).append("phone", this.phone)
				.append("orgName", this.orgName).append("sex", this.sex).append("picture", this.picture).append("retype", this.retype).toString();
	}
	
	/**
	 * 返回角色。
	 * @return
	 */
	public String getRoles() {
		String str="";
		Collection<GrantedAuthority> roles= getAuthorities();
		for(GrantedAuthority role:roles){
			if("".equals(str)){
				str=role.getAuthority();
			}
			else{
				str+="," + role.getAuthority();
			}
		}
		return str;
	}
	

	/**
	 * 重写UserDetails 的getAuthorities方法。
	 * 
	 * <pre>
	 * 1.首先从缓存中读取。
	 * 2.判断帐号在缓存中是否存在帐号，若存在直接重缓存中读取。
	 * 3.如果不存在则从数据库中读取并加入缓存。
	 * 
	 * 目前角色支持两种方式。
	 * 1.用户和角色的映射。
	 * 2.部门和角色的映射。
	 * 
	 * 两种角色进行合并构成当前用户的角色。
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public @XmlJavaTypeAdapter(GrantedAuthorityAdapter.class)
	Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> rtnList= new ArrayList<GrantedAuthority>();
		SysRoleService sysRoleService = (SysRoleService) AppUtil.getBean(SysRoleService.class);
		ISysOrg curOrg=ContextUtil.getCurrentOrg();
		Long orgId=curOrg==null?0:curOrg.getOrgId();
		Collection<String> totalRoleCol=  sysRoleService.getRolesByUserIdAndOrgId(userId, orgId);
		if(BeanUtils.isNotEmpty(totalRoleCol)){
			for(String role:totalRoleCol){
				rtnList.add(new GrantedAuthorityImpl(role));
			}
		}
		// 添加超级管理员角色。
		if ("devadmin".equals(this.account)) {
			rtnList.add(SystemConst.ROLE_GRANT_SUPER);
		}
		return rtnList;
	}

	

	@Override
	public String getUsername() {
		return account;
	}

	@Override
	public boolean isAccountNonExpired() {
		if (isExpired.shortValue() == UN_EXPIRED.shortValue()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAccountNonLocked() {
		if (isLock.shortValue() == UN_LOCKED.shortValue()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return status == STATUS_OK ? true : false;

	}

	
}