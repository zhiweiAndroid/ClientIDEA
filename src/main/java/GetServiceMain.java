import client.GetService;
import client.base.HttpConfig;
import model.User;
import model.base.ListResponse;
import model.bean.PersonResult;
import model.bean.TestBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：chenZY
 * 时间：2018/5/29 22:01
 * 描述：Get 模式
 */
public class GetServiceMain {

    public static void main(String[] args) {
       // getUserInfo();
        postUserInfo();
    }

    private static void postUserInfo() {
        GetService getService = buildRetrofit().create(GetService.class);
        getService.getUserPost("贾静雯",39,"女").enqueue(new Callback<PersonResult>() {
            @Override
            public void onResponse(Call<PersonResult> call, Response<PersonResult> response) {
                if (response.isSuccessful()){
                    System.out.println("onResponse : " + response.toString());
                    PersonResult body = response.body();
                    System.out.println("onResponse body: " + body.toString());
                }else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<PersonResult> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });


    }

    private static void getUserInfo() {
        GetService getService = buildRetrofit().create(GetService.class);
        getService.getUser().enqueue(new Callback<TestBean>() {
            @Override
            public void onResponse(Call<TestBean> call, Response<TestBean> response) {
                if (response.isSuccessful()){
                    System.out.println("onResponse : " + response.toString());
                    TestBean body = response.body();
                    System.out.println("onResponse body: " + body.toString());
                }else {
                    System.out.println("onResponse code: " + response.code());
                }

            }

            @Override
            public void onFailure(Call<TestBean> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });

    }

    //Get请求时不会带任何自定义的参数与请求头，访问的链接是：/Get/getString
    private static void getNormal() {
        GetService getService = buildRetrofit().create(GetService.class);
        getService.getNormal().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        //返回的数据：{"code":1,"msg":"success","data":{"name":"leavesC","mobile":123456}}
                        System.out.println("onResponse body: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    //Get请求时会带上请求参数，参数将作为链接的后缀，生成的链接是：/Get/getString?name=leavesC&age=24
    private static void getWithQuery() {
        GetService getService = buildRetrofit().create(GetService.class);
        getService.getWithQuery("leavesC", 24).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        //返回的数据是：{"code":1,"msg":"success","data":{"name":"leavesC","mobile":123456}}
                        System.out.println("onResponse body: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    //将参数作为map传入，Get请求时会带上请求参数，参数将作为链接的后缀，生成的链接是：/Get/getString?name=leavesC&age=24
    private static void getWithMap() {
        GetService getService = buildRetrofit().create(GetService.class);
        Map<String, String> map = new HashMap<>();
        map.put("name", "leavesC");
        map.put("age", "24");
        getService.getWithMap(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        //返回的数据是：{"code":1,"msg":"success","data":{"name":"leavesC","mobile":123456}}
                        System.out.println("onResponse body: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    //Get请求时带上参数和固定请求头，参数将作为链接的后缀，生成的链接是：/Get/getString?name=leavesC&age=24
    //带上的Header的key是：userName，value是：leavesC
    private static void getWithQueryAndHeaders() {
        GetService getService = buildRetrofit().create(GetService.class);
        getService.getWithQueryAndHeaders("leavesC", 24).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        //返回的数据是：{"code":1,"msg":"success","data":{"name":"leavesC","mobile":123456}}
                        System.out.println("onResponse body: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    //Get请求时带上参数和非固定值的请求头，参数将作为链接的后缀，生成的链接是：/Get/getString?name=leavesC&age=24
    //带上的Header的key是：userName，value是：Hi
    private static void getWithQueryAndHeader() {
        GetService getService = buildRetrofit().create(GetService.class);
        getService.getWithQueryAndHeader("Hi", "leavesC", 24).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        //返回的数据是：{"code":1,"msg":"success","data":{"name":"leavesC","mobile":123456}}
                        System.out.println("onResponse body: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    //生成的链接是：/Get/getString/22
    private static void getWithPath() {
        GetService getService = buildRetrofit().create(GetService.class);
        getService.getWithPath(22).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        //返回的数据： {"code":1,"msg":"success","data":{"name":"leavesC_22","mobile":123456}}
                        System.out.println("onResponse body: " + response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    private static void getWithGsonConverter() {
        GetService getService = buildRetrofit().create(GetService.class);
        getService.getWithGsonConverter(24, 12).enqueue(new Callback<ListResponse<User>>() {
            @Override
            public void onResponse(Call<ListResponse<User>> call, Response<ListResponse<User>> response) {
                if (response.isSuccessful()) {
                    List<User> userList = response.body().getData();
                    if (userList == null) {
                        System.out.println("onResponse: userList == null");
                    } else {
                        for (User user : userList) {
                            System.out.println("onResponse: " + user);
                        }
                    }
                } else {
                    System.out.println("onResponse code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ListResponse<User>> call, Throwable t) {
                System.out.println("onFailure: " + t.getMessage());
            }
        });
    }

    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder().baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

}