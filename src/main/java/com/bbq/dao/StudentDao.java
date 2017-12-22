package com.bbq.dao;


import com.bbq.beans.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class StudentDao {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public List<Student> getStudentByName(final  String name) throws Exception{
        System.out.println("from db");
        return sessionTemplate.selectList("com.bbq.dao.mapper.StudentMapper.getByName", name);
    }
    public Student getStudentById(final int id) throws Exception {
        return sessionTemplate.selectOne("com.bbq.dao.mapper.StudentMapper.getById", id);
    }

    public long insertStudent(final Student student) {
        sessionTemplate.insert("com.bbq.dao.mapper.StudentMapper.insertStudent", student);
        return student.getId();
    }

    public int updateStudent(final Student student) {
        return sessionTemplate.update("com.bbq.dao.mapper.StudentMapper.updateStudent", student);
    }

    public int deleteStudent(final long id) {
        return sessionTemplate.delete("com.bbq.dao.mapper.StudentMapper.deleteById", id);
    }
}
