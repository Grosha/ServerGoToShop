package https;

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

        /*OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Guid", "Your-App-Name")
                        .header("Signature", "application/vnd.yourapi.v1.full+json")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gtsop.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient())
                .build();

        api = retrofit.create(HTTPSRequest.class);
    }
}
