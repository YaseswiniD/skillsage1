
package com.example.entity;


public class UpdateDomainRequest {
    private String domain;
    private String editedDomain;
	public UpdateDomainRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getEditedDomain() {
		return editedDomain;
	}
	public void setEditedDomain(String editedDomain) {
		this.editedDomain = editedDomain;
	}
	public UpdateDomainRequest(String domain, String editedDomain) {
		super();
		this.domain = domain;
		this.editedDomain = editedDomain;
	}

    // Constructors, getters, and setters
}
