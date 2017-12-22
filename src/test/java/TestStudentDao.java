import com.bbq.beans.Student;
import com.bbq.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.sql.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TestStudentDao {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testGetStudentById() throws  Exception{
        Student st = studentDao.getStudentById(1);
        Assert.notNull(st);
    }

    @Test
    public void testGetStudentByName() throws  Exception{
        List<Student> st = studentDao.getStudentByName("朱浩");
        Assert.notNull(st);
        Assert.isTrue(st.size() == 1);
    }

    @Test
    public void testInsertStudent() throws Exception {
        Student st = new Student();
        st.setCreateAt(System.currentTimeMillis());
        st.setUpdateAt(System.currentTimeMillis());
        st.setQQ("123456");
        st.setName("BigBang");
        st.setBrotherName("Big Brother");
        st.setIdOnSite("everyOneKonw me");
        st.setSchool("MIT");
        st.setCareerType(2);
        st.setEntryDate(new Date(System.currentTimeMillis()));
        st.setDailyReportUrl("http://id/report");
        long ret = studentDao.insertStudent(st);
        System.out.println(ret);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Student st = studentDao.getStudentByName("BigBang").get(0);
        studentDao.deleteStudent(st.getId());
    }

}
