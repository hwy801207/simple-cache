import com.bbq.beans.Student;
import com.bbq.dao.StudentDao;
import com.bbq.services.StudentService;
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
public class TestStudentService {

    @Autowired
    private StudentService studentService;

    @Test
    public void testGetStudentByName() throws  Exception{
        Student st = studentService.getStudentByName("BigBang");
        Assert.notNull(st);
        Assert.isTrue(st.getName().equals("BigBang"));
//        studentService.reload();
        Student st2 = studentService.getStudentByName("BigBang");
    }


}
