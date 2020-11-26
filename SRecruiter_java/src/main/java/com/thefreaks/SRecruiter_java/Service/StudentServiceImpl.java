package com.thefreaks.SRecruiter_java.Service;

import java.util.List;

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
}
