package xianhuo.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public interface LoginService {
    boolean Login(String id, String password) throws IOException;
}
