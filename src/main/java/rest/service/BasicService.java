package rest.service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rest.model.TestGetRestModel;
import rest.model.TestPostRestModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rest.model.HeaderRestModel;
import rest.model.IpRestModel;
import rest.model.HeaderWrapperRestModel;

/**
 * Basic service implementations for {@link http://httpbin.org}
 */
public interface BasicService {

    /**
     * {@link http://httpbin.org/ip} sends back the requester IP in response
     */
    @GET("ip")
    public Call<IpRestModel> testIp();

    /**
     * Makes GET requests
     * {@link http://httpbin.org/get} sends back the GET and Header values in request
     */
    @GET("get")
    public Call<TestGetRestModel> testGetRequest(@Query("user_id") int userId, @Query("money") float money,
            @Query("name") String name);

    /**
     * Makes post request with additional query strings (GET)
     * {@link http://httpbin.org/post} sends back the POST, GET and Header values in request
     */
    @POST("post?osman=123") // Query strings can be added to POST requests like this  
    @FormUrlEncoded
    public Call<TestPostRestModel> testPostRequest(@Field("email") String email, @Field("password") String password,
            @Field("codes") List<Integer> codes,
            // Query strings can be added to POST requests like this
            @Query("sort_type") String sortType);

    /**
     * Makes request with custom dynamic Header value
     * {@link http://httpbin.org/headers} sends back the Header values in request
     */
    @GET("headers")
    public Call<HeaderWrapperRestModel<HeaderRestModel>> testHeaderDynamic(
            @Header("Dynamic-Header") String dynamicHeader /* Dynamic Header */
    );

    /**
     * Makes request with request-based static Header value. Every time this method
     * is called. Header property which has been defined in annotation, is attached to request.
     * {@link http://httpbin.org/headers} sends back the Header values in request
     */
    @Headers({ "Request-Based-Static-Header: Request-Based static header value!" })
    @GET("headers")
    public Call<HeaderWrapperRestModel<HeaderRestModel>> testHeaderStatic();

    /**
     * Makes POST request with a file using Multipart
     * @Part("user_id") RequestBody userId and @Part("user_name") RequestBody userName
     * appears in "form" section of request whic means same as the basic POST request
     * 
     * @Part MultipartBody.Part profilePicture
     * MultipartBody.Part types can not take key string like @Part("file")
     * File transferred with its encoded form by Base64.
     * Key must be defined in creation of MultipartBody.Part object
     * 
     * {@link http://httpbin.org/post} sends back the File and POST values in request
     */
    @Multipart
    @POST("post")
    public Call<ResponseBody> testUploadFileBasic(@Part("user_id") RequestBody userId,
            @Part("user_name") RequestBody userName, @Part MultipartBody.Part profilePicture);
}