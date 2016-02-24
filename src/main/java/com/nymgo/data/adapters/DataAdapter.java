package com.nymgo.data.adapters;

import com.nymgo.data.adapters.BaseAdapter;
import com.nymgo.data.entity.AdminEntity;
import com.nymgo.data.entity.FullCardEntity;
import com.nymgo.data.entity.FullUserEntity;
import com.nymgo.data.entity.ThreeDSUserEntity;
import com.nymgo.data.utils.ExcelUtils;
import com.nymgo.tests.starter.Starter;

public class DataAdapter extends BaseAdapter {

	private static String adminTablePath = Starter.ADMIN_FILE_PATH;
	private static String usersTablePath = Starter.USERS_FILE_PATH;
	private static String creditCardsTablePath = Starter.CREDIT_CARDS_FILE_PATH;
	
    public static AdminEntity getAdmin(){
    	
    	AdminEntity adminEntity  = ExcelUtils.getAdminEntity(adminTablePath, "Admin");
    	return adminEntity;
	}

    public static ThreeDSUserEntity getThreeDSUser(){
    	
    	ThreeDSUserEntity threeDSUserEntity = ExcelUtils.getThreeDSUserEntity(creditCardsTablePath, "3DSUser");
    	return threeDSUserEntity;
	}

    public static FullUserEntity getEuroNormalWhitelist(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"EuroNormalWhitelist");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getEuroReseller(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"EuroReseller");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getEuroMasterReseller(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"EuroMasterReseller");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getInterNormalWhitelist(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"InterNormalWhitelist");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getInterReseller(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"InterReseller");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getInterMasterReseller(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"InterMasterReseller");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getRecurrentEuroNormalWhitelist(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"RecurrentEuroNormalWhitelist");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getRecurrentEuroMasterReseller(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"RecurrentEuroMasterReseller");    	
    	return fullUserEntity;
	}

    public static FullCardEntity getAmericanExpressCard(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"AmericanExpress");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getVisaCard(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"Visa");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getMasterCardCard(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"MasterCard");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getMasterCardAdyenCard(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"MasterCardAdyen");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getVisaAdyenCard(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"VisaAdyen");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getAmexAdyenCard(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"AmexAdyen");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getWPAmericanExpressCard3DS(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"WPAMEX3DS");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getWPVisaCard3DS(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"WPVISA3DS");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getWPMasterCardCard3DS(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"WPMC3DS");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getAdyenAmericanExpressCard3DS(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"ADYENAMEX3DS");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getAdyenVisaCard3DS(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"ADYENVISA3DS");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getAdyenMasterCardCard3DS(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"ADYENMC3DS");    	
    	return fullCardEntity;
	}

    public static FullCardEntity getDefaultRecurrentCreditCard(){
    	
    	FullCardEntity fullCardEntity = ExcelUtils.getFullCardEntity(creditCardsTablePath,"DefaultRecurrent");    	
    	return fullCardEntity;
	}

    public static FullUserEntity getSignUpReseller(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"SignUpReseller");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getSignUpNormalUser(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"SignUpNormalUser");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getNymgoEuroNormalUser(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"NymgoEuroNormalUser");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getNymgoEuroReseller(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"NymgoEuroReseller");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getNymgoInterNormalUser(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"NymgoInterNormalUser");    	
    	return fullUserEntity;
	}

    public static FullUserEntity getNymgoInterReseller(){
    	
    	FullUserEntity fullUserEntity = ExcelUtils.getFullUserEntity(usersTablePath,"NymgoInterReseller");    	
    	return fullUserEntity;
	}
}
