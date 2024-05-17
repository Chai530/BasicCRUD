package net.codejava.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Project;
import net.codejava.repository.ProjectRepo;
@Service
public class ProjectService {
		@Autowired
		private ProjectRepo project_repo;
		
		//project
			public List<Project> listAllProject(){
				return project_repo.findAll();
			}
			
			public void save_project(Project project) {
				project_repo.save(project);
			}
			
			public Project get_project(Long project_id) {
				return project_repo.findById(project_id).get();
			}
			
			public void delete_project(Long project_id) {
				project_repo.deleteById(project_id);
			}
	
}
