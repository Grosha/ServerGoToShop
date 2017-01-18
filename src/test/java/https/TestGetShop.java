package https;


import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.Input;
import po.error.Get;
import po.error.ShopServerError;
import po.shops.Shops;
import retrofit2.Response;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by groshkka on 15.06.16.
 */
public class TestGetShop implements Parameters, ErrorResponses {
    private int totalCount = 0;
    private boolean count = false;

    @DataProvider(name = "getShop")
    public static Object[][] getShopParameters() {
        return new Object[][]{
                //{1, null, 314, getTheseParameters(id, name, catId, img25, img50, img100, imgMap, discounts, distance), 0, 200, null},//all parameter
                {1, null, 314, getTheseParameters(fakeParam), 0, 400, INVALID_PARAMETER_FIEDS},//fake parameter
                {1, null, 314, getTheseParameters(id, name, catId, fakeParam), 0, 400, INVALID_PARAMETER_FIEDS},//fake parameter
        };
    }

    @Test(dataProvider = "getShop")
    public void testGetShop(int limit, String name, long cityId, String fields, int offset, int stCode, String errorMassage) throws IOException {
        //while (count == false) {
        Response<Shops> response = ShopUkrApi.get().getShops(limit, name, cityId, fields, offset).execute();
        assertEquals(response.code(), stCode, "Wrong status code for request getShop");

        if (stCode == 200) {
            assertNotNull(response.body());
            Shops shop = response.body();

            //checkValidUrl(limit, shop);

            totalCount = totalCount + Integer.valueOf(shop.getCountPerPage());
            if (totalCount == Integer.valueOf(shop.getTotalCount())) {
                count = true;
                System.out.println("catch count " + totalCount);
                //}
            }
        } else if (stCode >= 400) {
            checkResponses(response.errorBody().string(), errorMassage, "Incorrect error message for getShops");
        }

    }

    private void checkValidUrl(int limit, Shops shop) throws MalformedURLException {
        List<URL> brokenUrl = new ArrayList<URL>();
        for (int i = 0; i < limit; i++) {
            URL url25 = new URL(shop.getShops().get(i).getImage25());
            if (getResponseCode(url25) == false) brokenUrl.add(url25);
            /*URL url50 = new URL(shop.getShops().get(i).getImage50());
            if (getResponseCode(url50) == false) brokenUrl.add(url50);
            URL url100 = new URL(shop.getShops().get(i).getImage100());
            if (getResponseCode(url100) == false) brokenUrl.add(url100);
            URL urlMap = new URL(shop.getShops().get(i).getImagemap());
            if (getResponseCode(urlMap) == false) brokenUrl.add(urlMap);*/
        }

        if (brokenUrl.size() != 0) {
            System.out.println("Broken URL:");
            for (int i = 0; i < brokenUrl.size(); i++) {
                System.out.println(brokenUrl.get(i));
            }
        }
    }

    private static String getTheseParameters(String... param) {
        String line = "";
        for (int i = 0; i < param.length; i++) {
            if (i + 1 == param.length) {
                line = line + param[i];
            } else line = line + param[i] + ",";
        }
        return line;
    }

    private static boolean getResponseCode(URL url) {
        boolean isValid = false;
        try {
            HttpsURLConnection h = (HttpsURLConnection) url.openConnection();
            h.setRequestMethod("GET");
            h.connect();
            System.out.println(h.getResponseCode());
            System.out.println(h.getResponseMessage());
            if (h.getResponseCode() == 200) {
                isValid = true;
            }
        } catch (Exception e) {

        }
        return isValid;
    }

    public static void checkResponses(String responses, String message, String messageJenkinsl) {
        Gson gson = new Gson();
        ShopServerError actualServerError = gson.fromJson(responses, ShopServerError.class);

        ShopServerError expectedServerError = new ShopServerError();
        expectedServerError.setError(message);

        /*Get get = new Get();
        get.setFields(nameParameter);
        get.setLimit(String.valueOf(limit));
        get.setCityId(String.valueOf(cityId));
        Input input = new Input();
        input.setGet();
        expectedServerError.setInput();*/

        assertEquals(actualServerError.getError(), expectedServerError.getError(), messageJenkinsl);
    }


    @Test
    public void sdfsf() {
    }
}
