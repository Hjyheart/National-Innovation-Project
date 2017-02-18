package xianhuo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xianhuo.entity.Activity;
import xianhuo.entity.Club;
import xianhuo.entity.Teacher;
import xianhuo.service.*;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

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

	@Autowired
	private ClubServiceImp clubServiceImp;

	@Autowired
	private ActivityServiceImp activityServiceImp;

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
		assertEquals(false, studentServiceImp.save(studentServiceImp.findByMId("1452822")));
		assertEquals("洪嘉勇",studentServiceImp.findByMName("洪嘉勇").iterator().next().getmName());
		assertEquals("洪嘉勇", studentServiceImp.findByLikeName("洪").iterator().next().getmName());
	}

	@Test
	public void teacherTest(){
		Teacher teacher = new Teacher("hjy673773", "朱宏明", "软件工程", "15900582673", "");
		assertEquals(false, teacherServiceImp.save(teacher));
		assertEquals("朱宏明", teacherServiceImp.findByMName("朱宏明").getmName());
		assertEquals("朱宏明", teacherServiceImp.findByLikeName("朱").iterator().next().getmName());
	}

	@Test
	public void clubTest(){
		Club club = new Club("小王俱乐部", studentServiceImp.findByMId("1452822"), teacherServiceImp.findByMName("朱宏明"));
//		clubServiceImp.save(club);
//		assertEquals("洪嘉勇", clubServiceImp.findByMName("小红俱乐部").getmHostStudent().getmName());
//		assertEquals("朱宏明", clubServiceImp.findByLikeName("小红").iterator().next().getmHostTeacher().getmName());
//		Student stu = studentServiceImp.findByMId("1452822");
//		stu.setmName("王依睿");
//		studentServiceImp.save(stu);
//		assertEquals("王依睿", clubServiceImp.findByMName("小红俱乐部").getmHostStudent().getmName());
	}

	@Test
	public void activityTest(){
		Activity activity = new Activity("编程一小时", "济事楼", Date.from(Instant.now()), 0,"test", clubServiceImp.findByMName("小红俱乐部"));
		Club club = clubServiceImp.findByMName("小红俱乐部");
		club.getmActivities().add(activity);
		clubServiceImp.save(club);
		activityServiceImp.save(activity);
//		assertEquals("编程一小时", club.getmActivities().iterator().next().getmName());
	}

	@Test
	public void clubAndActivityTest(){
		Club club = clubServiceImp.findByMName("小红俱乐部");
		assertEquals("编程一小时", club.getmActivities().iterator().next().getmName());
	}
}
