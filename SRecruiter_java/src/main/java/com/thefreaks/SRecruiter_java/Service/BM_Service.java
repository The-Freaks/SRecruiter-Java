package com.thefreaks.SRecruiter_java.Service;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.BusinessManagement;

public interface BM_Service {
    List<BusinessManagement> getAllBMStudents();
    void saveBMStudent(BusinessManagement businessManagement);
    BusinessManagement getBMStudentById(long id);
    void deleteBMStudentById(long id);
}
