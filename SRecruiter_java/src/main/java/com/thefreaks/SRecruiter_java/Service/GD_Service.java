package com.thefreaks.SRecruiter_java.Service;


import com.thefreaks.SRecruiter_java.Model.GraphicDesign;

import org.springframework.data.domain.Page;

public interface GD_Service {
    void saveGDStudent(GraphicDesign graphicDesign);
    GraphicDesign getGDStudentById(long id);
    void deleteGDStudentById(long id);
    
    Page<GraphicDesign> findPaginatedGDPage(int pageNumGD, int pageSizeGD);
}
