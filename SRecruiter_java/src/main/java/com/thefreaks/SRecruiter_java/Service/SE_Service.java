package com.thefreaks.SRecruiter_java.Service;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.SoftwareEngineering;

public interface SE_Service {
    List<SoftwareEngineering> getAllSEStudents();
    void saveSEStudent(SoftwareEngineering softwareEngineering);
}
