package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Skills;
import com.example.service.SkillService;

@Controller 
public class SkillController {
	@Autowired
	private SkillService service;
	
//    @GetMapping("/addSkill")
//    public String showAddSkillForm() {
//        // Return the name of the HTML file (addSkillForm.html) without the extension
//        return "addSkillForm";
//    }
	
    
//    @GetMapping("/addSkill")
//    public String showAddSkillForm(Model model) {
//        List<String> domains = service.getAllDomains(); // Assuming you have a method to get all distinct domains
//       model.addAttribute("domains", domains);
//       return "addSkillss";
//}
	
//	
//	@GetMapping("/addSkill")
//    public String showAddSkillForm(Model model) {
//		List<String> allDomains = service.getAllDomains();
//        List<String> allSubdomains = service.getAllSubdomains();
//
//        model.addAttribute("allDomains", allDomains);
//        model.addAttribute("allSubdomains", allSubdomains);
//
//        
//        // Return the name of the HTML file (addSkillForm.html) without the extension
//        return "addSkillForm";
//    }
	
	
	
//	 @GetMapping("/addSkill")
//	    public String showAddSkillForm(Model model) 
//	 {
//	        List<String> allDomains = service.getAllDomains();
//	        List<String> allSubdomains = service.getAllSubdomains();
//	        Map<String, List<String>> allSubdomainsByDomain = service.getAllSubdomainsByDomain(); // Modify this method in your service
//
//	        model.addAttribute("allDomains", allDomains);
//	        model.addAttribute("allSubdomains", allSubdomains);
//	        model.addAttribute("allSubdomainsByDomain", allSubdomainsByDomain);
//	        
//	        return "addSkillss";
//	 }
	 
//	 @GetMapping("/addSkill")
//	 public String showAddSkillForm(Model model) {
//	     List<String> allDomains = service.getAllDomains();
//	     List<String> allSubdomains = service.getAllSubdomains();
//	     Map<String, List<String>> allSubdomainsByDomain = service.getAllSubdomainsByDomain();
//
//	     model.addAttribute("allDomains", allDomains);
//	     model.addAttribute("allSubdomains", allSubdomains);
//	     model.addAttribute("allSubdomainsByDomain", allSubdomainsByDomain);
//
//	     return "addSkillss";
//	 }
	   @GetMapping("/addSkill")
	    public String showAddSkillForm(Model model) {
	        List<String> allDomains = service.getAllDomains();
	        List<String> allSubdomains = service.getAllSubdomains();
	        Map<String, List<String>> allSubdomainsByDomain = service.getAllSubdomainsByDomain(); // Modify this method in your service

	        model.addAttribute("allDomains", allDomains);
	        model.addAttribute("allSubdomains", allSubdomains);
	        model.addAttribute("allSubdomainsByDomain", allSubdomainsByDomain);

	        return "Adminskill";
	    }
   
	@PostMapping("/addSkill")
	public String addSkill(@ModelAttribute Skills skill) {
	    // Assuming you have validation logic or other processing here
	    
	    service.saveSkill(skill);

	    // Redirect to another page or return a response
	    return "success";
	}

	 
//	@PostMapping("/addSkill")
//	public Skills addskill(@RequestParam String domain, @RequestParam String skillName, @RequestParam String subdomain) {
//            Skills skill = new Skills();
//		    skill.setDomain(domain);
//		    skill.setSkillName(skillName);
//		    skill.setSubdomain(subdomain);
//
//		    service.saveSkill(skill);
//		return service.saveSkill(skill);
//
//	}
//	@PostMapping("/addSkill")
//	public String addSkill(@ModelAttribute Skills skill) {
//	    // Assuming you have validation logic or other processing here
//	    
//	    service.saveSkill(skill);
//
//	    // Redirect to another page or return a response
//	    return "success";
//	}
	
	@PostMapping("/addSkills")
	public List<Skills> addskills(@RequestBody List<Skills> skills) {
		return service.saveSkills(skills);
		
	}
//    @GetMapping("/Skills")
//	public List<Skills> findAllskills() {
//		return service.getSkills();
//		
//	}
	
	 @GetMapping("/Skilldashboard")
	    public String skilldashboard() {
	        
	        return "SkillDashboard";
	    }
    @GetMapping("/Skills")
    public String findAllSkills(Model model) {
        List<Skills> skills = service.getSkills();
        model.addAttribute("skills", skills);
        return "skillreport";
    }

//    @GetMapping("/SkillById/{skillid}")
//	public Skills findskillById(@PathVariable int skillid) {
//		return service.getSkillById(skillid);
//	}
//    @GetMapping("/SkillByName/{skillname}")
//   	public Skills findSkillByName(@PathVariable String skillname) {
//  		return service.getSkillByName(skillname);
//  	}
//    
//    @PutMapping("/updateSkill")
//	public Skills updateskill(@RequestBody Skills skill) {
//		return service.updateSkill(skill);
//	}
//    
//    @DeleteMapping("/deleteSkill/{skillid}")
//	public String deleteSkill(@PathVariable int skillid) {
//		return service.deleteSkill(skillid);
//	}
//	

//    private final SkillService skillService;
//
//    // Inject SkillService using constructor injection
//    public SkillController(SkillService skillService) {
//        this.skillService = skillService;
//    }
//     
//
//    // Endpoint to find skill by ID and return an HTML view
//    @GetMapping("/findById/{skillid}")
//    public String findSkillById(@PathVariable int skillid, Model model) {
//        Skills skill = skillService.getSkillById(skillid);
//        model.addAttribute("skill", skill);
//        return "skillDetails"; // Assuming you have a Thymeleaf template named skillDetails.html
//    }
//
//    // Endpoint to find skill by name and return an HTML view
//    @GetMapping("/findByName/{skillname}")
//    public String findSkillByName(@PathVariable String skillname, Model model) {
//        Skills skill = skillService.getSkillByName(skillname);
//        model.addAttribute("skill", skill);
//        return "skillDetails"; // Assuming you have a Thymeleaf template named skillDetails.html
//    }
//
//    // Endpoint to update a skill and return an HTML view
//    @PutMapping("/updateSkill")
//    public String updateSkill(@ModelAttribute Skills skill, Model model) {
//        Skills updatedSkill = skillService.updateSkill(skill);
//        model.addAttribute("skill", updatedSkill);
//        return "skillDetails"; // Assuming you have a Thymeleaf template named skillDetails.html
//    }
//
//    // Endpoint to delete a skill by ID and return an HTML view
//    @DeleteMapping("/deleteSkill/{skillid}")
//    public String deleteSkill(@PathVariable int skillid) {
//        skillService.deleteSkill(skillid);
//        return "redirect:/skills/all"; // Redirect to a page showing all skills
//    }
    
    
    
    
//    @GetMapping("/searchSkills")
//    public String searchSkills(
//    		@RequestParam(required = false) Integer skillid,
//            @RequestParam(required = false) String skillname,
//            @RequestParam(required = false) String domain,
//            @RequestParam(required = false) String subdomain,
//            Model model) {
//
//        List<Skills> skills = service.searchSkills(skillid,skillname, domain, subdomain);
//        model.addAttribute("skills", skills);
//
//        return "Skillsearch"; // Assuming you have a Thymeleaf template named skillDetails.html
//    }

    
    
    @GetMapping("/searchSkills")
    public String showSkills(Model model) {
        List<Skills> allSkills = service.getSkills(); // Replace with your actual method to get all skills
        model.addAttribute("skills", allSkills);
        return "Skillsearch";
    }
    
    
    
    @GetMapping("/skillForm")
    public String showSkillForm(Model model) {
        List<String> allDomains = service.getAllDomains();
        List<String> allSubdomains = service.getAllSubdomains();
        Map<String, List<String>> allSubdomainsByDomain = service.getAllSubdomainsByDomain();

        model.addAttribute("allDomains", allDomains);
        model.addAttribute("allSubdomains", allSubdomains);
        model.addAttribute("allSubdomainsByDomain", allSubdomainsByDomain);

        return "skillForm";
    }

    @PutMapping("/updateDomain")
    public ResponseEntity<String> updateDomain(@RequestParam("domain") String domain, 
                                               @RequestParam("editedDomain") String editedDomain) {
        service.updateDomain(domain, editedDomain);
        return ResponseEntity.ok("Domain updated successfully");
    }

   

    @PutMapping("/updateSubdomain")
    public ResponseEntity<String> updateSubdomain(@RequestParam String domain, @RequestParam String subdomain, @RequestParam String editedSubdomain) {
        service.updateSubdomain(domain, subdomain, editedSubdomain);
        return ResponseEntity.ok("Subdomain updated successfully");
    }

    @PutMapping("/updateSkillname")
    public ResponseEntity<String> updateSkillname(@RequestParam String domain, @RequestParam String subdomain, @RequestParam String skillname, @RequestParam String editedSkillname) {
        service.updateSkillname(domain, subdomain, skillname, editedSkillname);
        return ResponseEntity.ok("Skill name updated successfully");
    }
 
    @GetMapping("/domains")
    public List<String> getAllDomains() {
        return service.getAllDomains();
    }
    
    
    @ResponseBody
    @GetMapping("/subdomains")
    public List<String> getSubdomains(@RequestParam String domain) {
        return service.getSubdomainsByDomain(domain);
    }

    @ResponseBody
    @GetMapping("/skillnames")
    public List<String> getSkillnames(@RequestParam String domain, @RequestParam String subdomain) {
        return service.getSkillnamesByDomainAndSubdomain(domain, subdomain);
    }
    
    
    @GetMapping("/delskills")
    public String getAllSkills(Model model) {
        List<Skills> skills = service.getSkills();
        model.addAttribute("skills", skills);
        return "DeleteSkill"; // Assuming the HTML file is named "skills.html"
    }

    @PostMapping("/delete-skills")
    @ResponseBody
    public void deleteSelectedSkills(@RequestBody List<Integer> skillIds) {
        // Delete selected skills and related employee skills
        service.deleteSelectedSkills(skillIds);
    }

}
