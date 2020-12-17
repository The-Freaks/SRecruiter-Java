package com.thefreaks.SRecruiter_java.Service;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.English;

public interface English_Service {
    List<English> getAllEnglishStudents();
    void saveEnglishStudent(English english);
    English getEnglishStudentById(long id);
    void deleteEnglishStudentById(long id);

    int getMaxEnglishStudents();
}
