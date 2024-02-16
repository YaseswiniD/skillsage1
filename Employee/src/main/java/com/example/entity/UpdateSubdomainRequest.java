
package com.example.entity;

public class UpdateSubdomainRequest {
	  private String domain;
	    private String subdomain;
	    private String editedSubdomain;
		public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
		public String getSubdomain() {
			return subdomain;
		}
		public void setSubdomain(String subdomain) {
			this.subdomain = subdomain;
		}
		public String getEditedSubdomain() {
			return editedSubdomain;
		}
		public void setEditedSubdomain(String editedSubdomain) {
			this.editedSubdomain = editedSubdomain;
		}
		public UpdateSubdomainRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UpdateSubdomainRequest(String domain, String subdomain, String editedSubdomain) {
			super();
			this.domain = domain;
			this.subdomain = subdomain;
			this.editedSubdomain = editedSubdomain;
		}


}
