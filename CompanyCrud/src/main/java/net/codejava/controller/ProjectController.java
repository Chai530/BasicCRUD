package net.codejava.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Project;
import net.codejava.service.ProjectService;
@Controller
public class ProjectController {
		private final ProjectService project_service;
		
		public ProjectController(ProjectService project_service) {
			this.project_service=project_service;
		}
		
		@RequestMapping("/viewProject")
		public String viewProjectPage(Model model) {
			List<Project> listProjects = project_service.listAllProject();
			model.addAttribute("listProjects",listProjects);
			
			return "viewProject";
		}

		@RequestMapping("/addProject")
		public String showNewPorjectForm(Model model) {
			Project project = new Project();
			model.addAttribute("project",project);
			
			return "addProject";
		}
		
		@RequestMapping(value = "/save_project",method = RequestMethod.POST)
		public String saveProject(@ModelAttribute("project") Project project) {
			
			project_service.save_project(project);
			
			return "redirect:/viewProject";
		}
		
		@RequestMapping("/edit_project/{project_id}")
		public ModelAndView showEditProjectForm(@PathVariable(name= "project_id") Long project_id) {
			ModelAndView mav = new ModelAndView("editProject");
			
			Project project = project_service.get_project(project_id);
			mav.addObject("project",project);
			
			return mav;
		}
		
		@RequestMapping("/delete_project/{project_id}")
		public String deleteProject(@PathVariable(name="project_id") Long project_id){
			project_service.delete_project(project_id);
			
			return "redirect:/viewProject";
		}
	}
