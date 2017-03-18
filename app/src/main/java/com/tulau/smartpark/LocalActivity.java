package com.tulau.smartpark;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class LocalActivity extends Fragment implements OnMapReadyCallback
        , GoogleApiClient.OnConnectionFailedListener {


    public String lcSearch;
    private GoogleMap mMap;
    Geocoder geocoder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_local, container, false);

        searchmap();
        return rootView;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        //mMap = googleMap;
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(10.801413, 106.714528))
//                .title("Hello world"));
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }


    private void searchmap() {
        //mMap.clear();
        //lcSearch = etSearch.getText().toString();
        String location = "475 Dien bien phu";
        //lcSearch;

        if (location != null && !location.equals("")) {
            List<Address> lstAddress = null;
            try {
                lstAddress = geocoder.getFromLocationName(location, 1);
                System.out.print(lstAddress);
                if (lstAddress != null) {
                    double lat = lstAddress.get(0).getLatitude();
                    double lng = lstAddress.get(0).getLongitude();
                    LatLng latLng = new LatLng(lat, lng);
                    goToMaps(latLng);
                } else {

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void goToMaps(LatLng latLng) {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 18);
        mMap.addMarker(new MarkerOptions().position(latLng).title("HUTECH"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(cameraUpdate);
    }


}
