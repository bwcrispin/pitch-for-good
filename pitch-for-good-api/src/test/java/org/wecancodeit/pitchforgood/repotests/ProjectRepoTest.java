package org.wecancodeit.pitchforgood.repotests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.pitchforgood.models.Organization;
import org.wecancodeit.pitchforgood.models.Project;
import org.wecancodeit.pitchforgood.repositories.OrganizationRepository;
import org.wecancodeit.pitchforgood.repositories.ProjectRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ProjectRepoTest {
	
	@Resource
	private TestEntityManager entityManager;
	@Resource
	private ProjectRepository projectRepo;
	@Resource 
	private OrganizationRepository orgRepo;
	
	@Test
	public void shouldFindProjectByName() {
		Organization organization = orgRepo.save(new Organization("","","","","","", null, null));
		Project project = projectRepo.save(new Project("building stuff", "building stuff", "", organization));
		Long projectId = project.getProjectId();
		
		entityManager.persist(project);
		entityManager.flush();
		entityManager.clear();
		
		Optional<Project> projectToFind = projectRepo.findById(projectId);
		Project projectFromDatabase = projectRepo.findByProjectName("building stuff");
		assertThat(projectFromDatabase.getProjectName(), is("building stuff"));
		
	}
}
