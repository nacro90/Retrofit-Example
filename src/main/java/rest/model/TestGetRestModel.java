package rest.model;

import com.google.gson.annotations.SerializedName;
import rest.service.BasicService;
import util.StringUtils;

/**
 * GetRestModel
 */
public class TestGetRestModel {

    /**
     * Holds the "args" object which contains information given to 
     * {@link BasicService#testGetRequest(int, float, String)} 
     */
    @SerializedName("args")
    private PersonRestModel mPerson;

    /**
     * Holds the Header data of request.
     */
    @SerializedName("headers")
    private HeaderRestModel mHeader;

    /**
     * Holds the IP value of requester.
     */
    @SerializedName("origin")
    private String mOrigin;

    /**
     * Holds the URL of request.
     */
    @SerializedName("url")
    private String mUrl;

    public TestGetRestModel(PersonRestModel person, HeaderRestModel header, String origin, String url) {
        this.mPerson = person;
        this.mHeader = header;
        this.mOrigin = origin;
        this.mUrl = url;
    }

    /**
     * @return the {@link #mPerson}
     */
    public PersonRestModel getPerson() {
        return this.mPerson;
    }

    /**
     * @param mPerson the person to set
     */
    public void setmPerson(PersonRestModel mPerson) {
        this.mPerson = mPerson;
    }

    /**
     * @return the {@link #mHeader}
     */
    public HeaderRestModel getHeader() {
        return this.mHeader;
    }

    /**
     * @param mHeader the mHeader to set
     */
    public void setHeader(HeaderRestModel mHeader) {
        this.mHeader = mHeader;
    }

    /**
     * @return the {@link #mOrigin}
     */
    public String getOrigin() {
        return this.mOrigin;
    }

    /**
     * @param mOrigin the mOrigin to set
     */
    public void setmOrigin(String mOrigin) {
        this.mOrigin = mOrigin;
    }

    /**
     * @return the {@link mUrl}
     */
    public String getUrl() {
        return this.mUrl;
    }

    /**
     * @param mUrl the mUrl to set
     */
    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    @Override
    public String toString() {
        return StringUtils.objectToString(this);
    }
}