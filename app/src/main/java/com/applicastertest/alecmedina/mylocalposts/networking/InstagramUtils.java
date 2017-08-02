package com.applicastertest.alecmedina.mylocalposts.networking;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.applicastertest.alecmedina.mylocalposts.models.location.InstagramSearchModel;
import com.applicastertest.alecmedina.mylocalposts.models.media.MediaSearchModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alec.medina on 7/28/17.
 */

public class InstagramUtils {

    public final static String[] MAP_PERMISSIONS = new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    private static String TAG = InstagramUtils.class.getSimpleName();

    private NetworkCallBacks callback;
    private Context context;
    private String AuthenticationToken;

    public interface NetworkCallBacks {
        void mediaPostCallback(MediaSearchModel mediaSearchModel);
        void locationSearchCallback(InstagramSearchModel instagramSearchModel);
    }

    public InstagramUtils(Context context, NetworkCallBacks callback, String authenticationToken) {
        this.callback = callback;
        this.context = context;
        this.AuthenticationToken = authenticationToken;
    }

    public void getPostMedia() {
        BaseService.getInstance()
                .getInstagramApi()
                .getMediaForPost(AuthenticationToken)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MediaSearchModel>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted() called");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getPostMedia", "onError() called with: e = [" + e + "]");
                        Toast.makeText(context, "Error fetching media for post", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(MediaSearchModel mediaSearchModel) {
                        Log.d(TAG, "onNext() called with: mediaSearchModel = [" + mediaSearchModel + "]");
                        callback.mediaPostCallback(mediaSearchModel);
                    }
                });
    }

    public void getPostAroundUserLocation(AppCompatActivity activity, FusedLocationProviderClient locationClient, final String distance) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, MAP_PERMISSIONS, 0);
        } else {
            locationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    BaseService.getInstance()
                            .getInstagramApi()
                            .searchLocation(buildLatLngQuery(location), AuthenticationToken)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(new Subscriber<InstagramSearchModel>() {
                                @Override
                                public void onCompleted() {
                                    Log.d(TAG, "onCompleted() called");
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.e("getPostAroundUser", "onError() called with: e = [" + e + "]");
                                    Toast.makeText(context, "Error fetching post around location", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onNext(InstagramSearchModel instagramSearchModel) {
                                    Log.d("getPostAroundUser", "onNext() called with: instagramSearchModel = [" + instagramSearchModel + "]");
                                    callback.locationSearchCallback(instagramSearchModel);
                                }
                            });
                }
            });
        }
    }

    private String buildLatLngQuery(Location location) {
        return "lat=" + location.getLatitude() + "&" + "lng=" + location.getLongitude();
    }
}
