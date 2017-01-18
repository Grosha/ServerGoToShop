
package po.shops;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import po.Input;

public class Shops {

    @SerializedName("shops")
    @Expose
    private List<Shop> shops = null;
    @SerializedName("totalCount")
    @Expose
    private String totalCount;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("countPerPage")
    @Expose
    private String countPerPage;
    @SerializedName("input")
    @Expose
    private Input input;

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(String countPerPage) {
        this.countPerPage = countPerPage;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

}
