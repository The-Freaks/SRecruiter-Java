package com.thefreaks.SRecruiter_java.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collection;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;
import com.thefreaks.SRecruiter_java.Model.English;
import com.thefreaks.SRecruiter_java.Model.GraphicDesign;
import com.thefreaks.SRecruiter_java.Model.Infirmary;
import com.thefreaks.SRecruiter_java.Model.Role;
import com.thefreaks.SRecruiter_java.Model.SoftwareEngineering;
import com.thefreaks.SRecruiter_java.Model.User;
import com.thefreaks.SRecruiter_java.Repository.BM_Repository;
import com.thefreaks.SRecruiter_java.Repository.English_Repository;
import com.thefreaks.SRecruiter_java.Repository.GD_Repository;
import com.thefreaks.SRecruiter_java.Repository.Infirmary_Repository;
import com.thefreaks.SRecruiter_java.Repository.SE_Repository;
import com.thefreaks.SRecruiter_java.Repository.UserRepository;
import com.thefreaks.SRecruiter_java.Service.web.web_dto.UserRegistrationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl
        implements BM_Service, English_Service, GD_Service, Infirmary_Service, SE_Service, UserService {

    // Software Engineering
    @Autowired
    private SE_Repository se_repository;

    @Override
    public Page<SoftwareEngineering> findPaginatedSEPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return this.se_repository.findAll(pageable);
    }

    @Override
    public void saveSEStudent(SoftwareEngineering softwareEngineering) {
        this.se_repository.save(softwareEngineering);
    }

    @Override
    public SoftwareEngineering getSEStudentById(long id) {
        Optional<SoftwareEngineering> optional = se_repository.findById(id);
        SoftwareEngineering softwareEngineering = null;
        if (optional.isPresent()) {
            softwareEngineering = optional.get();
        } else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return softwareEngineering;
    }

    @Override
    public void deleteSEStudentById(long id) {
        this.se_repository.deleteById(id);
    }

    // -------------------------------------------------------
    // Infirmary
    @Autowired
    private Infirmary_Repository infirmary_repository;

    @Override
    public Page<Infirmary> findPaginatedInfirmaryPage(int pageNumInfirmary, int pageSizeInfirmary) {
        Pageable pageable = PageRequest.of(pageNumInfirmary - 1, pageSizeInfirmary);
        return this.infirmary_repository.findAll(pageable);
    }

    @Override
    public void saveInfirmaryStudent(Infirmary infirmary) {
        this.infirmary_repository.save(infirmary);
    }

    @Override
    public Infirmary getInfirmaryStudentById(long id) {
        Optional<Infirmary> optional = infirmary_repository.findById(id);
        Infirmary infirmary = null;
        if (optional.isPresent()) {
            infirmary = optional.get();
        } else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return infirmary;
    }

    @Override
    public void deleteInfirmaryStudentById(long id) {
        this.infirmary_repository.deleteById(id);
    }

    // -------------------------------------------------------
    // Graphic Design
    @Autowired
    private GD_Repository gd_repository;

    @Override
    public Page<GraphicDesign> findPaginatedGDPage(int pageNumGD, int pageSizeGD) {
        Pageable pageable = PageRequest.of(pageNumGD - 1, pageSizeGD);
        return this.gd_repository.findAll(pageable);
    }

    @Override
    public void saveGDStudent(GraphicDesign graphicDesign) {
        this.gd_repository.save(graphicDesign);
    }

    @Override
    public GraphicDesign getGDStudentById(long id) {
        Optional<GraphicDesign> optional = gd_repository.findById(id);
        GraphicDesign graphicDesign = null;
        if (optional.isPresent()) {
            graphicDesign = optional.get();
        } else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return graphicDesign;
    }

    @Override
    public void deleteGDStudentById(long id) {
        this.gd_repository.deleteById(id);
    }

    // -------------------------------------------------------
    // English
    @Autowired
    private English_Repository english_repository;

    @Override
    public Page<English> findPaginatedEnglishPage(int pageNumEnglish, int pageSizeEnglish) {
        Pageable pageable = PageRequest.of(pageNumEnglish - 1, pageSizeEnglish);
        return this.english_repository.findAll(pageable);
    }

    @Override
    public void saveEnglishStudent(English english) {
        this.english_repository.save(english);
    }

    @Override
    public English getEnglishStudentById(long id) {
        Optional<English> optional = english_repository.findById(id);
        English english = null;
        if (optional.isPresent()) {
            english = optional.get();
        } else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return english;
    }

    @Override
    public void deleteEnglishStudentById(long id) {
        this.english_repository.deleteById(id);
    }

    // -------------------------------------------------------
    // Business Management
    @Autowired
    private BM_Repository bm_repository;

    @Override
    public Page<BusinessManagement> findPaginatedBMPage(int pageNumBM, int pageSizeBM) {
        Pageable pageable = PageRequest.of(pageNumBM - 1, pageSizeBM);
        return this.bm_repository.findAll(pageable);
    }

    @Override
    public void saveBMStudent(BusinessManagement businessManagement) {
        this.bm_repository.save(businessManagement);
    }

    @Override
    public BusinessManagement getBMStudentById(long id) {
        Optional<BusinessManagement> optional = bm_repository.findById(id);
        BusinessManagement businessManagement = null;
        if (optional.isPresent()) {
            businessManagement = optional.get();
        } else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return businessManagement;
    }

    @Override
    public void deleteBMStudentById(long id) {
        this.bm_repository.deleteById(id);
    }

    // -------------------------------------------------------
    // User
    @Autowired
    private UserRepository user_repository;

    @Override
    public Page<User> findPaginatedUserPage(int pageNumUser, int pageSizeUser) {
        Pageable pageable = PageRequest.of(pageNumUser - 1, pageSizeUser);
        return this.user_repository.findAll(pageable);
    }

    // -------------------------------------------------------
    // User registration
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public StudentServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), passwordEncoder.encode(userRegistrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_ADMIN")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password!");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
