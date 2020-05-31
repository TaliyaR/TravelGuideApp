//package com.example.travelguide.utils
//
//import android.Manifest
//import android.annotation.SuppressLint
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.location.Location
//import android.location.LocationManager
//import android.os.Looper
//import android.provider.Settings
//import android.widget.Toast
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat.getSystemService
//import androidx.core.content.ContextCompat.startActivity
//import com.google.android.gms.location.LocationCallback
//import com.google.android.gms.location.LocationRequest
//import com.google.android.gms.location.LocationResult
//import com.google.android.gms.location.LocationServices
//
//class Location(private val context: Context) {
//
//    //есть ли доступ к пермишенам
//    private fun checkPermissions(): Boolean {
//        if (ActivityCompat.checkSelfPermission(
//                context, Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED &&
//            ActivityCompat.checkSelfPermission(
//                context, Manifest.permission.ACCESS_COARSE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            return true
//        }
//        return false
//    }
//
//    //запрос разрешения
//    private fun requestPermissions() {
//        ActivityCompat.requestPermissions(
//            context, arrayOf(
//                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
//            ),
//            PERMISSION_ID
//        )
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        if (requestCode == PERMISSION_ID) {
//            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//            }
//        }
//    }
//
//    //проверка включена ли геолокация
//    private fun isLocationEnabled(): Boolean {
//        var locationManager: LocationManager =
//            getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
//            LocationManager.NETWORK_PROVIDER
//        )
//    }
//
//    //    @SuppressLint("MissingPermission")
//    private suspend fun getLastLocation() {
//        if (checkPermissions()) {
//            if (isLocationEnabled()) {
//                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
//                    var location: Location? = task.result
//                    if (location == null) {
//                        requestNewLocationData()
//                    } else {
//                        latitude = location.latitude
//                        longitude = location.longitude
//                    }
//                }
//            } else {
//                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show()
//                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
//                startActivity(intent)
//            }
//        } else {
//            requestPermissions()
//        }
//    }
//
//    //сохранение местоположения
//    private fun requestNewLocationData() {
//        var mLocationRequest = LocationRequest()
//        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        mLocationRequest.interval = 0
//        mLocationRequest.fastestInterval = 0
//        mLocationRequest.numUpdates = 1
//        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//        mFusedLocationClient.requestLocationUpdates(
//            mLocationRequest,
//            mLocationCallback,
//            Looper.myLooper()
//        )
//    }
//
//    //обноляем последние данные
//    private val mLocationCallback = object : LocationCallback() {
//        override fun onLocationResult(locationResult: LocationResult) {
//            var mLastLocation: Location = locationResult.lastLocation
//            latitude = mLastLocation.latitude
//            longitude = mLastLocation.longitude
//        }
//    }
//}
//
