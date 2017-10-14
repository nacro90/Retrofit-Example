package rest;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Interceptor.Chain;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class for Retrofit initialization
 * @author orcantiryaki
 */
public class RetrofitClient {

    /**
     * Base URL for Service.
     * Deafult value: {@value "http://httpbin.org/"}  
     */
    public static String BASE_URL = "http://httpbin.org/";

    private static Retrofit sRetrofit = null;

    /**
     * Very basic implementation of Retrofit
     */
    public static Retrofit getClient() {
        if (sRetrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            // Header interceptor initialization
            Interceptor headerInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Client-Based-Static-Header", "Client-Based static header value!")
                            .method(original.method(), original.body()).build();

                    return chain.proceed(request);
                }
            };

            // Logging interceptor initialization
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(Level.BASIC);

            // Attaching header interceptor
            httpClient.addInterceptor(headerInterceptor);
            // Attaching logging interceptor
            // Logging interceptor must be the last added interceptor.
            // Debug mode must be controlled when new loggin interceptor attached!
            httpClient.addInterceptor(loggingInterceptor);

            sRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                             .addConverterFactory(GsonConverterFactory.create())
                                             .client(httpClient.build())
                                             .build();
        }
        return sRetrofit;
    }
}