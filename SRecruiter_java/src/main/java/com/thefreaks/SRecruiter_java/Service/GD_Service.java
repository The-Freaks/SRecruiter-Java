package com.thefreaks.SRecruiter_java.Service;

import java.util.List;

import com.thefreaks.SRecruiter_java.Model.GraphicDesign;

import org.springframework.data.domain.Page;

public interface GD_Service {
    List<GraphicDesign> getAllGDStudents();
    void saveGDStudent(GraphicDesign graphicDesign);
    GraphicDesign getGDStudentById(long id);
    void deleteGDStudentById(long id);
    
    Page<GraphicDesign> findPaginatedGDPage(int pageNumGD, int pageSizeGD);
}
