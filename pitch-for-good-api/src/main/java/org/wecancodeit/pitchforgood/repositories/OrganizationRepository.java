package org.wecancodeit.pitchforgood.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.pitchforgood.models.Organization;
import org.wecancodeit.pitchforgood.models.Project;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>{

	Organization findByOrgName(String string);

	Organization findByOrgUserName(String username);

}
