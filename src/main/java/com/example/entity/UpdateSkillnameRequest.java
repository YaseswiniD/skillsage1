
package com.example.entity;

public class UpdateSkillnameRequest {
	private String domain;
    private String subdomain;
    private String skillname;
    private String editedSkillname;
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSubdomain() {
		return subdomain;
	}
	public UpdateSkillnameRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateSkillnameRequest(String domain, String subdomain, String skillname, String editedSkillname) {
		super();
		this.domain = domain;
		this.subdomain = subdomain;
		this.skillname = skillname;
		this.editedSkillname = editedSkillname;
	}
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public String getEditedSkillname() {
		return editedSkillname;
	}
	public void setEditedSkillname(String editedSkillname) {
		this.editedSkillname = editedSkillname;
	}

}
