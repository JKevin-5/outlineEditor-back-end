package com.example.templateengine.controller;

import com.example.templateengine.bean.Course;
import com.example.templateengine.mapper.CourseMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "课程信息相关接口")
@RestController
public class CourseController {

    @Autowired
    CourseMapper courseMapper;

    //查看有所课程
    @GetMapping("/getCourses")
    public String[] getCourses(){
        return  courseMapper.getCourse();
    }

    //查找课程
    @GetMapping("/getCourse/{courseName}")
    public Course getCourseByName(@PathVariable("courseName") String courseName){
        return courseMapper.getCourseByName(courseName);
    }
}
