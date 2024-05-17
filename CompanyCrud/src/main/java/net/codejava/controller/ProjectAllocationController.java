package net.codejava.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Employee;
import net.codejava.model.Project;
import net.codejava.model.ProjectAllocation;
import net.codejava.service.EmployeeService;
import net.codejava.service.ProjectAllocationService;
import net.codejava.service.ProjectService;

@Controller
public class ProjectAllocationController {
		private final ProjectAllocationService projectAllocation_service;
		private final EmployeeService Employee_service;
		private final ProjectService project_service;
		
		public ProjectAllocationController(ProjectAllocationService projectAllocation_service,EmployeeService Employee_service,ProjectService project_service) {
			this.projectAllocation_service=projectAllocation_service;
			this.Employee_service=Employee_service;
			this.project_service=project_service;
		}
		
		@RequestMapping("/viewProjectAllocation")
		public String viewProjectAllocationPage(Model model) {
			List<ProjectAllocation> listProjectAllocation = projectAllocation_service.listAllPA();
			model.addAttribute("listProjectAllocation",listProjectAllocation);
			
			return "viewProjectAllocation";
		}
		
		@RequestMapping("/addProjectAllocation")
		public ModelAndView showNewPAForm(Model model) {
			ModelAndView mav = new ModelAndView("addProjectAllocation");
			List<Employee> listEmployees = Employee_service.listAllEm();
			mav.addObject("listEmployees",listEmployees);
			List<Project> listProjects = project_service.listAllProject();
			mav.addObject("listProjects",listProjects);
			
			ProjectAllocation projectallocation = new ProjectAllocation();
			model.addAttribute("projectallocation",projectallocation);
			
			return mav;
		}
		
		@RequestMapping(value = "/save_projectallocation",method = RequestMethod.POST)
		public String saveProjectAllocation(@ModelAttribute("projectallocation") ProjectAllocation projectallocation) {
			projectAllocation_service.save_projectallocation(projectallocation);
			
			return "redirect:/viewProjectAllocation";
		}
		
		@RequestMapping("/edit_projectallocation/{project_allocation_id}")
		public ModelAndView showEditProjectForm(@PathVariable(name= "project_allocation_id") Long project_allocation_id) {
			ModelAndView mav = new ModelAndView("editProjectAllocation");
			List<Employee> listEmployees = Employee_service.listAllEm();
			mav.addObject("listEmployees",listEmployees);
			List<Project> listProjects = project_service.listAllProject();
			mav.addObject("listProjects",listProjects);
			
			ProjectAllocation projectallocation = projectAllocation_service.get_projectallocation(project_allocation_id);
			mav.addObject("projectallocation",projectallocation);
			return mav;
		}
		
		@RequestMapping("/delete_projectallocation/{ProjectAllocation_id}")
		public String deleteProjectAllocation(@PathVariable(name="ProjectAllocation_id") Long ProjectAllocation_id){
			projectAllocation_service.delete_projectallocation(ProjectAllocation_id);
			
			return "redirect:/viewProjectAllocation";
		}
	}

