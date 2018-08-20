package com.synerzip.auth.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="application_users")
public class ApplicationUser {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long userId;
	    private String username;
	    private String password;
	    private Boolean enabled=true;

		@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
		private List<LinkUserRole> linkUserRoles;

	    public long getUserId() {
			return userId;
		}
		
		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}

		public List<LinkUserRole> getLinkUserRoles() {
			return linkUserRoles;
		}

		public void setLinkUserRoles(List<LinkUserRole> linkUserRoles) {
			this.linkUserRoles = linkUserRoles;
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
	    }}
