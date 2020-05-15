package com.example.templateengine.mapper;

import com.example.templateengine.bean.Document;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface DocumentMapper {

    /*
    * 功能：查找所有文档
    * */
    @Select("select * from document")
    public List<Document> getAllDocuments();

    /*
    * 功能：查找文档
    * param：id，文档编号
    * */
    @Select("select * from document where id=#{id}")
    public Document getDocumentById(int id);

    /*
    * 功能：按userName查找文档
    * param: userName
    * */
    @Select("select * from document where userName=#{userName}")
    public List<Document> getDocumentByUserName(String userName);

    /*
    * 功能：按authority查找文档
    * */
    //@Select("select * from document where userName=#{userName}")
    //public List<Document> getDocumentByUserName(String userName);

    /*
    * 功能：删除文档
    * param：id，文档编号
    * */
    @Delete("delete from document where id=#{id}")
    public int deleteDocumentById(int id);

    /*
    * 功能：插入文档
    * param：document，文档对象
    * */
    @Insert("insert into document(id,date,name,t_id,content,userName) values(#{id},#{date},#{name},#{t_id},#{content},#{userName})")
    public int insertDocument(Document document);

    /*
    * 功能：更新文档
    * param：document，文档对象
    * */
    @Update("update document set date=#{date},name=#{name},t_id=#{t_id},content=#{content},userName=#{userName} where id=#{id}")
    public int updateDocument(Document document);

    /*
    * 更新权限
    * */
    @Update("update document set status=#{status} where id=#{id}")
    public int updateDocumentByStatus(int id,String status);

    /*
     * 功能：查找新增id
     * */
    @Select("SELECT id FROM document ORDER BY id DESC LIMIT 0,1")
    public int selectAutoid();
}
