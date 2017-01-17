package https;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.shop.GoToShopObject;
import retrofit2.Response;
import retrofit2.http.Url;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by groshkka on 15.06.16.
 */
public class TestGetShop implements Parameters {
    @DataProvider(name = "getShop")
    public static Object[][] getShopParameters() {
        return new Object[][]{
                {1, null, 314, getTheseParameters(id, name, catId, img25, img50, img100, imgMap, discounts, distance), 0, 200, null},//all parameter
        };
    }

    @Test(dataProvider = "getShop")
    public void testGetShop(int limit, String name, long cityId, String fields, int offset, int stCode, String errorMassage) throws IOException {
        //"id,name,categories_id,image100,image50,image25,imagemap,discounts,distance"
        Response<GoToShopObject> response = ShopUkrApi.get().getShops(limit, name, cityId, fields, offset).execute();
        assertEquals(response.code(), stCode, "Wrong status code for request getShop");
        assertNotNull(response.body());

        GoToShopObject shop = response.body();
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

    public static boolean getResponseCode(URL url) {
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


    @Test
    public void sdfsf() {
    }
}
