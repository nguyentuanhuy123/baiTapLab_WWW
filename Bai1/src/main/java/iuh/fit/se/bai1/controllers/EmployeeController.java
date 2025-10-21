package iuh.fit.se.bai2.controllers;

import iuh.fit.se.bai1.entities.Employee;
import iuh.fit.se.bai1.repositories.EmployeeRepository;
import iuh.fit.se.bai1.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public String index(Model model){
        List<Employee> employees=employeeService.findAll();
        model.addAttribute("employees",employees);
        return "List";
    }
    @GetMapping("/show-form")
    public ModelAndView showForm(ModelAndView modelAndView){
        Employee employee=new Employee();
        modelAndView.setViewName("Form");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return "Form";
        }

        employeeService.save(employee);

        return "redirect:/";
    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam("id") int id, ModelAndView modelAndView){
        Employee employee = employeeService.findById(id);
        modelAndView.setViewName("Form");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        employeeService.deleteById(id);
        return "redirect:/";
    }

}
