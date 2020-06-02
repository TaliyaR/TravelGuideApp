package com.example.travelguide.ui.profile.add

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.travelguide.R
import com.example.travelguide.app.di.Injector
import com.example.travelguide.data.ViewModelFactory
import com.example.travelguide.data.db.model.Place
import kotlinx.android.synthetic.main.fragment_add_place.*
import javax.inject.Inject


class AddPlaceFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    var viewModel: AddPlaceViewModel? = null


    private var selectedImageUri: Uri? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Injector.plusAddMyPlaceComponent().inject(this)
        initViewModel()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    fun initClick() {
        btn_save.setOnClickListener {
            val name = et_name.text.toString()
            val address = et_address.text.toString()
            val description = et_description.text.toString()
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(address) || TextUtils.isEmpty(
                    description
                )
            ) {
                tv_error.text = "Введите данные"
                tv_error.visibility = View.VISIBLE
            } else {
                tv_error.visibility = View.INVISIBLE
                viewModel?.savePlace(
                    Place(
                        null, name, address, description, selectedImageUri.toString()
                    )
                )
                val navController = findNavController()

                navController.popBackStack()
            }
        }

        btn_photo.setOnClickListener {
            getImage()
        }
    }

    private fun getImage() {
        var intent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(intent, INPUT_FILE_REQUEST_CODE);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == INPUT_FILE_REQUEST_CODE) {
                selectedImageUri = data?.data
                Glide.with(this)
                    .load(Uri.parse(selectedImageUri.toString()))
                    .into(image)

            }
        }
    }

    private fun initViewModel() {
        this.viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(AddPlaceViewModel::class.java)
    }

    override fun onDestroy() {
        Injector.clearAddMyPlaceComponent()
        super.onDestroy()
    }

    companion object {
        const val INPUT_FILE_REQUEST_CODE = 1;
    }
}
