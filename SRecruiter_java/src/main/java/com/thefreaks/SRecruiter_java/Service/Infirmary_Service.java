package com.thefreaks.SRecruiter_java.Service;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.Infirmary;

public interface Infirmary_Service {
    List<Infirmary> getAllInfirmaryStudents();
    void saveInfirmaryStudent(Infirmary infirmary);
    Infirmary getInfirmaryStudentById(long id);
    void deleteInfirmaryStudentById(long id);
}
