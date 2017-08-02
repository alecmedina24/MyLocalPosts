package com.applicastertest.alecmedina.mylocalposts.networking;

import com.applicastertest.alecmedina.mylocalposts.models.location.InstagramSearchModel;
import com.applicastertest.alecmedina.mylocalposts.models.media.MediaSearchModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by alec.medina on 7/27/17.
 */

public interface InstagramApi {

    String BASE_URL = "https://api.instagram.com/v1/";
    String INSTAGRAM_LOCATION = "locations/";
    String LOCATION_SEARCH = INSTAGRAM_LOCATION+"search";
    String POSTED_USER = "users/self/";
    String GET_MEDIA_CONTENT = "users/self/media/recent/";

    @GET(LOCATION_SEARCH)
    Observable<InstagramSearchModel> searchLocation(@Query("search") String location,
                                                    @Query("access_token") String token);

    @GET(GET_MEDIA_CONTENT)
    Observable<MediaSearchModel> getMediaForPost(@Query("access_token") String token);
}
