package xianhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xianhuo.entity.File;
import xianhuo.repository.FileRep;

/**
 * Created by hongjiayong on 2017/2/17.
 */
@Service
public class FileServiceImp implements FileService{
    @Autowired
    private FileRep fileRep;

    @Override
    public void save(File file) {
        fileRep.save(file);
    }
}
