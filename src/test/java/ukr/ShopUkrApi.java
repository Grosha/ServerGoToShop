package ukr;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShopUkrApi extends API {
    private static HTTPSRequest api;


    public static HTTPSRequest get() {
        if (api == null) {
            new ShopUkrApi();
        }
        return api;
    }

    public ShopUkrApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gtsop.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient())
                .build();

        api = retrofit.create(HTTPSRequest.class);
    }
}
