package cqdz.com.genius.mvpInterface;


import cqdz.com.genius.http.GeniusRequest;
import cqdz.com.genius.http.GeniusResponse;
import cqdz.com.genius.http.RetrofitServiceManager;
import cqdz.com.genius.http.api.APILogin;

/**
 * MVP Model基类
 * @param <T>
 */
public class MvpModel<T extends GeniusRequest,E extends GeniusResponse> {
    public static int RESPONSE_OK = 1;
    public static APILogin apiLogin=RetrofitServiceManager.getInstance().create(APILogin.class);
//    public static APIIndex apiIndex=RetrofitServiceManager.getInstance().create(APIIndex.class);
    public void getResponse(T t,final MvpCallback<E> callback){}
}
