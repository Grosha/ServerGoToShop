
package po.shop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shop {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("categories_id")
    @Expose
    private String categoriesId;
    @SerializedName("image100")
    @Expose
    private String image100;
    @SerializedName("image50")
    @Expose
    private String image50;
    @SerializedName("image25")
    @Expose
    private String image25;
    @SerializedName("imagemap")
    @Expose
    private String imagemap;
    @SerializedName("discounts")
    @Expose
    private String discounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(String categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getImage100() {
        return image100;
    }

    public void setImage100(String image100) {
        this.image100 = image100;
    }

    public String getImage50() {
        return image50;
    }

    public void setImage50(String image50) {
        this.image50 = image50;
    }

    public String getImage25() {
        return image25;
    }

    public void setImage25(String image25) {
        this.image25 = image25;
    }

    public String getImagemap() {
        return imagemap;
    }

    public void setImagemap(String imagemap) {
        this.imagemap = imagemap;
    }

    public String getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String discounts) {
        this.discounts = discounts;
    }

}
