package iuh.fit.se.lab08bai1.controllers;

import iuh.fit.se.lab08bai1.entities.Employee;
import iuh.fit.se.lab08bai1.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping
    public String index(Model model){
        List<Employee> employees=service.findAll();
        model.addAttribute("employees",employees);
        return  "List";
    }
    @GetMapping("/show-form")
    public ModelAndView showForm(ModelAndView modelAndView){
        Employee employee=new Employee();
        modelAndView.setViewName("Form");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee , BindingResult result){
        if(result.hasErrors()){
            return "Form";
        }
        service.save(employee);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam("id") int id, ModelAndView modelAndView){
        Employee employee=service.findById(id);
        modelAndView.setViewName("Form");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        service.delete(id);
        return "redirect:/";
    }
}
