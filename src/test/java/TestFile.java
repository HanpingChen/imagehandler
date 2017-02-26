import com.chen.bean.ImageBean;
import com.chen.common.FileHelper;
import com.chen.common.ImageReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by chen on 17/2/24.
 */
public class TestFile {

    @Test
    public void readAllFiles(){
        String dic = "/Users/chen/Documents/testimage";
        List<File>files = FileHelper.getAllFilesFromDic(dic);
        System.out.println(files.size());

        for (int i=0;i<files.size();i++){
            System.out.println(files.get(i).getAbsolutePath());
        }

    }

    @Test
    public void readImage(){

        String imagePath = "/Users/chen/Documents/testimage/22089b75-3cff-4b2e-b607-1b530f2880e6.jpg";
        ImageReader reader = new ImageReader(imagePath);
        int maxtrix[][] = reader.getResult();
        ImageBean bean = new ImageBean();
        bean.setHeight(reader.getHeight());
        bean.setWidth(reader.getWidth());
        bean.setMatrix(maxtrix);
        bean.setPath(imagePath);


    }
}
