package nymgoAutomation.data.adapters;

import nymgoAutomation.data.adapters.BaseAdapter;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.navigation.Starter;

public class DataAdapter extends BaseAdapter {

	private static String usersTablePath = Starter.USERS_FILE_PATH;
	
    public static Object[][] getInterNormalWhitelistGC() throws Exception{

    	ExcelUtils.setExcelFile(usersTablePath,"InterNormalNormallistGC");
    	FullUserEntity[] fullUserEntities = {new FullUserEntity(ExcelUtils.getUserArray(usersTablePath,"InterNormalWhitelistGC"))};
    	Object[][] userEntityArray = new Object[1][];
    	userEntityArray[0] = fullUserEntities;
    	return userEntityArray;
    }

    public static Object[][] getEuroNormalWhitelistGC() throws Exception{
	
    	ExcelUtils.setExcelFile(usersTablePath,"InterNormalNormallistGC");
    	FullUserEntity[] fullUserEntities = {new FullUserEntity(ExcelUtils.getUserArray(usersTablePath,"EuroNormalWhitelistGC"))};
    	Object[][] userEntityArray = new Object[1][];
    	userEntityArray[0] = fullUserEntities;
    	return userEntityArray;
  }
}
