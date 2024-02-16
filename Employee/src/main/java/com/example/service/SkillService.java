package com.example.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.EmployeeSkill;
import com.example.entity.Skills;
import com.example.repository.Empskillrepo;
import com.example.repository.Skillrepo;

@Service
public class SkillService {
	@Autowired
	private Skillrepo repository;
	
	public Skills saveSkill(Skills skill) {
		return repository.save(skill);
	}
	public List<Skills> saveSkills(List<Skills> skill) {
		return repository.saveAll(skill);
	}
	public List<Skills> getSkills(){
		return repository.findAll();
	}
	
	public Skills getSkillById(int skillid){
		return repository.findById(skillid).orElse(null);
	}
	public Skills getSkillByName(String skillname){
		return repository.findBySkillname(skillname).orElse(null);
	}
	public Skills getSkillIdByDetails(String domain, String subdomain, String skillName) {
        return repository.findBySkillnameAndDomainAndSubdomain(skillName, domain, subdomain).stream().findFirst().orElse(null);
    }

  
	public String deleteSkill(int skillid)
	{
		repository.deleteById(skillid);
		return "Skill removed!! "+ skillid;
	}
	public Skills updateSkill(Skills skill)
	{
		Skills existingUser=repository.findById(skill.getSkillid()).orElse(null);
		existingUser.setSkillname(skill.getSkillname());
		existingUser.setSubdomain(skill.getSubdomain());
		existingUser.setDomain(skill.getDomain());
		return repository.save(existingUser);
		
		
	}
	


	 public List<Skills> searchSkills(Integer skillid, String skillname, String domain, String subdomain) {
	        // Implement your search logic using the repository
	        return repository.findBySkillidAndSkillnameAndDomainAndSubdomain(skillid, skillname, domain, subdomain);
	    }
	 

	public List<String> getAllDomains() {
		 List<Skills> allSkills = repository.findAll();
	        return allSkills.stream().map(Skills::getDomain).distinct().collect(Collectors.toList());
	}
	
	public List<String> getAllSubdomains() {
        List<Skills> allSkills = repository.findAll();
        return allSkills.stream().map(Skills::getSubdomain).distinct().collect(Collectors.toList());
    }
	
	public List<String> getDistinctDomains() {
        // Implement logic to fetch distinct domains from your database
        return repository.findDistinctDomains(); // Assuming you have a repository method for this
    }

    public List<String> getDistinctSubdomains() {
        // Implement logic to fetch distinct subdomains from your database
        return repository.findDistinctSubdomains(); // Assuming you have a repository method for this
    }



    public Map<String, List<String>> getAllSubdomainsByDomain() {
        List<Skills> allSkills = repository.findAll();

        return allSkills.stream()
                .collect(Collectors.groupingBy(Skills::getDomain,
                        Collectors.mapping(Skills::getSubdomain, Collectors.toList())));
    }


   
 
    public void updateDomain(String domain, String editedDomain) {
        repository.updateDomain(domain, editedDomain);
    }
    
    public List<String> getAllSubdomainsByDomain(String selectedDomain) {
        List<Skills> skillsByDomain = repository.findByDomain(selectedDomain);
        return skillsByDomain.stream()
                .map(Skills::getSubdomain)
                .distinct() // Ensure no duplicate subdomains
                .collect(Collectors.toList());
    }
    public void updateSubdomain(String domain, String subdomain, String editedSubdomain) {
        repository.updateSubdomain(domain, subdomain, editedSubdomain);
    }
  

    public void updateSkillname(String domain, String subdomain, String skillname, String editedSkillname) {
        repository.updateSkillname(domain, subdomain, skillname, editedSkillname);
    }
    public List<String> getAllDistinctDomains() {
        return repository.findAllDistinctDomains();
    }

    public List<String> getSubdomainsByDomain(String domain) {
        return repository.findSubdomainsByDomain(domain);
    }

    public List<String> getSkillnamesByDomainAndSubdomain(String domain, String subdomain) {
        return repository.findSkillnamesByDomainAndSubdomain(domain, subdomain);
    }
    
    @Autowired
    private Empskillrepo empSkillRepo;

    @Transactional
    public void deleteSelectedSkills(List<Integer> skillIds) {
        // Delete selected skills
        repository.deleteBySkillidIn(skillIds);
        
        // Delete related entries in EmployeeSkill table
        for (Integer skillId : skillIds) {
            List<EmployeeSkill> empSkills = empSkillRepo.findById_Skillid(skillId);
            empSkillRepo.deleteAll(empSkills);
        }
    }
}
