package client;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * 作者：zhizhiwei
 * 时间：2018/5/29 18:55
 * 描述：
 */
public interface UploadService {

    @Multipart
    @POST("uploadPhoto")
    Call<ResponseBody> uploadPhoto(@Part MultipartBody.Part photo, @Part("userName") RequestBody username, @Part("password") RequestBody password);

    @Multipart
    @POST("uploadFileDouble")
    Call<ResponseBody> uploadFileDouble(@PartMap Map<String, RequestBody> files);

    @Multipart
    @POST("UploadServlet")
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part photo,  @Query("type") String type);

}