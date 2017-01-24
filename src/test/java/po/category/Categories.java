
package po.category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import po.Input;

public class Categories {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
