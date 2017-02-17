package xianhuo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by hongjiayong on 2017/2/17.
 */
public interface QiniuService {
    String getUpToken();
    boolean uploadFile(String filePath);
    void getFileFromClient(MultipartFile mulFile, String fileName) throws IOException;
    boolean storeFile(MultipartFile mulFile);
    void deleteFile(String fileName);
    String getDomain();
    String createDownloadUrl(String url);
}
