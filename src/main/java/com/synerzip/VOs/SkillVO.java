package com.synerzip.VOs;

import javax.persistence.Column;

public class SkillVO {
	
	private long skillId;
	
	private String skillName;

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	

}