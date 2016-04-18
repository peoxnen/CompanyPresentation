package pl.osp.osptemplate.data.model;

/**
 * Created by WSienski on 14/04/2016.
 */
public class Services {

    private Service[] services;

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "ClassPojo [services = " + services + "]";
    }

}
