package com.example.controller;
 
 
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.entity.EmpID;
import com.example.entity.EmployeeSkill;
import com.example.entity.Skills;
import com.example.service.EmpSkillService;
import com.example.service.SkillService;
 
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
 
 
@Controller
public class EmpSkillController {
	@Autowired
	private EmpSkillService service;
	@Autowired
	private SkillService serv;
//	@GetMapping("/addSkillsForm")
//	public String showAddSkillsForm(ModelMap model, Principal principal) {
//	    String empId = principal.getName(); // Get the empId from the authentication context
//	    
//	    // Create a new EmployeeSkill instance with initialized EmpID
//	    EmployeeSkill employeeSkill = new EmployeeSkill();
//	    EmpID empIdObject = new EmpID();
//	    empIdObject.setEmpid(empId);
//	    employeeSkill.setId(empIdObject);
//
//	    model.addAttribute("employeeSkill", employeeSkill);
//	    return "addSkillForm";
//	}
	@GetMapping("/addSkillsForm")
	public String showAddSkillsForm(ModelMap model, Principal principal) {
	    String empId = principal.getName(); // Get the empId from the authentication context
	    // Create a new EmployeeSkill instance with initialized EmpID
	    EmployeeSkill employeeSkill = new EmployeeSkill();
	    EmpID empIdObject = new EmpID();
	    empIdObject.setEmpid(empId);
	    employeeSkill.setId(empIdObject);
 
	    // Fetch skills data from the database and add them to the model
	    List<Skills> skillsList = serv.getSkills();
	    List<String> subdomainsList = skillsList.stream().map(Skills::getSubdomain).distinct().collect(Collectors.toList());
	    List<String> domainsList = skillsList.stream().map(Skills::getDomain).distinct().collect(Collectors.toList());
 
	    model.addAttribute("employeeSkill", employeeSkill);
	    model.addAttribute("skillsList", skillsList);
	    model.addAttribute("subdomainsList", subdomainsList);
	    model.addAttribute("domainsList", domainsList);
 
	    return "addSkillForm";
	}
 
	 
    @PostMapping("/addSkillss")
    public String addSkills(EmployeeSkill employeeSkill) {
        // You might want to validate and process the data here
        service.saveEmpSkill(employeeSkill);
        return "redirect:/user-page"; // Redirect to user page after adding skills
    }
	    @GetMapping("/skilldet")
	    public String showSkillDetails(Model model, Principal principal) {
	        String empId = principal.getName(); // Get the empid from the authentication context
 
	        List<EmployeeSkill> employeeSkills = service.getEmpSkillsByEmpId(empId);
	        model.addAttribute("employeeSkills", employeeSkills);
 
	        return "skillDetails";
	    }
	    @GetMapping("/skilldetails")
	    public String SkillDetails(Model model, Principal principal) {
	        String empId = principal.getName(); // Get the empid from the authentication context
 
	        List<EmployeeSkill> employeeSkills = service.getEmpSkillsByEmpId(empId);
	        model.addAttribute("employeeSkills", employeeSkills);
 
	        return "AEmpSkill";
	    }

	    @GetMapping("/EmpSkillDash")
	    public String Empskilldashboard() {
	        return "EmployeeSkillDash";
	    }
 
	 @GetMapping("/addEmpSkill")
	    public String showAddEmpSkillForm(Model model) {
	        // Return the name of the HTML file (addSkillForm.html) without the extension
		 model.addAttribute("employeeSkill", new EmployeeSkill());
	        return "addEmpSkill";
	    }
	 @PostMapping("/addEmpSkill")
	    public String addSkill(@ModelAttribute("employeeSkill") @Valid EmployeeSkill employeeSkill, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "addSkillForm"; // If validation fails, return to the form with error messages
	        }
 
	        service.saveEmpSkill(employeeSkill);
 
	        return "success"; // Redirect to the skill details page or any other appropriate page
	    }
	 @GetMapping("/skillDetails")
	 public String showSkillDetails(Model model) {

	     List<EmployeeSkill> employeeSkills = service.getEmpSkills();
	     model.addAttribute("employeeSkills", employeeSkills);
	  // get your list of employee skills from the database or service
	     return "AEmpSkill";
	 }
 
	
 
	@PostMapping("/addEmpSkill1")
	public String addEmpskill(@ModelAttribute EmployeeSkill Eskill) {
	 service.saveEmpSkill(Eskill);
	 return "success";
	}
	@PostMapping("/addEmpSkills")
	public List<EmployeeSkill> addEmpskills(@RequestBody List<EmployeeSkill> Eskills) {
		return service.saveEmpSkills(Eskills);
	}
    @GetMapping("/EmpSkills")
	public List<EmployeeSkill> findAllEmpskills() {
		return service.getEmpSkills();
	}
    @GetMapping("/searchEmployeeSkills")
    public String showEmployeeSkills(Model model) {
        List<EmployeeSkill> employeeSkills = service.getEmpSkills();
        model.addAttribute("employeeSkills", employeeSkills);
        return "Empskillsearch";
    }
 
//    
//    @GetMapping("/skilldet")
//    public String showSkillDetails(Model model, Principal principal) {
//        String empId = principal.getName(); // Get the empid from the authentication context
//
//        List<EmployeeSkill> employeeSkills = service.getEmpSkillsByEmpId(empId);
//        model.addAttribute("employeeSkills", employeeSkills);
//
//        return "skillDetails";
//    }
//    
    @GetMapping("/deleteEmpSkills1")
    public String deleteEmployeeSkills(Model model, Principal principal) {
    	  String empId = principal.getName();
    	   List<EmployeeSkill> employeeSkills = service.getEmpSkillsByEmpId(empId);
      //  List<EmployeeSkill> employeeSkills = service.getEmpSkills();
        model.addAttribute("employeeSkills", employeeSkills);
        return "dltempskills";
    }
 
    
    public void EmployeeSkillController(EmpSkillService employeeSkillService) {
        this.service = employeeSkillService;
    }
    @PostMapping("/deleteEmployeeskills")
    public String deleteEmployeeSkills(@RequestParam(name = "empSkillIds", required = false) List<String> empSkillIds) {
        if (empSkillIds != null) {
            for (String empSkillId : empSkillIds) {
                String[] parts = empSkillId.split("-");
                if (parts.length == 2) {
                    String empId = parts[0];
                    Integer skillId = Integer.parseInt(parts[1]);
                    service.deleteEmpSkill(empId, skillId);
                }
            }
        }
        return "redirect:/deleteEmpSkills1";
    }

 
    
//    @GetMapping("/skilldetails")
//    public String SkillDetails(Model model, Principal principal) {
//        String empId = principal.getName(); // Get the empid from the authentication context
//
//        List<EmployeeSkill> employeeSkills = service.getEmpSkillsByEmpId(empId);
//        model.addAttribute("employeeSkills", employeeSkills);
//
//        return "AEmpSkill";
//    }
    @GetMapping("/employeeskills")
    public String getAllEmpSkills(Model model, Principal principal) {
    	String empId = principal.getName(); // Get the empid from the authentication context
    	 List<EmployeeSkill> employeeSkills = service.getEmpSkillsByEmpId(empId);
        model.addAttribute("employeeSkills", employeeSkills);
        return "employeeSkillsList";
    }
 
    @PostMapping("/editEmployeeskill")
    public String editEmployeeSkill(@RequestParam String empid, @RequestParam Integer skillid, Model model) {
        EmployeeSkill employeeSkill = service.getEmpSkillById(empid, skillid);
        model.addAttribute("employeeSkill", employeeSkill);
        return "editEmployeeSkill";
    }
 
    @PostMapping("/saveChanges")
    public String saveChanges(EmployeeSkill employeeSkill) {
        service.saveEmpSkill(employeeSkill);
        return "redirect:/employeeskills";
    }
 
}