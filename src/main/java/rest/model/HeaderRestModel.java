package rest.model;

import com.google.gson.annotations.SerializedName;
import util.StringUtils;

/**
 * Holds header data of a response.
 */
public class HeaderRestModel {

    @SerializedName("Accept")
    private String mAccept;
    @SerializedName("Accept-Encoding")
    private String mAcceptEncoding;
    @SerializedName("Accept-Language")
    private String mAcceptLanguage;
    @SerializedName("Connection")
    private String mConnection;
    @SerializedName("Cookie")
    private String mCookie;
    @SerializedName("Host")
    private String mHost;
    @SerializedName("Referer")
    private String mReferer;
    @SerializedName("Upgrade-Insecure-Requests")
    private String mUpgradeInsecureRequests;
    @SerializedName("User-Agent")
    private String mUserAgent;

    @SerializedName("Dynamic-Header")
    private String mDynamicHeader;
    @SerializedName("Request-Based-Static-Header")
    private String mRequestBasedStaticHeader;
    @SerializedName("Client-Based-Static-Header")
    private String mClientBasedStaticHeader;

    public HeaderRestModel(String accept, String acceptEncoding, String acceptLanguage, String connection,
            String cookie, String host, String referer, String upgradeInsecureRequests, String userAgent,
            String dynamicHeader, String requestBasedStaticHeader, String clientBasedStaticHeader) {

        this.mAccept = accept;
        this.mAcceptEncoding = acceptEncoding;
        this.mAcceptLanguage = acceptLanguage;
        this.mConnection = connection;
        this.mCookie = cookie;
        this.mHost = host;
        this.mReferer = referer;
        this.mUpgradeInsecureRequests = upgradeInsecureRequests;
        this.mUserAgent = userAgent;
        this.mDynamicHeader = dynamicHeader;
        this.mRequestBasedStaticHeader = requestBasedStaticHeader;
        this.mClientBasedStaticHeader = clientBasedStaticHeader;
    }

    public String getAccept() {
        return this.mAccept;
    }

    public void setAccept(String accept) {
        this.mAccept = accept;
    }

    public String getAcceptEncoding() {
        return this.mAcceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.mAcceptEncoding = acceptEncoding;
    }

    public String getAcceptLanguage() {
        return this.mAcceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.mAcceptLanguage = acceptLanguage;
    }

    public String getDynamicHeader() {
        return this.mDynamicHeader;
    }

    public void setDynamicHeader(String dynamicHeader) {
        this.mDynamicHeader = dynamicHeader;
    }

    public String getRequestBasedStaticHeader() {
        return this.mRequestBasedStaticHeader;
    }

    public void setRequestBasedStaticHeader(String requestBasedStaticHeader) {
        this.mRequestBasedStaticHeader = requestBasedStaticHeader;
    }

    public String getClientBasedStaticHeader() {
        return this.mClientBasedStaticHeader;
    }

    public void setClientBasedStaticHeader(String clientBasedStaticHeader) {
        this.mClientBasedStaticHeader = clientBasedStaticHeader;
    }

    public String getConnection() {
        return this.mConnection;
    }

    public void setConnection(String connection) {
        this.mConnection = connection;
    }

    public String getCookie() {
        return this.mCookie;
    }

    public void setCookie(String cookie) {
        this.mCookie = cookie;
    }

    public String getHost() {
        return this.mHost;
    }

    public void setHost(String host) {
        this.mHost = host;
    }

    public String getReferer() {
        return this.mReferer;
    }

    public void setReferer(String referer) {
        this.mReferer = referer;
    }

    public String getUpgradeInsecureRequests() {
        return this.mUpgradeInsecureRequests;
    }

    public void setUpgradeInsecureRequests(String upgradeInsecureRequests) {
        this.mUpgradeInsecureRequests = upgradeInsecureRequests;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public void setUserAgent(String userAgent) {
        this.mUserAgent = userAgent;
    }

    @Override
    public String toString() {
        return StringUtils.objectToString(this);
    }
}