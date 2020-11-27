package com.thefreaks.SRecruiter_java.Service;

import java.util.List;
import java.util.Optional;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;
import com.thefreaks.SRecruiter_java.Model.English;
import com.thefreaks.SRecruiter_java.Model.GraphicDesign;
import com.thefreaks.SRecruiter_java.Model.Infirmary;
import com.thefreaks.SRecruiter_java.Model.SoftwareEngineering;
import com.thefreaks.SRecruiter_java.Repository.BM_Repository;
import com.thefreaks.SRecruiter_java.Repository.English_Repository;
import com.thefreaks.SRecruiter_java.Repository.GD_Repository;
import com.thefreaks.SRecruiter_java.Repository.Infirmary_Repository;
import com.thefreaks.SRecruiter_java.Repository.SE_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements BM_Service, English_Service, GD_Service, Infirmary_Service, SE_Service {

    // Software Engineering
    @Autowired
    private SE_Repository se_repository;
    @Override
    public List<SoftwareEngineering> getAllSEStudents() {
        return se_repository.findAll();
    }
    @Override
    public void saveSEStudent(SoftwareEngineering softwareEngineering) {
        this.se_repository.save(softwareEngineering);
    }
    @Override
    public SoftwareEngineering getSEStudentById(long id) {
        Optional<SoftwareEngineering> optional = se_repository.findById(id);
        SoftwareEngineering softwareEngineering = null;
        if(optional.isPresent()){
            softwareEngineering = optional.get();
        }else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return softwareEngineering;
    }
    @Override
    public void deleteSEStudentById(long id) {
        this.se_repository.deleteById(id);
    }


    // Infirmary
    @Autowired
    private Infirmary_Repository infirmary_repository;
    @Override
    public List<Infirmary> getAllInfirmaryStudents() {
        return infirmary_repository.findAll();
    }
    @Override
    public void saveInfirmaryStudent(Infirmary infirmary) {
        this.infirmary_repository.save(infirmary);
    }
    @Override
    public Infirmary getInfirmaryStudentById(long id) {
        Optional<Infirmary> optional = infirmary_repository.findById(id);
        Infirmary infirmary = null;
        if(optional.isPresent()){
            infirmary = optional.get();
        }else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return infirmary;
    }
    @Override
    public void deleteInfirmaryStudentById(long id) {
        this.infirmary_repository.deleteById(id);
    }


    // Graphic Design
    @Autowired
    private GD_Repository gd_repository;
    @Override
    public List<GraphicDesign> getAllGDStudents() {
        return gd_repository.findAll();
    }
    @Override
    public void saveGDStudent(GraphicDesign graphicDesign) {
        this.gd_repository.save(graphicDesign);
    }
    @Override
    public GraphicDesign getGDStudentById(long id) {
        Optional<GraphicDesign> optional = gd_repository.findById(id);
        GraphicDesign graphicDesign = null;
        if(optional.isPresent()){
            graphicDesign = optional.get();
        }else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return graphicDesign;
    }
    @Override
    public void deleteGDStudentById(long id) {
        this.gd_repository.deleteById(id);
    }


    // English
    @Autowired
    private English_Repository english_repository;
    @Override
    public List<English> getAllEnglishStudents() {
        return english_repository.findAll();
    }
    @Override
    public void saveEnglishStudent(English english) {
        this.english_repository.save(english);
    }
    @Override
    public English getEnglishStudentById(long id) {
        Optional<English> optional = english_repository.findById(id);
        English english = null;
        if(optional.isPresent()){
            english = optional.get();
        }else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return english;
    }
    @Override
    public void deleteEnglishStudentById(long id) {
        this.english_repository.deleteById(id);
    }


    // Business Management
    @Autowired
    private BM_Repository bm_repository;
    @Override
    public List<BusinessManagement> getAllBMStudents() {
        return bm_repository.findAll();
    }
    @Override
    public void saveBMStudent(BusinessManagement businessManagement) {
        this.bm_repository.save(businessManagement);
    }
    @Override
    public BusinessManagement getBMStudentById(long id) {
        Optional<BusinessManagement> optional = bm_repository.findById(id);
        BusinessManagement businessManagement = null;
        if(optional.isPresent()){
            businessManagement = optional.get();
        }else {
            throw new RuntimeException("Student not found for id ::" + id);
        }
        return businessManagement;
    }
    @Override
    public void deleteBMStudentById(long id) {
        this.bm_repository.deleteById(id);
    }
}
