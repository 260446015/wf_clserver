package com.zkjl.wf_clserver.core.entity;

public class ResourceBean {

	private String id;
	private String username;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof String) {
			return this.id.equals(obj.toString());
		}
		if (obj != null && obj instanceof ResourceBean) {
			return this.id.equals(((ResourceBean)obj).getId());
		}
		return super.equals(obj);
	}

}
