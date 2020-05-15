package com.example.templateengine.mapper;

import com.example.templateengine.bean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
@Repository

public interface CourseMapper {

    /*
    * 功能说明：查找所有课程
    * */
    @Select("select course_name_cn from course")
    public String[] getCourse();

    /*
    * 功能说明：按课程名称查看课程信息
    * */
    @Select("select * from course where course_name_cn =#{courseName}")
    public Course getCourseByName(String courseName);

}
