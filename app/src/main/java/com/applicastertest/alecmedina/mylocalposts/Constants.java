package com.applicastertest.alecmedina.mylocalposts;

/**
 * Created by alec.medina on 7/27/17.
 */

public class Constants {

    public static final String BASE_URL = "https://api.instagram.com/v1/";
    public static final String REDIRECT_URL = "http://github.com/alecmedina24";
    public static final String INSTAGRAM_LOCATION = "locations/";

    public static final String CLIENT_ID = "ed27a91d56534c72a18d62a46121efe0";

    public static final String LOCATION_SEARCH = INSTAGRAM_LOCATION+"search";
    public static final String POSTED_USER = "users/self/";
    public static final String GET_MEDIA_CONTENT = "{location_id}/media/recent";
    public static final String USER_AUTH = "https://api.instagram.com/oauth/authorize/?client_id="
            + CLIENT_ID + "&redirect_uri=https://github.com/alecmedin24&response_type=token";
}
