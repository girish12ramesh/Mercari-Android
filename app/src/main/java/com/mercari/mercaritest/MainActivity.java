package com.mercari.mercaritest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mercari.mercaritest.data.model.HomeResponse;
import com.mercari.mercaritest.data.model.Response;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    HomeResponse homeResponse;
    String responseData = null;
    Response mResponse;
    RecyclerView dataList;
    ProductAdapter productAdapter;
    private boolean mIsNetWorkCall = false;
    private final String TAG ="MainActivity";


    @Inject
    Retrofit retrofit;

    @Inject
    Gson mGson;

    @Inject
    Context mCtx;

    @Inject
    Context bCtx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MercariApp)getApplication()).getNetComponent().inject(this);
        Toast.makeText(mCtx," Sow toast",Toast.LENGTH_LONG).show();


        dataList = (RecyclerView) findViewById(R.id.data_list);
        dataList.setLayoutManager(new GridLayoutManager(this,2));

        homeResponse = new HomeResponse();
        responseData = homeResponse.responseData(this);

        lodeDataModule();
    }

    private void loadDataFromAssets(){

        mResponse =homeResponse.getResponse(this,mGson);
        if(mResponse!=null){
            setDatpter(mResponse);
        }else{
            Toast.makeText(getApplicationContext()," Error ",Toast.LENGTH_SHORT).show();
            Log.e(TAG," Error No Data Found ");
        }

    }

    private void lodeDataModule() {

        if(mIsNetWorkCall) {
            performNetWorkCall();
            return;
        }else{
            loadDataFromAssets();
        }

    }

    private void performNetWorkCall(){
        // If we use Retrofit without Rx Java, we can use this implementation
        // Retrofit
/*
       Call<Response> api = retrofit.create(Restapi.class).getItems();
        api.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                mResponse= response.body();
                if(mResponse!=null&&mResponse.getResult().equalsIgnoreCase("ok")){
                    setDatpter(mResponse);

                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                     Toast.makeText(getApplicationContext()," Error "+t.toString(),Toast.LENGTH_LONG).show();
            }
        });
*/
        //RxJava -Observer, Observable, Subscriber,Sechedulers
        Restapi service=null;
        service.getItems().subscribeOn(Schedulers.newThread())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response response) {

            }
        });



    }




    private void setDatpter(Response responseData){
        productAdapter = new ProductAdapter(this,responseData);
        dataList.setAdapter(productAdapter);
    }
}
