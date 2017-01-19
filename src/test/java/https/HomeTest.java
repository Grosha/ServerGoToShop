package https;

import com.google.gson.Gson;
import po.error.ShopServerError;

import static org.testng.Assert.assertEquals;

/**
 * Created by groshkka on 19.01.17.
 */
public class HomeTest {
    public static void checkResponses(String responses, String message, String messageJenkinsl) {
        Gson gson = new Gson();
        ShopServerError actualServerError = gson.fromJson(responses, ShopServerError.class);

        ShopServerError expectedServerError = new ShopServerError();
        expectedServerError.setError(message);
        assertEquals(actualServerError.getError(), expectedServerError.getError(), messageJenkinsl);
    }

    public static String getTheseParameters(String... param) {
        String line = "";
        for (int i = 0; i < param.length; i++) {
            if (i + 1 == param.length) {
                line = line + param[i];
            } else line = line + param[i] + ",";
        }
        return line;
    }
}
