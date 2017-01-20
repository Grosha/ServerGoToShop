
package po.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import po.Input;
import po.InputAr;

import java.util.List;

public class ServerErrorGA {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("error_description")
    @Expose
    private String errorDescription;
    @SerializedName("input")
    @Expose
    private InputAr input;

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

    public InputAr getInput() {
        return input;
    }

    public void setInput(InputAr input) {
        this.input = input;
    }
}
