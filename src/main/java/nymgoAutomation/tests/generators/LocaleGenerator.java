package nymgoAutomation.tests.generators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import nymgoAutomation.tests.enums.LOCALE_CONST;

import org.apache.log4j.Logger;

public class LocaleGenerator {

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

   public static String getLocaleKey(LOCALE_CONST localeKey){
       return props.getProperty(localeKey.name());
   }

   public static String getLocaleKeyByLocaleName(String localeName){
       return props.getProperty(localeName);
   }

   public static String getLocaleKeyNameByValue(String localeKeyValue){
	  
	   if (props.containsValue(localeKeyValue)){
		   for( String s: props.stringPropertyNames()){
			   if (props.getProperty(s).equals(localeKeyValue))
				   return s;
		   }
	   }
	   LOGGER.fatal("There is no locale property with value " + localeKeyValue);
       return null;
   }
}
