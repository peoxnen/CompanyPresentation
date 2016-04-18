package pl.osp.osptemplate.data.model;

/**
 * Created by WSienski on 14/04/2016.
 */
public class Service {
    private String title;

    private String desc;

    private String img;

    private String redirect;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    @Override
    public String toString() {
        return "ClassPojo [title = " + title + ", desc = " + desc + ", img = " + img + ", redirect = " + redirect + "]";
    }
}
