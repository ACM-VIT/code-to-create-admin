package acm.event.code2createadmin.RetroAPI;

/**
 * Created by Sourish on 13-04-2017.
 */

import com.google.gson.JsonObject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public class RetroAPI{
    final String baseUrl = "http://androidc2cc.herokuapp.com/";

    public interface ObservableAPIService {
        @FormUrlEncoded
        @POST("coupon/redeem")
        Observable<JsonObject> redeemCoupon (
                @Field("coupon_type") String type,
                @Field("id") String id,
                @Field("adminId") String adminId
        );

        @FormUrlEncoded
        @POST("coupon/revert")
        Observable<JsonObject> revertCoupon (
                @Field("coupon_type") String type,
                @Field("id") String id,
                @Field("adminId") String adminId
        );
    }

    public ObservableAPIService observableAPIService = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(ObservableAPIService.class);
}

