package com.synerzip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {
	
	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long skillId;
	
	@Column(nullable = false)
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
