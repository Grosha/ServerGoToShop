
package po.shop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Get {

    @SerializedName("limit")
    @Expose
    private String limit;
    @SerializedName("name")
    @Expose
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
