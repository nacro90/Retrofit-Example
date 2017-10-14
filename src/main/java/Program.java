import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rest.RetrofitClient;
import rest.helper.ProgressRequestBody;
import rest.helper.ProgressRequestBody.UploadCallbacks;
import rest.model.HeaderRestModel;
import rest.model.IpRestModel;
import rest.model.HeaderWrapperRestModel;
import rest.model.TestGetRestModel;
import rest.model.TestPostRestModel;
import rest.service.BasicService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Main program of project
 */
public class Program {
    public static void main(String[] args) {
        // getIp();
        // testGet(1, 2.356f, "Orcan Tirkan");
        // testPost("orcan@gmail.com", "123456", Arrays.asList(new Integer[] { 3, 1, 4, 1, 5 }), "ASC");
        // testHeaderDynamic("ABC123DFE");
        // testHeaderClientBasedStatic();
        // testHeaderClientBasedStatic();

        ClassLoader classLoader = Program.class.getClassLoader();

        // File file = new File(classLoader.getResource("img/stare_dad.jpg").getFile());
        // testFileUpload(123, "Orcan Tirkan", file);

        // File bigFile = new File(classLoader.getResource("img/big_image.jpg").getFile());
        // testFileUploadProgress(123, "Orcan Tirkan", bigFile);
    }

    private static void getIp() {
        BasicService basicService = RetrofitClient.getClient().create(BasicService.class);
        Call<IpRestModel> getIpCall = basicService.testIp();
        getIpCall.enqueue(new Callback<IpRestModel>() {

            @Override
            public void onResponse(Call<IpRestModel> call, Response<IpRestModel> response) {

                if (response.isSuccessful()) { // if the response code is (status 200-299).
                    System.out.println();
                    System.out.println("Received object");
                    System.out.println(response.body().toString());

                    System.out.println();

                    System.out.println("Your IP address is " + response.body().getOrigin());
                    System.out.println();
                } else {
                    System.err.println("onResponse(): getIp() has been failed!");
                    System.err.println("Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<IpRestModel> call, Throwable t) {
                System.err.println("onFailure(): getIp() has been failed!");
                t.printStackTrace();
            }
        });
    }

    private static void testGet(int userId, float money, String name) {

        BasicService basicService = RetrofitClient.getClient().create(BasicService.class);
        Call<TestGetRestModel> testGetCall = basicService.testGetRequest(userId, money, name);
        testGetCall.enqueue(new Callback<TestGetRestModel>() {

            @Override
            public void onResponse(Call<TestGetRestModel> call, Response<TestGetRestModel> response) {
                System.out.println();
                System.out.println("Received object");
                System.out.println(response.body().toString());

                System.out.println();

                System.out.println("Your GET object is " + response.body().getPerson().toString());
                System.out.println();
            }

            @Override
            public void onFailure(Call<TestGetRestModel> call, Throwable t) {
                System.err.println("onFailure(): testGet() has been failed!");
                t.printStackTrace();
            }
        });
    }

    private static void testPost(String email, String password, List<Integer> name, String sortType) {

        BasicService basicService = RetrofitClient.getClient().create(BasicService.class);
        Call<TestPostRestModel> testPostCall = basicService.testPostRequest(email, password, name, sortType);
        testPostCall.enqueue(new Callback<TestPostRestModel>() {

            @Override
            public void onResponse(Call<TestPostRestModel> call, Response<TestPostRestModel> response) {
                System.out.println();
                System.out.println("Received object");
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<TestPostRestModel> call, Throwable t) {
                System.err.println("onFailure(): testPost() has been failed!");
                t.printStackTrace();
            }
        });
    }

    private static void testHeaderDynamic(String dynamicHeaderValue) {
        BasicService basicService = RetrofitClient.getClient().create(BasicService.class);
        Call<HeaderWrapperRestModel<HeaderRestModel>> testHeaderCall = basicService
                .testHeaderDynamic(dynamicHeaderValue);
        testHeaderCall.enqueue(new Callback<HeaderWrapperRestModel<HeaderRestModel>>() {

            @Override
            public void onResponse(Call<HeaderWrapperRestModel<HeaderRestModel>> call,
                    Response<HeaderWrapperRestModel<HeaderRestModel>> response) {
                System.out.println();
                System.out.println("Received object");
                System.out.println(response.body().toString());

                System.out.println();

                System.out.println("Dynamic header is " + response.body().getObject().getDynamicHeader());
                System.out.println();
            }

            @Override
            public void onFailure(Call<HeaderWrapperRestModel<HeaderRestModel>> call, Throwable t) {
                System.err.println("onFailure(): testHeader() has been failed!");
                t.printStackTrace();
            }
        });
    }

    private static void testHeaderRequestBasedStatic() {
        BasicService basicService = RetrofitClient.getClient().create(BasicService.class);
        Call<HeaderWrapperRestModel<HeaderRestModel>> testHeaderCall = basicService.testHeaderStatic();
        testHeaderCall.enqueue(new Callback<HeaderWrapperRestModel<HeaderRestModel>>() {

            @Override
            public void onResponse(Call<HeaderWrapperRestModel<HeaderRestModel>> call,
                    Response<HeaderWrapperRestModel<HeaderRestModel>> response) {
                System.out.println();
                System.out.println("Received object");
                System.out.println(response.body().toString());

                System.out.println();

                System.out.println("Your request-based static header is "
                        + response.body().getObject().getRequestBasedStaticHeader());
                System.out.println();
            }

            @Override
            public void onFailure(Call<HeaderWrapperRestModel<HeaderRestModel>> call, Throwable t) {
                System.err.println("onFailure(): testHeaderRequestBasedStatic() has been failed!");
                t.printStackTrace();
            }
        });
    }

    private static void testHeaderClientBasedStatic() {
        BasicService basicService = RetrofitClient.getClient().create(BasicService.class);
        Call<HeaderWrapperRestModel<HeaderRestModel>> testHeaderCall = basicService.testHeaderStatic();
        testHeaderCall.enqueue(new Callback<HeaderWrapperRestModel<HeaderRestModel>>() {

            @Override
            public void onResponse(Call<HeaderWrapperRestModel<HeaderRestModel>> call,
                    Response<HeaderWrapperRestModel<HeaderRestModel>> response) {
                System.out.println();
                System.out.println("Received object");
                System.out.println(response.body().toString());

                System.out.println();

                System.out.println("Your client-based static header is "
                        + response.body().getObject().getClientBasedStaticHeader());
                System.out.println();
            }

            @Override
            public void onFailure(Call<HeaderWrapperRestModel<HeaderRestModel>> call, Throwable t) {
                System.err.println("onFailure(): testHeaderClientBasedStatic() has been failed!");
                t.printStackTrace();
            }
        });
    }

    private static void testFileUpload(int userId, String userName, File profilePicture) {

        RequestBody requestFileBody = RequestBody.create(MediaType.parse("multipart/form-data"), profilePicture);

        // MultipartBody.Part key is defined in first argument ("profile_picture")
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("profile_picture",
                profilePicture.getName(), requestFileBody);

        // add another part within the multipart request
        RequestBody userNameBody = RequestBody.create(MediaType.parse("multipart/form-data"), userName);

        // add another part within the multipart request
        RequestBody userIdBody = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(userId));

        BasicService basicService = RetrofitClient.getClient().create(BasicService.class);
        Call<ResponseBody> testHeaderCall = basicService.testUploadFileBasic(userIdBody, userNameBody, multipartBody);
        testHeaderCall.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    System.out.println();
                    System.out.println("File upload successful!");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.err.println("onFailure(): testFileUpload() has been failed!");
                t.printStackTrace();
            }
        });
    }

    private static void testFileUploadProgress(int userId, String userName, File bigFile) {

        RequestBody requestFileBody = new ProgressRequestBody(bigFile, new UploadCallbacks() {

            @Override
            public void onProgressUpdate(int percentage) {
                System.out.println("Uploading -> %" + percentage);
            }

            @Override
            public void onFinish() {
                System.out.println("Upload with progress succesfull");
            }

            @Override
            public void onError() {
                System.out.println("Upload with progress failed");
            }
        });

        // MultipartBody.Part key is defined in first argument ("profile_picture")
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("profile_picture", bigFile.getName(),
                requestFileBody);

        // add another part within the multipart request
        RequestBody userIdBody = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(userId));

        // add another part within the multipart request
        RequestBody userNameBody = RequestBody.create(MediaType.parse("multipart/form-data"), userName);

        BasicService basicService = RetrofitClient.getClient().create(BasicService.class);
        Call<ResponseBody> testHeaderCall = basicService.testUploadFileBasic(userIdBody, userNameBody, multipartBody);
        testHeaderCall.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    System.out.println();
                    System.out.println("File upload successful!");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.err.println("onFailure(): testFileUploadProgress() has been failed!");
                t.printStackTrace();
            }
        });
    }
}