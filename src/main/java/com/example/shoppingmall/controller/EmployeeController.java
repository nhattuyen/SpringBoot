package com.example.shoppingmall.controller;

import com.example.shoppingmall.Entity.AppUser;
import com.example.shoppingmall.Entity.Employee;
import com.example.shoppingmall.Entity.Role;
import com.example.shoppingmall.form.EmployeeForm;
import com.example.shoppingmall.service.IEmployeeService;
import com.example.shoppingmall.service.IRoleService;
import com.example.shoppingmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;

    private static List<Employee> employees = new ArrayList<Employee>();

    @Value("${error.message}")
    private String errorMessage;

    private void defaultData() {
        Role role = new Role();
        role.setRolename("User");
        roleService.addRole(role);
        role.setRolename("Admin");
        roleService.addRole(role);

        AppUser user = new AppUser();
        user.setUsername("SuperUser");
        user.setPassword("12345678");
        user.setIsactive(true);
        userService.addUser(user);

        AppUser user1 = new AppUser();
        user1.setUsername("User1");
        user1.setPassword("11111111");
        user1.setIsactive(true);
        userService.addUser(user1);

        AppUser user2 = new AppUser();
        user1.setUsername("User2");
        user1.setPassword("22222222");
        user1.setIsactive(true);
        userService.addUser(user2);
    }

    @GetMapping(value = "/employee")
    public String index(Model model) {
        defaultData();
        model.addAttribute("employees", employeeService.getAll());
        return "list";
    }

    @RequestMapping(value = {"employee/create"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String add(Model model, @ModelAttribute("employeeForm") EmployeeForm employeeForm) throws ParseException {

        if( employeeForm.getEmpNo() != null && employeeForm.getEmpNo().length() > 0
        && employeeForm.getFullname() != null && employeeForm.getFullname().length() > 0) {
            Employee e = new Employee(employeeForm.getId(), employeeForm.getEmpNo(), employeeForm.getFullname(), employeeForm.getHireDate());

            employeeService.addEmployee(e);
            return "redirect:/employee";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addEmployee";
    }

    @GetMapping("/employee/{id}/update")
    public String update(@PathVariable String id, Model model) {
        Employee e = employeeService.getOneEmployee(id);
        EmployeeForm employee = new EmployeeForm(e.getId(), e.getEmpNo(), e.getFullname(), e.getHireDate());
        model.addAttribute("employeeForm", employee);
        return "editEmployee";
    }

    @PostMapping("/employee/update")
    public String onUpdate(@ModelAttribute("employeeForm") EmployeeForm employeeForm, BindingResult result, Map<String, Object> map) throws ParseException {

        Employee e = employeeService.getOneEmployee(employeeForm.getId());

        if(e != null) {
            employeeService.updateEmployee(new Employee(employeeForm.getId(), employeeForm.getEmpNo(), employeeForm.getFullname(), employeeForm.getHireDate()));
            return "redirect:/employee";
        }

        //model.addAttribute("employee", employeeService.getOneEmployee(id));
        return "editEmployee";
    }

    /*@PostMapping(value = "/employee/save")
    public String save(@ModelAttribute("employee") Employee employee, BindingResult result, RedirectAttributes reditect) {
        if(result.hasErrors()) {
            return "addEmployee";
        }
        employeeService.addEmployee(employee);
        reditect.addFlashAttribute("sucess", "Saved new employee successfully");
        return "redirect:/employee";
    }*/

    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes redirect) {
        Employee e = employeeService.getOneEmployee(id);
        employeeService.deleteEmployee(id);
        redirect.addFlashAttribute("success", "Deleted employee "+ e.getFullname() +" successfully");
        return "redirect:/employee";
    }

    public String search(@RequestParam("name") String name, Model model) {
        if(name.equals("")) {
            return "redirect:/employee";
        }

        model.addAttribute("employees", employeeService.getEmployeeListByName(name));
        return "list";
    }
}
