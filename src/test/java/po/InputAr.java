
package po;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputAr {

    @SerializedName("input")
    @Expose
    private List<Object> input = null;
    @SerializedName("post")
    @Expose
    private List<Object> post = null;
    @SerializedName("get")
    @Expose
    private List<Object> get = null;

    public List<Object> getInput() {
        return input;
    }

    public void setInput(List<Object> input) {
        this.input = input;
    }

    public List<Object> getPost() {
        return post;
    }

    public void setPost(List<Object> post) {
        this.post = post;
    }

    public List<Object> getGet() {
        return get;
    }

    public void setGet(List<Object> get) {
        this.get = get;
    }

}
