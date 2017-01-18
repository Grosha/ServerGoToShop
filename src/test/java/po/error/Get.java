
package po.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Get {

    @SerializedName("limit")
    @Expose
    private String limit;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("fields")
    @Expose
    private String fields;
    @SerializedName("offset")
    @Expose
    private String offset;

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

}
