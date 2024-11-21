package com.example.coursemanagement.controller;

import com.example.coursemanagement.dto.request.CourseRequestDTO;
import com.example.coursemanagement.dto.response.CourseResponseDTO;
import com.example.coursemanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    //return html, so it must string return type
    @PostMapping
    public String createCourse(@ModelAttribute CourseRequestDTO courseRequestDTO){
        courseService.createCourse(courseRequestDTO);
        return "redirect:/api/v1/courses"; //redirect to path /api/v1/courses (request method is GET(default))
    }
    @GetMapping
    public String getCourses(Model model){
        List<CourseResponseDTO> courseResponseDTOs= courseService.getAllCourse();
        model.addAttribute("courseResponseDTOs", courseResponseDTOs);
        return "result_page";
    }
}
