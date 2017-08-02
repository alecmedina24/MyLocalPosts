package com.applicastertest.alecmedina.mylocalposts.posts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.applicastertest.alecmedina.mylocalposts.R;
import com.applicastertest.alecmedina.mylocalposts.auth.InstagramAuthActivity;
import com.applicastertest.alecmedina.mylocalposts.models.PostModel;
import com.applicastertest.alecmedina.mylocalposts.models.location.InstagramSearchModel;
import com.applicastertest.alecmedina.mylocalposts.models.location.LocationData;
import com.applicastertest.alecmedina.mylocalposts.models.media.MediaData;
import com.applicastertest.alecmedina.mylocalposts.models.media.MediaSearchModel;
import com.applicastertest.alecmedina.mylocalposts.networking.InstagramUtils;
import com.applicastertest.alecmedina.mylocalposts.posts.adapters.InstagramPostAdapter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

import static com.applicastertest.alecmedina.mylocalposts.auth.InstagramAuthActivity.ACCESS_TOKEN_VALUE;
import static com.applicastertest.alecmedina.mylocalposts.networking.InstagramUtils.MAP_PERMISSIONS;

public class MainActivity extends AppCompatActivity implements InstagramUtils.NetworkCallBacks {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static int searchDistance = 500;

    private ArrayList<LocationData> locationDatas;
    private ArrayList<MediaData> mediaDatas;
    private ArrayList<PostModel> posts;
    private RecyclerView listView;
    private InstagramPostAdapter adapter;
    private FusedLocationProviderClient fusedLocationClient;
    private InstagramUtils instagramUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (RecyclerView) findViewById(R.id.list);

        locationDatas = new ArrayList<>();
        mediaDatas = new ArrayList<>();
        posts = new ArrayList<>();

        adapter = new InstagramPostAdapter(this, posts);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(adapter);

        Intent intent = new Intent(this, InstagramAuthActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            getInstagramPosts(data.getStringExtra(ACCESS_TOKEN_VALUE));
        }
    }

    private void getInstagramPosts(String token) {
        instagramUtils = new InstagramUtils(this, this, token);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        instagramUtils.getPostMedia();
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
        if (instagramSearchModel.data().size() < 10) {
            searchDistance += 150;
            instagramUtils.getPostAroundUserLocation(this, fusedLocationClient, String.valueOf(searchDistance));
        } else {
            locationDatas.addAll(instagramSearchModel.data());
            getMediaDataForPosts();
        }
    }

    @Override
    public void mediaPostCallback(MediaSearchModel mediaSearchModel) {
        List<MediaData> data = mediaSearchModel.data();
        for (MediaData mediaData : data) {
            PostModel post = new PostModel(mediaData.user().username(), null, null, null);
            posts.add(post);
        }
        adapter.notifyDataSetChanged();
    }

    private void getMediaDataForPosts() {
            instagramUtils.getPostMedia();
    }
}
