package rest.model;

import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import java.util.List;
import util.StringUtils;

/**
 * Created for parsing "args" object which is responded by 
 * {@link BasicService#testGetRequest(int, float, String)} 
 */
public class AccountRestModel {
    @SerializedName("email")
    private String mEmail;

    @SerializedName("password")
    private String mPassword;

    @SerializedName("codes")
    private List<Integer> mCodes;

    public AccountRestModel(String email, String password, List<Integer> codes) {
        this.mEmail = email;
        this.mPassword = password;
        this.mCodes = codes;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }
    
    public String getPassword() {
        return this.mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    public List<Integer> getCodes() {
        return this.mCodes;
    }

    public void setCodes(List<Integer> codes) {
        this.mCodes = codes;
    }

    @Override
    public String toString() {
        return StringUtils.objectToString(this);
    }
}