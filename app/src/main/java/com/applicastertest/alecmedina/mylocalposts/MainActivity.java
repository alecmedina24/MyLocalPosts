package com.applicastertest.alecmedina.mylocalposts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.applicastertest.alecmedina.mylocalposts.adapters.InstagramPostAdapter;
import com.applicastertest.alecmedina.mylocalposts.models.PostModel;
import com.applicastertest.alecmedina.mylocalposts.models.location.InstagramSearchModel;
import com.applicastertest.alecmedina.mylocalposts.models.location.LocationData;
import com.applicastertest.alecmedina.mylocalposts.models.media.MediaData;
import com.applicastertest.alecmedina.mylocalposts.models.media.MediaSearchModel;
import com.applicastertest.alecmedina.mylocalposts.networking.InstagramUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.applicastertest.alecmedina.mylocalposts.networking.InstagramUtils.MAP_PERMISSIONS;

public class MainActivity extends AppCompatActivity implements InstagramUtils.NetworkCallBacks {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static int searchDistance = 500;

    private ArrayList<LocationData> locationDatas;
    private ArrayList<MediaData> mediaDatas;
    private ArrayList<PostModel> posts;
    private InstagramPostAdapter adapter;
    private FusedLocationProviderClient fusedLocationClient;
    private InstagramUtils instagramUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listView = (RecyclerView) findViewById(R.id.list);

        locationDatas = new ArrayList<>();
        mediaDatas = new ArrayList<>();

        adapter = new InstagramPostAdapter(this, posts);

        listView.setAdapter(adapter);

        logInUser();

//        getInstagramPosts();
    }

    private void logInUser() {
        BaseService.getInstance()
                .getInstagramApi()
                .getUserAuth()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<InstagramSearchModel>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted() called");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError() called with: e = [" + e + "]");
                    }

                    @Override
                    public void onNext(InstagramSearchModel instagramSearchModel) {
                        Log.d(TAG, "onNext() called with: instagramSearchModel = [" + instagramSearchModel + "]");
                    }
                });
    }

    private void getInstagramPosts() {
        instagramUtils = new InstagramUtils(this, this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        instagramUtils.getPostAroundUserLocation(this, fusedLocationClient, String.valueOf(searchDistance));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == MAP_PERMISSIONS.length) {
            instagramUtils.getPostAroundUserLocation(this, fusedLocationClient, String.valueOf(searchDistance));
        }
    }

    @Override
    public void locationSearchCallback(InstagramSearchModel instagramSearchModel) {
        if (instagramSearchModel.getData().size() < 10) {
            searchDistance += 150;
            instagramUtils.getPostAroundUserLocation(this, fusedLocationClient, String.valueOf(searchDistance));
        } else {
            locationDatas.addAll(instagramSearchModel.getData());
            getMediaDataForPosts();
        }
    }

    @Override
    public void mediaPostCallback(MediaSearchModel mediaSearchModel) {
        mediaDatas.addAll(mediaSearchModel.getData());
    }

    private void getMediaDataForPosts() {
        for (LocationData data : locationDatas) {
            instagramUtils.getPostMedia(data.getId());
        }

        buildPostData();
    }

    private void buildPostData() {
        if (mediaDatas.size() == locationDatas.size()) {
            for (int i = 0; i < mediaDatas.size(); i++) {
                MediaData mediaData = mediaDatas.get(i);
                LocationData locationData = locationDatas.get(i);

//                PostModel postModel = new PostModel(mediaData.getUser().getUsername(),"");
            }
        }
        adapter.notifyDataSetChanged();
    }
}
