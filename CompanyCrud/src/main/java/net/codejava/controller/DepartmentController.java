package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
//hi
import net.codejava.model.Department;
import net.codejava.service.DepartmentService;

@Controller
public class DepartmentController {
	private final DepartmentService department_service;
	
	public DepartmentController(DepartmentService department_service) {
		this.department_service=department_service;
	}
	
	@RequestMapping("/index")
    public String index() {
        return "index";
    }
	
	@RequestMapping("/viewDepartment")
	public String viewDepartMentPage(Model model) {
		List<Department> listDepartments = department_service.listAll();
		model.addAttribute("listDepartments",listDepartments);
		
		return "viewDepartment";
	}

	@RequestMapping("/addDepartment")
	public String showNewDepartmentForm(Model model) {
		Department department = new Department();
		model.addAttribute("department",department);
		
		return "addDepartment";
	}
	
	@RequestMapping(value = "/save_department",method = RequestMethod.POST)
	public String saveDepartment(@ModelAttribute("department") Department department) {
		
		department_service.save_department(department);
		
		return "redirect:/viewDepartment";
	}
	
	@RequestMapping("/edit_department/{department_id}")
	public ModelAndView showEditDepartmentForm(@PathVariable(name= "department_id") Long department_id) {
		ModelAndView mav = new ModelAndView("editDepartment");
		
		Department department = department_service.get_department(department_id);
		mav.addObject("department",department);
		
		return mav;
	}
	
	@RequestMapping("/delete_department/{department_id}")
	public String deleteDepartment(@PathVariable(name="department_id") Long department_id){
		department_service.delete_department(department_id);
		
		return "redirect:/viewDepartment";
	}
}
