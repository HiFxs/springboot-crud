package com.hifix.springboot04webrestfulcrud.controller;

import com.hifix.springboot04webrestfulcrud.dao.DepartmentDao;
import com.hifix.springboot04webrestfulcrud.dao.EmployeeDao;
import com.hifix.springboot04webrestfulcrud.entities.Department;
import com.hifix.springboot04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class employeecontroller {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
public String list(Model model ){
        Collection<Employee> employees=employeeDao.getAll();
model.addAttribute("emps",employees);
    return "emp/list";
}
@GetMapping("/emp")
public String toAddPage(Model model){
Collection<Department> departments=departmentDao.getDepartments();
model.addAttribute("depts",departments);
return "emp/add";

}


@PostMapping("/emp")
    public String addEmp(Employee employee){
    System.out.println("保存员工信息"+employee);
    employeeDao.save(employee);
        return "redirect:/emps";
}

@GetMapping("/emp/{id}")
public String toeditpage(@PathVariable("id") Integer id,Model model){
Employee employee=employeeDao.get(id);
model.addAttribute("emp",employee);
    Collection<Department> departments=departmentDao.getDepartments();
    model.addAttribute("depts",departments);
return "emp/add";
}
@PutMapping("/emp")
public String updateemp(Employee employee){
    System.out.println("修改的员工数据"+employee);
employeeDao.save(employee);
        return "redirect:/emps";
}
@DeleteMapping("/emp/{id}")
public  String delete(@PathVariable("id") Integer id){
employeeDao.delete(id);
return "redirect:/emps";


}


}
