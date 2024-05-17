package net.codejava.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Department;
import net.codejava.model.Employee;
import net.codejava.service.DepartmentService;
import net.codejava.service.EmployeeService;

@Controller
public class EmployeeController {
	private final EmployeeService Employee_service;
	private final DepartmentService department_service;
	
	public EmployeeController(EmployeeService Employee_service,DepartmentService department_service) {
		this.Employee_service=Employee_service;
		this.department_service=department_service;
	}
	
	@RequestMapping("/viewEmployee")
	public String viewEmployeePage(Model model) {
		List<Employee> listEmployees = Employee_service.listAllEm();
		model.addAttribute("listEmployees",listEmployees);
		
		return "viewEmployee";
	}

	@RequestMapping("/addEmployee")
	public ModelAndView showNewEmployeeForm(Model model) {
		ModelAndView mav = new ModelAndView("addEmployee");
		List<Department> listDepartments = department_service.listAll();
		mav.addObject("listDeparments",listDepartments);
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		
		return mav;
	}
	
	@RequestMapping(value = "/save_employee",method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		Employee_service.save_employee(employee);
		
		return "redirect:/viewEmployee";
	}
	
	@RequestMapping("/edit_employee/{employee_id}")
	public ModelAndView showEditEmployeeForm(@PathVariable(name= "employee_id") Long employee_id) {
		ModelAndView mav = new ModelAndView("editEmployee");
		List<Department> listDepartments = department_service.listAll();
		Employee employee = Employee_service.get_employee(employee_id);
		mav.addObject("employee",employee);
		mav.addObject("listDeparments",listDepartments);
		return mav;
	}
	
	@RequestMapping("/delete_employee/{employee_id}")
	public String deleteEmployee(@PathVariable(name="employee_id") Long employee_id){
		Employee_service.delete_employee(employee_id);
		
		return "redirect:/viewEmployee";
	}
}
