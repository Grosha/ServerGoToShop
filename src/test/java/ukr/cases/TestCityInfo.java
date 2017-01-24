package ukr.cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.cityinfo.CityInfo;
import retrofit2.Response;
import ukr.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Created by groshkka on 20.01.17.
 */
public class TestCityInfo extends HomeTest {

    @DataProvider(name = "getUkrCityInfoUkr")
    public static Object[][] getCityParamUkr() {
        return new Object[][]{
                {KIEV_ID, KIEV_UKR, 200, null, null},//all parameter
                {DNIPRO_ID, DNIPRO_UKR, 200, null, null},//all parameter
                {BILA_CERKVA_ID, BILA_CERKVA_UKR, 200, null, null},//all parameter
                {VINICA_ID, VINICA_UKR, 200, null, null},//all parameter
                {DNIPRODZERZYSK_ID, DNIPRODZERZYSK_UKR, 200, null, null},//all parameter
                {FAKE_CITY_ID, KIEV_UKR, 400, INVALID_CITY_ID, CITY_DOESNT_FIND},//INVALID_CITY_ID
        };
    }

    @Test(dataProvider = "getUkrCityInfoUkr")
    public void testGetCityInfoUkrUkr(long cityId, String cityName, int stCode, String error, String errorMassage) throws IOException {
        Response<CityInfo> response = ShopUkrApi.get().getCityInfoUkrUkr(cityId).execute();
        assertEquals(response.code(), stCode, "Wrong status code for request getShop");

        if (stCode == 200) {
            assertEquals(response.body().getCity().getName(), cityName, "Wrong city name");
        } else if (stCode >= 400) {
            checkResponsesAr(response.errorBody().string(), error, errorMassage, "Incorrect error message for getCityInfo");
        }
    }

    @DataProvider(name = "getUkrCityInfoRu")
    public static Object[][] getShopParamUkrRu() {
        return new Object[][]{
                {KIEV_ID, KIEV_RU, 200, null, null},//all parameter
                {DNIPRO_ID, DNIPRO_RU, 200, null, null},//all parameter
                {BILA_CERKVA_ID, BILA_CERKVA_RU, 200, null, null},//all parameter
                {VINICA_ID, VINICA_RU, 200, null, null},//all parameter
                {DNIPRODZERZYSK_ID, DNIPRODZERZYSK_RU, 200, null, null},//all parameter
                {FAKE_CITY_ID, KIEV_RU, 400, INVALID_CITY_ID, CITY_DOESNT_FIND},//INVALID_CITY_ID
        };
    }

    @Test(dataProvider = "getUkrCityInfoRu")
    public void testGetCityInfoUkrRu(long cityId, String cityName, int stCode, String error, String errorMassage) throws IOException {
        Response<CityInfo> response = ShopUkrApi.get().getCityInfoUkrRu(cityId).execute();
        assertEquals(response.code(), stCode, "Wrong status code for request getShop");

        if (stCode == 200) {
            assertEquals(response.body().getCity().getName(), cityName, "Wrong city name");
        } else if (stCode >= 400) {
            checkResponsesAr(response.errorBody().string(), error, errorMassage, "Incorrect error message for getCityInfo");
        }
    }
}
