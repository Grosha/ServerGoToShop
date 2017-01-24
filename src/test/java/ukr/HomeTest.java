package ukr;

import com.google.gson.Gson;
import po.error.ServerErrorGA;
import po.error.ShopServerError;

import static org.testng.Assert.assertEquals;

/**
 * Created by groshkka on 19.01.17.
 */
public class HomeTest implements Parameters, ParameterCity, ErrorResponses {
    public static void checkResponses(String responses, String message, String messageJenkinsl) {
        Gson gson = new Gson();
        ShopServerError actualServerError = gson.fromJson(responses, ShopServerError.class);

        ShopServerError expectedServerError = new ShopServerError();
        expectedServerError.setError(message);
        assertEquals(actualServerError.getError(), expectedServerError.getError(), messageJenkinsl);
    }

    public static void checkResponsesAr(String responses, String message, String errorDesctiption, String messageJenkinsl) {
        Gson gson = new Gson();
        ServerErrorGA actualServerError = gson.fromJson(responses, ServerErrorGA.class);

        ServerErrorGA expectedServerError = new ServerErrorGA();
        expectedServerError.setError(message);
        expectedServerError.setErrorDescription(errorDesctiption);
        assertEquals(actualServerError.getError(), expectedServerError.getError(), messageJenkinsl);
        assertEquals(actualServerError.getErrorDescription(), expectedServerError.getErrorDescription(), messageJenkinsl);
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

    public boolean assertNumberTrue(String data) {
        try {
            long l = Long.parseLong(data);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String errorInvalidParam(String error, String... param) {
        for (int i = 0; i < param.length; i++) {
            if (i + 1 == param.length) {
                error = error + param[i];
            } else error = error + param[i] + ",";
        }
        return error;
    }
}
