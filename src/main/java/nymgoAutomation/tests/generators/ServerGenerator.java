package nymgoAutomation.tests.generators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import nymgoAutomation.tests.enums.URL_CONST;

import org.apache.log4j.Logger;

public class ServerGenerator {

    protected static Properties props;
    static Logger LOGGER = Logger.getLogger("nymgoLogger");

   public static void setProps(String fileName) {
       props = new Properties();
       try {
           props.load(new FileInputStream(fileName));
       } catch (IOException e) {
           LOGGER.fatal("There was a problem to load the config file from " + fileName);
           e.printStackTrace();
       }

   }

   public static String getServerKey(URL_CONST urlKey){
       return props.getProperty(urlKey.name());
   }

}
