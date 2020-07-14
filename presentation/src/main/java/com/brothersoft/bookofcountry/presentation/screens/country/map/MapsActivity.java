package com.brothersoft.bookofcountry.presentation.screens.country.map;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.brothersoft.bookofcountry.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.brothersoft.bookofcountry.presentation.utils.Extras.EXTRA_COUNTRY_CAPITAL_LAT;
import static com.brothersoft.bookofcountry.presentation.utils.Extras.EXTRA_COUNTRY_CAPITAL_LNG;
import static com.brothersoft.bookofcountry.presentation.utils.Extras.EXTRA_COUNTRY_FIELD_NAME;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String countryName;
    private double capitalLat;
    private double capitalLng;
    private AdView mAdView;


    public static Intent getIntent(Activity activity, String capital, double lat, double lng) {
        Intent intent = new Intent(activity, MapsActivity.class);
        intent.putExtra(EXTRA_COUNTRY_FIELD_NAME, capital);
        intent.putExtra(EXTRA_COUNTRY_CAPITAL_LAT, lat);
        intent.putExtra(EXTRA_COUNTRY_CAPITAL_LNG, lng);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        addBanner();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        countryName = getIntent().getExtras().getString(EXTRA_COUNTRY_FIELD_NAME);
        capitalLat = getIntent().getExtras().getDouble(EXTRA_COUNTRY_CAPITAL_LAT);
        capitalLng = getIntent().getExtras().getDouble(EXTRA_COUNTRY_CAPITAL_LNG);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng capitalLatLng = new LatLng(capitalLat, capitalLng);
        mMap.addMarker(new MarkerOptions().position(capitalLatLng).title(countryName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(capitalLatLng, 1f));
    }
    public void addBanner() {
        MobileAds.initialize(this,
                "ca-app-pub-7982947060816171~2298098731");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
