package com.applicastertest.alecmedina.mylocalposts.networking;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.applicastertest.alecmedina.mylocalposts.BaseService;
import com.applicastertest.alecmedina.mylocalposts.models.location.InstagramSearchModel;
import com.applicastertest.alecmedina.mylocalposts.models.media.MediaSearchModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;
import static com.applicastertest.alecmedina.mylocalposts.Constants.CLIENT_ID;

/**
 * Created by alec.medina on 7/28/17.
 */

public class NetworkUtils {

    public final static String[] MAP_PERMISSIONS = new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    private NetworkCallBacks callback;
    private Context context;

    public interface NetworkCallBacks {
        void mediaPostCallback(MediaSearchModel mediaSearchModel);
        void locationSearchCallback(InstagramSearchModel instagramSearchModel);
    }

    public NetworkUtils(Context context, NetworkCallBacks callback) {
        this.callback = callback;
        this.context = context;
    }

    public void getPostMedia(String locationId) {
        BaseService.getInstance()
                .getInstagramApi()
                .getMediaForPost(locationId, CLIENT_ID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MediaSearchModel>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted() called");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError() called with: e = [" + e + "]");
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
                            .searchLocation(buildLatLngQuery(location), distance, CLIENT_ID)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(new Subscriber<InstagramSearchModel>() {
                                @Override
                                public void onCompleted() {
                                    Log.d(TAG, "onCompleted() called");
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.d(TAG, "onError() called with: e = [" + e + "]");
                                }

                                @Override
                                public void onNext(InstagramSearchModel instagramSearchModel) {
                                    Log.d(TAG, "onNext() called with: instagramSearchModel = [" + instagramSearchModel + "]");
                                    callback.locationSearchCallback(instagramSearchModel);
                                }
                            });
                }
            });
        }
    }

    private String buildLatLngQuery(Location location) {
        return "lat=" + location.getLatitude() + "lng=" + location.getLongitude();
    }
}
