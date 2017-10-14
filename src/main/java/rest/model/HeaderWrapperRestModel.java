package rest.model;

import com.google.gson.annotations.SerializedName;
import util.StringUtils;

public class HeaderWrapperRestModel<T> {

    @SerializedName("headers")
    private T mHeader;

    public HeaderWrapperRestModel(T object) {
        this.mHeader = object;
    }

    /**
     * @return the mObject
     */
    public T getObject() {
        return this.mHeader;
    }

    /**
     * @param mHeader the mObject to set
     */
    public void setmObject(T object) {
        this.mHeader = object;
    }

    @Override
    public String toString() {
        return StringUtils.objectToString(this);
    }
}