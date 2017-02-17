package xianhuo.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class LoginServiceImp implements LoginService {
    private Map<String, String > cookies = new HashMap<>();
    private Map<String, String> cookies1 = new HashMap<>();
    private Map<String, String> data = new HashMap();
    private static String INDEX = "http://4m3.tongji.edu.cn/eams/login.action";
    private static String CHECK = "http://4m3.tongji.edu.cn/eams/samlCheck";
    private static String LOGIN = "https://ids.tongji.edu.cn:8443/nidp/saml2/sso?id=34&sid=0&option=credential&sid=0";
    private static String RESULT = "https://ids.tongji.edu.cn:8443/nidp/saml2/sso?sid=0&sid=0";

    @Override
    public boolean Login(String id, String password) throws IOException {
        data.put("option", "credential");
        data.put("Ecom_User_ID", id);
        data.put("Ecom_Password", password);
        data.put("submit", "登录");

        // get start cookie
        Connection.Response res = Jsoup.connect(INDEX)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4")
                .header("Host", "4m3.tongji.edu.cn")
                .method(Connection.Method.GET)
                .execute();
        cookies = cookieManager(cookies, res);

        // check your id
        Connection.Response res2 = Jsoup.connect(CHECK)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4")
                .header("Host", "4m3.tongji.edu.cn")
                .cookies(cookies)
                .method(Connection.Method.GET)
                .execute();
        cookies = cookieManager(cookies, res2);

        // login
        Document document = Jsoup.parse(res2.body());
        List<Element> elements =  document.getElementsByTag("meta");
        String url = elements.get(0).attributes().get("content").substring(6);
        Connection.Response res3 = Jsoup.connect(LOGIN)
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4")
                .header("Host", "ids.tongji.edu.cn")
                .cookies(cookies1)
                .header("Referer", url)
                .method(Connection.Method.POST)
                .execute();
        cookies1 = cookieManager(cookies1, res3);

        try{
            Connection.Response res4 = Jsoup.connect(RESULT)
                    .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
                    .cookies(cookies1)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4")
                    .header("Host", "ids.tongji.edu.cn:8443")
                    .header("Origin", "https://ids.tongji.edu.cn:8443")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Referer", LOGIN)
                    .method(Connection.Method.POST)
                    .data(data)
                    .execute();
            if (res4.body().length() < 600){
                return true;
            }else{
                return false;
            }
        }catch (SocketTimeoutException e){
            return false;
        }

    }

    public Map<String, String> cookieManager(Map<String, String> cookies, Connection.Response res){
        for (Map.Entry<String, String> entry : res.cookies().entrySet()){
            cookies.put(entry.getKey(), entry.getValue());
        }

        return cookies;
    }
}
