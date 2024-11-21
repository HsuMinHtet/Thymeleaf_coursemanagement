package com.example.coursemanagement.service;

import com.example.coursemanagement.dto.request.CourseRequestDTO;
import com.example.coursemanagement.dto.response.CourseResponseDTO;
import com.example.coursemanagement.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<CourseResponseDTO> createCourse(CourseRequestDTO courseRequestDTO);
    List<CourseResponseDTO> getAllCourse();

}
