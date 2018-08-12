package com.it.demo.demo.vo;

public class TokenVO {
	
	private String id;
	
	private String accessSecret;
	
	private String authorizingUserId;
	
	private String projectId;
	
	private String roleIds;
	
	private String comsumerId;
	
	private String expiresAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccessSecret() {
		return accessSecret;
	}

	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}

	public String getAuthorizingUserId() {
		return authorizingUserId;
	}

	public void setAuthorizingUserId(String authorizingUserId) {
		this.authorizingUserId = authorizingUserId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getComsumerId() {
		return comsumerId;
	}

	public void setComsumerId(String comsumerId) {
		this.comsumerId = comsumerId;
	}

	public String getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(String expiresAt) {
		this.expiresAt = expiresAt;
	}
	
	
	
}
