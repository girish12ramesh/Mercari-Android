package com.mercari.mercaritest;

import com.mercari.mercaritest.data.model.Response;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by girish on 09/16/2017.
 */

public interface Restapi {

    @GET("/posts")
    Observable<Response> getItems();

}
