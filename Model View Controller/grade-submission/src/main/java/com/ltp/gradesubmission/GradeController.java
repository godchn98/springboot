package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.FlashMap;
import org.springframework.ui.Model;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("grade", getGradeIndex(name) == -1000 ? new Grade() : studentGrades.get(getGradeIndex(name)));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        int index = getGradeIndex(grade.getName());
        if (index == -1000) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    public Integer getGradeIndex(String name) {
        for(int i =0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getName().equalsIgnoreCase(name)) 
            return i;
        }
        return -1000;
    }

}
