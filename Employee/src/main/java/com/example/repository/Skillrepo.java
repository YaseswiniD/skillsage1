package com.example.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Skills;


public interface Skillrepo extends JpaRepository<Skills, Integer>{
	
	Optional<Skills> findBySkillname(String skillname);
	
	
	List<Skills> findBySkillnameContaining(String searchName);


	List<Skills> findBySkillidAndSkillnameAndDomainAndSubdomain(Integer skillid, String skillname, String domain,
			String subdomain);

	
	List<Skills> findBySkillnameAndDomainAndSubdomain(String skillname, String domain, String subdomain);
	
	@Query("SELECT DISTINCT s.domain FROM Skills s")
    List<String> findDistinctDomains();

    @Query("SELECT DISTINCT s.subdomain FROM Skills s")
    List<String> findDistinctSubdomains();
    
    @Transactional
    @Modifying
    @Query("UPDATE Skills s SET s.domain = :editedDomain WHERE s.domain = :domain")
    void updateDomain(String domain, String editedDomain);

   
    
    
    @Transactional
    @Modifying
    @Query("UPDATE Skills s SET s.skillname = :editedSkillname WHERE s.domain = :domain AND s.subdomain = :subdomain AND s.skillname = :skillname")
    void updateSkillname(String domain, String subdomain, String skillname, String editedSkillname);
	List<String> getAllSubdomainsByDomain(String selectedDomain);

	

    @Transactional
    @Modifying
    @Query("UPDATE Skills s SET s.subdomain = :editedSubdomain WHERE s.domain = :domain AND s.subdomain = :subdomain")
    void updateSubdomain(String domain, String subdomain, String editedSubdomain);

    

    @Query("SELECT DISTINCT s.domain FROM Skills s")
    List<String> findAllDistinctDomains();

    @Query("SELECT DISTINCT s.subdomain FROM Skills s WHERE s.domain = :domain")
    List<String> findDistinctSubdomainsByDomain(String domain);

    List<Skills> findByDomain(String domain);
    
    @Query("SELECT DISTINCT s.domain FROM Skills s")
    List<String> findAllDomains();

    @Query("SELECT DISTINCT s.subdomain FROM Skills s WHERE s.domain = ?1")
    List<String> findSubdomainsByDomain(String domain);

    
    
    @Query("SELECT DISTINCT s.skillname FROM Skills s WHERE s.domain = ?1 AND s.subdomain = ?2")
    List<String> findSkillnamesByDomainAndSubdomain(String domain, String subdomain);

    void deleteBySkillidIn(List<Integer> skillIds);
    
}
