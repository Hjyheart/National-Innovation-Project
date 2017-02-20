package xianhuo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xianhuo.entity.Activity;
import xianhuo.entity.Club;
import xianhuo.entity.Student;
import xianhuo.entity.Teacher;
import xianhuo.service.*;

import javax.transaction.Transactional;
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

	@Autowired
	private MailServiceIml mailServiceIml;

	@Test
	public void contextLoads() throws IOException {

	}

	@Test
	public void loginTest() throws IOException {
		assertEquals(true, loginServiceImp.login("1452822", "hjy673773"));
		assertEquals(true, loginServiceImp.login("1552651", "TJDX4869"));
		assertEquals(false, loginServiceImp.login("1452822", "jy673773"));
		assertEquals(false, loginServiceImp.login("145282", "hjy673773"));
	}

	@Test
	@Transactional
	public void studentTest(){
		Student stu = studentServiceImp.findByMId("1452822");
		stu.setmName("洪嘉勇");
		studentServiceImp.save(stu);
		assertEquals("洪嘉勇", studentServiceImp.findByMId("1452822").getmName());
	}

	@Test
	public void teacherTest(){
		Teacher teacher = new Teacher("hjy673773", "朱宏明", "软件工程", "15900582673");
		assertEquals(false, teacherServiceImp.save(teacher));
		assertEquals("朱宏明", teacherServiceImp.findByMName("朱宏明").getmName());
		assertEquals("朱宏明", teacherServiceImp.findByLikeName("朱").iterator().next().getmName());
	}

	@Test
	public void clubTest(){
//		Club club = new Club("小王俱乐部", studentServiceImp.findByMId("1452822"), teacherServiceImp.findByMName("朱宏明"));
//		clubServiceImp.save(club);
//		assertEquals("洪嘉勇", clubServiceImp.findByMName("小红俱乐部").getmHostStudent().getmName());
//		assertEquals("朱宏明", clubServiceImp.findByLikeName("小红").iterator().next().getmHostTeacher().getmName());
//		Student stu = studentServiceImp.findByMId("1452822");
//		stu.setmName("王依睿");
//		studentServiceImp.save(stu);
//		assertEquals("王依睿", clubServiceImp.findByMName("小红俱乐部").getmHostStudent().getmName());
	}

	@Test
	public void clubCreateTest(){
		assertEquals("奇迹", studentServiceImp.findByMId("1452822").getmHostClubs().iterator().next().getmName());
	}

	@Test
	public void clubDeleteTest(){
		Club club = clubServiceImp.findByMName("奇迹");
		clubServiceImp.delete(club);
		assertEquals(null, clubServiceImp.findByMName("奇迹"));
	}

	@Test
	public void clubAddStuTest(){
		assertEquals("奇迹", studentServiceImp.findByMId("1552651").getmInClubs().iterator().next().getmName());
		assertEquals("王依睿", clubServiceImp.findByMName("奇迹").getmStudents().iterator().next().getmName());
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
	public void activityCreateTest(){
		Club club = clubServiceImp.findByMName("奇迹");
		assertEquals(0, club.getmActivities().size());

	}

	@Test
	public void clubAndActivityTest(){
		Club club = clubServiceImp.findByMName("小红俱乐部");
		assertEquals("编程一小时", club.getmActivities().iterator().next().getmName());
	}

	@Test
	public void mailActivityTest(){
		assertEquals("1452822", studentServiceImp.findByMId("1452822").getmSends().iterator().next().getmSender());
		assertEquals("1452822", teacherServiceImp.findByMName("朱宏明").getmMail().iterator().next().getmSender());
	}
}
