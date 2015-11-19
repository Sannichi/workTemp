package com.nymgo.tests.generators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.nymgo.tests.enums.CURRENCY_SIGNS;

/**
 * Created by Iuliia Khikmatova on Oct 22, 2015
 */
public class CurrencyConversionRateGenerator {

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

   public static String getConversionRate(CURRENCY_SIGNS currencySign){
       return props.getProperty(currencySign.name());
   }
}
