package nymgoAutomation.data.adapters;

import nymgoAutomation.data.adapters.BaseAdapter;
import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.navigation.Starter;

public class DataAdapter extends BaseAdapter {

	private static String usersTablePath = Starter.USERS_FILE_PATH;
	private static String creditCardsTablePath = Starter.CREDIT_CARDS_FILE_PATH;
	
    public static Object[][] getInterNormalWhitelistGC() throws Exception{

    	FullUserEntity[] fullUserEntities = {ExcelUtils.getFullUserEntity(usersTablePath,"InterNormalWhitelistGC")};    	
    	Object[][] userEntityArray = new Object[1][];
    	userEntityArray[0] = fullUserEntities;
    	return userEntityArray;
    }

    public static Object[][] getEuroNormalWhitelistGC() throws Exception{
	
//    	ExcelUtils.setExcelFile(usersTablePath,"InterNormalNormallistGC");
//    	FullUserEntity[] fullUserEntities = {new FullUserEntity(ExcelUtils.getUserArray(usersTablePath,"EuroNormalWhitelistGC"))};
    	FullUserEntity[] fullUserEntities = {ExcelUtils.getFullUserEntity(usersTablePath,"EuroNormalWhitelistGC")};    	
    	Object[][] userEntityArray = new Object[1][];
    	userEntityArray[0] = fullUserEntities;
    	return userEntityArray;
  }

    public static FullUserEntity getEuroNormalWhitelist() throws Exception{
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"EuroNormalWhitelist");    	
    	return fullUserEntity;
  }

    public static FullCardEntity getAmericanExpressCard() throws Exception{
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"AmericanExpress");    	
    	return fullCardEntity;
  }
}
