package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties setProperties(String path){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(path);
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }


}
