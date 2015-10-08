package nymgoAutomation.data.providers;

import nymgoAutomation.data.adapters.DataAdapter;
import nymgoAutomation.data.enums.PROVIDER_CONST;

import org.testng.annotations.DataProvider;

public class GeneralDataProvider extends BaseDataProvider{



    @DataProvider(name=PROVIDER_CONST.INTER_NORMAL_WHITELIST_GC_PROVIDER)
    public static Object[][] interNormalWhitelistedGCDataProvider() {

        return DataAdapter.getInterNormalWhitelistGC();
    }

}
