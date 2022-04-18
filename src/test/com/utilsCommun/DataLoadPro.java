package utilsCommun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataLoadPro {

    Properties p;
    BufferedReader fileReader;

    public DataLoadPro()
    {
        try {
            fileReader= new BufferedReader(new FileReader("./src/main/resources/data.properties"));
            p= new Properties();
            p.load(fileReader);
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath(String path){
        String driverPath = p.getProperty(path);
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the data.properties file.");
    }
}
