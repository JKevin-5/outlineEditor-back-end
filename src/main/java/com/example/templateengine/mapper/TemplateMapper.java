package com.example.templateengine.mapper;

import com.example.templateengine.bean.Template;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface TemplateMapper {

    /*
     * 查找所有模板
     * */
    @Select("select * from template")
    public List<Template> getAllTemplates();

    /*
    * 查找模板
    * */
    @Select("select * from template where id=#{id}")
    public Template getTemplateById(int id);

    /*
    * 查找最新模板 By date
    * */
    @Select("SELECT * FROM bishe.template where date <=#{date} order by date desc limit 1")
    public Template getLastTemplate(String date);

    /*
     * 删除模板
     * */
    @Delete("delete from template where id=#{id}")
    public int deleteTemplateById(int id);

    /*
     * 新建模板
     * */
    @Insert("insert into template(id,date,remark,content) values(#{id},#{date},#{remark},#{content})")
    public int insertTemplates(Template template);

    /*
    * 更新模板
    * */
    @Update("update template set date=#{date},remark=#{remark},content=#{content} where id=#{id}")
    public int updateTemplate(Template template);

    /*
    * 查找自增字段的下一个id
    * */
    @Select("SELECT id FROM template ORDER BY id DESC LIMIT 0,1")
    public int selectAutoid();
}
