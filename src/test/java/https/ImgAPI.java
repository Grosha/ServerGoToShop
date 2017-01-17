package https;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by groshkka on 17.01.17.
 */
public class ImgAPI extends API {
    private static HTTPSRequest api;

    public static HTTPSRequest get() {
        if (api == null) {
            new ImgAPI();
        }
        return api;
    }

    public ImgAPI() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gtsop.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient())
                .build();

        api = retrofit.create(HTTPSRequest.class);
    }
}
