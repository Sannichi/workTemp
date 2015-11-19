package com.nymgo.tests.generators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.nymgo.tests.enums.URL_CONST;

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
