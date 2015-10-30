package nymgoAutomation.data.adapters;

import nymgoAutomation.data.adapters.BaseAdapter;
import nymgoAutomation.data.entity.AdminEntity;
import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.starter.Starter;

public class DataAdapter extends BaseAdapter {

	private static String adminTablePath = Starter.ADMIN_FILE_PATH;
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

    public static AdminEntity getAdmin() throws Exception{
    	
    	AdminEntity adminEntity  = ExcelUtils.getAdminEntity(adminTablePath, "Admin");
    	return adminEntity;
	}

    public static FullUserEntity getEuroNormalWhitelist() throws Exception{
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"EuroNormalWhitelist");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getEuroReseller() throws Exception{
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"EuroReseller");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getEuroMasterReseller() throws Exception{
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"EuroMasterReseller");    	
    	return fullUserEntity;
	}

    public static FullCardEntity getAmericanExpressCard() throws Exception{
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"AmericanExpress");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getVisaCard() throws Exception{
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"Visa");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getMasterCardCard() throws Exception{
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"MasterCard");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getVisaAdyenCard() throws Exception{
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"VisaAdyen");    	
    	return fullCardEntity;
	}
}
