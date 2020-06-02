package com.example.travelguide.utils

import android.content.Context
import android.location.Location
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object LocationUtils {

    private var fusedLocationProviderClient: FusedLocationProviderClient?= null

    private var location : MutableLiveData<Location> = MutableLiveData()

    fun getInstance(appContext: Context): FusedLocationProviderClient{
        if(fusedLocationProviderClient == null)
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(appContext)
        return fusedLocationProviderClient!!
    }

    fun getLocation() : LiveData<Location> {
        fusedLocationProviderClient!!.lastLocation
            .addOnSuccessListener {loc: Location? ->
                location.value = loc
            }
        return location
    }

//    fun getLocation() : String{
//        fusedLocationProviderClient!!.lastLocation.result
//    }
}
