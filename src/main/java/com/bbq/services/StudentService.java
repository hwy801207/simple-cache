package com.bbq.services;


import com.bbq.beans.Student;
import com.bbq.cache.CacheManager;
import com.bbq.dao.StudentDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    private CacheManager<Student> cacheManager;

    public StudentService() {
       cacheManager = new CacheManager<Student>();
    }

    // 缓存逻辑与业务代码耦合高
    public Student getStudentByName(String name)  throws Exception{
        Student student = cacheManager.getValue(name);
        if (student == null) {
            List<Student> sts = studentDao.getStudentByName(name);
            student = sts.get(0);
            cacheManager.addOrUpdateCache(name, student);
        }
        return student;
    }

    public long insertStudent(final Student student) {
        return studentDao.insertStudent(student);
    }

    public boolean updateStudent(final Student student) {
        return 1 == studentDao.updateStudent(student);
    }

    public void reload() {
        cacheManager.clearCache();
    }

}
