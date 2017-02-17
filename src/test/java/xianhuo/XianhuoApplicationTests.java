package xianhuo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xianhuo.service.LoginServiceImp;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XianhuoApplicationTests {
	@Autowired
	private LoginServiceImp loginServiceImp;

	@Test
	public void contextLoads() throws IOException {
		assertEquals(true, loginServiceImp.Login("1452822", "hjy673773"));
		assertEquals(true, loginServiceImp.Login("1552651", "TJDX4869"));
		assertEquals(false, loginServiceImp.Login("1452822", "jy673773"));
		assertEquals(false, loginServiceImp.Login("145282", "hjy673773"));
	}

//	@Test
//	public void loginTest() throws IOException {
//
//		System.out.println(loginService.Login("1452822", "hjy673773"));
//	}

}
