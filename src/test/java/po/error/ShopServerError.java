
package po.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import po.Input;

public class ShopServerError {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("error_description")
    @Expose
    private String errorDescription;
    @SerializedName("input")
    @Expose
    private Input input;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

}
