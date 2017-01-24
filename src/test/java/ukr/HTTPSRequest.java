package ukr;


import po.category.Categories;
import po.cityinfo.CityInfo;
import po.shops.Shops;
import retrofit2.Call;
import retrofit2.http.*;


/**
 * Created by groshkka on 18.06.16.
 */
public interface HTTPSRequest {

    //new api
    @GET("uk/api/shops")
    Call<Shops> getShops(@Query("limit") int limit, @Query("name") String name, @Query("lat") Double lat, @Query("lng") Double lng, @Query("city_id") long city_id, @Query("fields") String fields, @Query("offset") int offset);

    @GET("uk/api/cities/{city_id}")
    Call<CityInfo> getCityInfoUkrUkr(@Path("city_id") long cityId);

    @GET("/api/cities/{city_id}")
    Call<CityInfo> getCityInfoUkrRu(@Path("city_id") long cityId);

    @GET("api/categories")
    Call<Categories> getCategories(@Query("limit") int limit, @Query("offset") int offset, @Query("city_id") Long city_id, @Query("fields") String fields);

    /*@Headers({
            "Guid:3d22625a-f62e-450e-a44f-6ccdd2abaedb",
            "Signature:7227958f79d8f01b938c811fa03257924e4f7130a0db569c032fbfa87f64adc7"})
    @GET("restaurant/getAll")
    Call<List<Cafe>> getAll();*/

    /*@Headers({
            "Guid:3d22625a-f62e-450e-a44f-6ccdd2abaedb",
            "Signature:7227958f79d8f01b938c811fa03257924e4f7130a0db569c032fbfa87f64adc7"})
    @POST("client/come")
    Call<ComeToRestaurant> comeToRestoraunt(@Body UserIdentification toRestoraunt);*/
}