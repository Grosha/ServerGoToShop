package ukr.cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.category.Categories;
import po.category.Category;
import po.shops.Shops;
import retrofit2.Response;
import ukr.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by groshkka on 24.01.17.
 */
public class TestCategories extends HomeTest {
    @DataProvider(name = "getShop")
    public static Object[][] getShopParameters() {
        return new Object[][]{
                {13, KIEV_ID, getTheseParameters(id, name, discounts), 0, 200, null},//all parameter
                {13, BILA_CERKVA_ID, getTheseParameters(id, name, discounts), 0, 200, null},//all parameter
                {13, DNIPRO_ID, getTheseParameters(id, name, discounts), 0, 200, null},//all parameter
                {13, DNIPRODZERZYSK_ID, getTheseParameters(id, name, discounts), 0, 200, null},//all parameter
                {13, VINICA_ID, getTheseParameters(id, name, discounts), 0, 200, null},//all parameter
                {13, null, getTheseParameters(id, name, discounts), 0, 200, null},// city null - проходить 200, якщо передати пусте поле - приходить 400
                {13, KIEV_ID, getTheseParameters(nullParam), 0, 200, null},// city null - проходить 200, якщо передати пусте поле - приходить 400
                {13, KIEV_ID, getTheseParameters(fakeParam), 0, 400, errorInvalidParam(INVALID_PARAMETER_FIEDS_, id, name, slugParam, discounts)},//invalid parameter FIELD
        };
    }

    @Test(dataProvider = "getShop")
    public void testGetShop(int limit, Long cityId, String fields, int offset, int stCode, String errorMassage) throws IOException {
        Response<Categories> response = ShopUkrApi.get().getCategories(limit, offset, cityId, fields).execute();
        assertEquals(response.code(), stCode, "Wrong status code for request getCategories");

        if (stCode == 200) {
            Categories categories = response.body();
            assertNotNull(categories);
            for (Category category : categories.getCategories()) {
                assertNumberTrue(category.getId());
                assertNumberTrue(category.getDiscounts());
                assertNotNull(category.getName());
            }
        } else if (stCode >= 400) {
            checkResponses(response.errorBody().string(), errorMassage, "Incorrect error message for getCategories");
        }

    }
}
