package ukr.cases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.shops.Shops;
import retrofit2.Response;
import ukr.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static ukr.HomeTest.checkResponses;
import static ukr.HomeTest.getTheseParameters;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by groshkka on 15.06.16.
 */
public class TestGetShop extends HomeTest {
    private int totalCount = 0;
    private boolean count = false;

    @DataProvider(name = "getShop")
    public static Object[][] getShopParameters() {
        return new Object[][]{
                {1, null, 50.4659311, 30.6263447, KIEV_ID, getTheseParameters(id, name, catId, img25, img50, img100, imgMap, discounts, distance), 0, 200, null},//all parameter
                {1, null, null, null, KIEV_ID, getTheseParameters(id, name, catId, img25, img50, img100, imgMap, discounts, distance), 0, 200, null},//all parameter
                {1, null, 50.4659311, 30.6263447, DNIPRO_ID, getTheseParameters(fakeParam), 0, 400, INVALID_PARAMETER_FIEDS},//fake parameter
                {1, null, null, null, DNIPRO_ID, getTheseParameters(id, name, catId, fakeParam), 0, 400, INVALID_PARAMETER_FIEDS},//fake parameter
        };
    }

    @Test(dataProvider = "getShop")
    public void testGetShop(int limit, String name, Double lat, Double lng, long cityId, String fields, int offset, int stCode, String errorMassage) throws IOException {
        Response<Shops> response = ShopUkrApi.get().getShops(limit, name, lat, lng, cityId, fields, offset).execute();
        assertEquals(response.code(), stCode, "Wrong status code for request getShop");

        if (stCode == 200) {
            assertNotNull(response.body());
        } else if (stCode >= 400) {
            checkResponses(response.errorBody().string(), errorMassage, "Incorrect error message for getShops");
        }

    }

    @DataProvider(name = "getIconShop")
    public static Object[][] getIconShopParameters() {
        return new Object[][]{
                {11, null, 50.4659311, 30.6263447, KIEV_ID, getTheseParameters(id, name, catId, img25, img50, img100, imgMap, discounts, distance), 0, 200, null},//all parameter
                //{25, null, 50.4659311, 30.6263447, VINICA, getTheseParameters(id, name, catId, img25, img50, img100, imgMap, discounts, distance), 0, 200, null},//all parameter
                //{1, null, null, null, KIEV_ID, getTheseParameters(id, name, catId, img25, img50, img100, imgMap, discounts, distance), 0, 200, null},//all parameter
        };
    }

    @Test(dataProvider = "getIconShop")
    public void testGetIconShop(int limit, String name, Double lat, Double lng, long cityId, String fields, int offset, int stCode, String errorMassage) throws IOException, InterruptedException {
        //while (count == false) {
        Response<Shops> response = ShopUkrApi.get().getShops(limit, name, lat, lng, cityId, fields, offset).execute();
        assertEquals(response.code(), stCode, "Wrong status code for request getShop");

        assertNotNull(response.body());
        Shops shop = response.body();

        checkValidUrl(limit, shop);

            /*offset = offset + limit;
            totalCount = totalCount + Integer.valueOf(shop.getCountPerPage());
            System.out.println("new offset " + offset);
            if (totalCount >= Integer.valueOf(shop.getTotalCount())) {
                count = true;
                System.out.println("catch count " + totalCount);
            }*/
        //}

    }

    private void checkValidUrl(int limit, Shops shop) throws MalformedURLException, InterruptedException {
        List<URL> brokenUrl = new ArrayList<URL>();
        for (int i = 0; i < limit; i++) {
            URL url25 = new URL(shop.getShops().get(i).getImage25());
            if (getResponseCode(url25) == false) brokenUrl.add(url25);
            URL url50 = new URL(shop.getShops().get(i).getImage50());
            if (getResponseCode(url50) == false) brokenUrl.add(url50);
            URL url100 = new URL(shop.getShops().get(i).getImage100());
            if (getResponseCode(url100) == false) brokenUrl.add(url100);
            URL urlMap = new URL(shop.getShops().get(i).getImagemap());
            if (getResponseCode(urlMap) == false) brokenUrl.add(urlMap);
        }

        if (brokenUrl.size() != 0) {
            System.out.println("Broken URL:");
            for (int i = 0; i < brokenUrl.size(); i++) {
                System.out.println(brokenUrl.get(i));
            }
        }
        Thread.sleep(500);
    }

    private static boolean getResponseCode(URL url) {
        boolean isValid = true;
        try {
            HttpsURLConnection h = (HttpsURLConnection) url.openConnection();
            h.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
            h.connect();
            System.out.println(h.getResponseCode());
            //System.out.println(h.getResponseMessage());
            if (h.getResponseCode() != 200) {
                isValid = false;
            }
        } catch (Exception e) {

        }
        return isValid;
    }
}
