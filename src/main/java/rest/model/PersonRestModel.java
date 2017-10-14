package rest.model;

import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import util.StringUtils;

/**
 * Created for parsing "args" object which is responded by 
 * {@link BasicService#testGetRequest(int, float, String)} 
 */
public class PersonRestModel {
    @SerializedName("user_id")
    private int mUserId;

    @SerializedName("money")
    private float mMoney;

    @SerializedName("name")
    private String mName;

    public PersonRestModel(int userId, float money, String name) {
        this.mUserId = userId;
        this.mMoney = money;
        this.mName = name;
    }

    /**
     * @return {@link #mUserId}
     */
    public int getUserId() {
        return this.mUserId;
    }

    /**
     * @param userId - Integer user ID value to set {@link #mUserId}
     */
    public void setUserId(int userId) {
        this.mUserId = userId;
    }

    /**
     * @return {@link #mMoney}
     */
    public float getMoney() {
        return this.mMoney;
    }

    /**
     * @param money - Integer money value to set {@link #mMoney}
     */
    public void setMoney(float money) {
        this.mMoney = money;
    }

    /**
     * @return {@link #mName}
     */
    public String getName() {
        return this.mName;
    }

    /**
     * @param name - String name value to set {@link #mName}
     */
    public void setName(String name) {
        this.mName = name;
    }

    @Override
    public String toString() {
        return StringUtils.objectToString(this);
    }
}