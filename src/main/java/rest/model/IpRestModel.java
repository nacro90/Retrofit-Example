package rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import rest.service.BasicService;
import util.StringUtils;

/**
 * Holds the response of {@link BasicService#testIp} request
 */
public class IpRestModel {

    /**
     * Holds IP value
     */
    @SerializedName("origin")
    @Expose
    private String mOrigin;

    public IpRestModel(String origin) {
        this.mOrigin = origin;
    }

    /**
     * @return {@link IpRestObject#mOrigin}
     */
    public String getOrigin() {
        return this.mOrigin;
    }

    /**
     * @param origin - String IP value to set for {@link #mOrigin}
     */
    public void setOrigin(String origin) {
        this.mOrigin = origin;
    }

    @Override
    public String toString() {
        return StringUtils.objectToString(this);
    }
}