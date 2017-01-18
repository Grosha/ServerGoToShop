
package po;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import po.shops.Get;

public class Input {

    @SerializedName("input")
    @Expose
    private List<Object> input = null;
    @SerializedName("post")
    @Expose
    private List<Object> post = null;
    @SerializedName("get")
    @Expose
    private Get get;

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

    public Get getGet() {
        return get;
    }

    public void setGet(Get get) {
        this.get = get;
    }

}
