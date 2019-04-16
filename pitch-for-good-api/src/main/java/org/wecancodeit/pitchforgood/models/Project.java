package org.wecancodeit.pitchforgood.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private Long projectId;
	private String projectName;
	@Lob
	private String projectDescription;
	private String estimatedDuration;
	private LocalDateTime createDate;
	private boolean status;
	@ManyToOne
	private Organization organization;
	@ManyToMany
	private Collection<Skill> skills;
	@ManyToOne
	private Volunteer volunteer;
	

	public Project() {}

	
	public Project(String projectName, String projectDescription, String estimatedDuration, Organization organization) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.estimatedDuration = estimatedDuration;
		this.createDate = LocalDateTime.now();
		this.status = true;
		this.organization = organization;
		this.skills = new ArrayList<Skill>();
		
	}
	
	public String getCreateDate() {
		LocalDateTime postDateTime = createDate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formattedStringDate = postDateTime.format(formatter);
		return formattedStringDate;
	}
	
	public Long getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public String getEstimatedDuration() {
		return estimatedDuration;
	}

	
	public boolean getStatus() {
		return status;
	}

	public Organization getOrganization() {
		return organization;
	}
	public Volunteer getVolunteer() {
		return volunteer;
	}

	public Collection<Skill> getSkills() {
		return skills;
	}
	
	public void addSkillToProject(Skill skill) {
		skills.add(skill);
	}

	public void removeSkill(Skill skill) {
		skills.remove(skill);
		
	}

	public void addOrganizationToProject(Organization organization) {
		this.organization = organization;
		
	}
	
}
