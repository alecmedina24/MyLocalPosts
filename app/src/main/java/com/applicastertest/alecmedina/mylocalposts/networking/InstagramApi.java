package com.applicastertest.alecmedina.mylocalposts.networking;

import com.applicastertest.alecmedina.mylocalposts.models.location.InstagramSearchModel;
import com.applicastertest.alecmedina.mylocalposts.models.media.MediaSearchModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.applicastertest.alecmedina.mylocalposts.Constants.GET_MEDIA_CONTENT;
import static com.applicastertest.alecmedina.mylocalposts.Constants.LOCATION_SEARCH;
import static com.applicastertest.alecmedina.mylocalposts.Constants.USER_AUTH;

/**
 * Created by alec.medina on 7/27/17.
 */

public interface InstagramApi {

    @GET(LOCATION_SEARCH)
    Observable<InstagramSearchModel> searchLocation(@Query("search") String location,
                                                    @Query("distance") String distance,
                                                    @Query("access_token") String token);

    @GET(GET_MEDIA_CONTENT)
    Observable<MediaSearchModel> getMediaForPost(@Path("location_id") String locationId,
                                                 @Query("access_token") String token);

    @GET(USER_AUTH)
    Observable<InstagramSearchModel> getUserAuth();
}
