package com.example.coursemanagement.service.impl;

import com.example.coursemanagement.dto.request.CourseRequestDTO;
import com.example.coursemanagement.dto.response.CourseResponseDTO;
import com.example.coursemanagement.model.Course;
import com.example.coursemanagement.repository.CourseRepository;
import com.example.coursemanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Optional<CourseResponseDTO> createCourse(CourseRequestDTO courseRequestDTO) {
        Course course= new Course(courseRequestDTO.courseName(), courseRequestDTO.courseCode(), courseRequestDTO.courseDescription());
        Course createdCourse=courseRepository.save(course);
        CourseResponseDTO courseResponseDTO= new CourseResponseDTO(createdCourse.getCourseName(), createdCourse.getCourseCode());
        return Optional.of(courseResponseDTO);
    }

    @Override
    public List<CourseResponseDTO> getAllCourse() {
        List<Course> courses= courseRepository.findAll();
        List<CourseResponseDTO> courseResponseDTOS= new ArrayList<>();
        for(Course course: courses){
            CourseResponseDTO courseResponseDTO= new CourseResponseDTO(course.getCourseName(), course.getCourseCode());
            courseResponseDTOS.add(courseResponseDTO);
        }
        return courseResponseDTOS;
    }
}
