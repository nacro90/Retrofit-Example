package rest.model;

import com.google.gson.annotations.SerializedName;
import rest.service.BasicService;
import util.StringUtils;

/**
 * GetRestModel
 */
public class TestPostRestModel {

    /**
     * Holds the "form" object which contains POST part of the information given to 
     * {@link BasicService#testPostRequest(String, String, java.util.List, String)} 
     */
    @SerializedName("form")
    private AccountRestModel mAccount;

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

    public TestPostRestModel(AccountRestModel account, HeaderRestModel header, String origin, String url) {
        this.mAccount = account;
        this.mHeader = header;
        this.mOrigin = origin;
        this.mUrl = url;
    }

    /**
     * @return the {@link #mAccount}
     */
    public AccountRestModel getAccount() {
        return this.mAccount;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(AccountRestModel account) {
        this.mAccount = account;
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