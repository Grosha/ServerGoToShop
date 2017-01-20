package ukr;

/**
 * Created by groshkka on 18.01.17.
 */
public interface ErrorResponses {
    String INVALID_PARAMETER_FIEDS = "Invalid fields in 'fields' parameter: fake. Allowed fields: id,name,slug,categories_id,image100,image50,image25,imagemap,discounts,distance";
    String INVALID_CITY_ID = "invalid_city_id";
    String CITY_DOESNT_FIND = "Город не найден";
}
