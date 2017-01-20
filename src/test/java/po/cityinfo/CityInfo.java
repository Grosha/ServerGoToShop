
package po.cityinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import po.InputAr;

public class CityInfo {

    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("input")
    @Expose
    private InputAr input;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public InputAr getInput() {
        return input;
    }

    public void setInput(InputAr input) {
        this.input = input;
    }

}
