package xianhuo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xianhuo.entity.Teacher;
import xianhuo.service.LoginServiceImp;
import xianhuo.service.StudentServiceImp;
import xianhuo.service.TeacherServiceImp;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XianhuoApplicationTests {
	@Autowired
	private LoginServiceImp loginServiceImp;

	@Autowired
	private StudentServiceImp studentServiceImp;

	@Autowired
	private TeacherServiceImp teacherServiceImp;

	@Test
	public void contextLoads() throws IOException {

	}

	@Test
	public void loginTest() throws IOException {
		assertEquals(true, loginServiceImp.Login("1452822", "hjy673773"));
		assertEquals(true, loginServiceImp.Login("1552651", "TJDX4869"));
		assertEquals(false, loginServiceImp.Login("1452822", "jy673773"));
		assertEquals(false, loginServiceImp.Login("145282", "hjy673773"));
	}

	@Test
	public void studentTest(){
		assertEquals("洪嘉勇",studentServiceImp.findByMName("洪嘉勇").iterator().next().getmName());
		assertEquals("洪嘉勇", studentServiceImp.findByLikeName("洪").iterator().next().getmName());
	}

	@Test
	public void teacherTest(){
		Teacher teacher = new Teacher("hjy673773", "朱宏明", "软件工程", "15900582673", "");
		teacherServiceImp.save(teacher);
		assertEquals("朱宏明", teacherServiceImp.findByMName("朱宏明").getmName());
		assertEquals("朱宏明", teacherServiceImp.findByLikeName("朱").iterator().next().getmName());
	}
}
