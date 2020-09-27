package com.assignment.shaadi.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.assignment.shaadi.data.database.models.Dob
import com.assignment.shaadi.data.database.models.Location
import com.assignment.shaadi.data.database.models.Name
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by Chetan on 27/09/20.
 */

@BindingAdapter("set_picture")
fun setPicture(imageView: CircleImageView, picture: String?) {
    picture?.let {
        Glide.with(imageView.context)
            .load(picture)
            .fitCenter()
            .centerCrop()
            .into(imageView)
    }
}

@BindingAdapter("set_name")
fun setName(textView: TextView, name: Name?) {
    name?.let {
        textView.text = name.first + " " + name.last
    }
}

@BindingAdapter("set_age")
fun setAge(textView: TextView, dob: Dob?) {
    dob?.let {
        textView.text = dob.age.toString() + " years"
    }
}

@BindingAdapter("set_address")
fun setAddress(textView: TextView, location: Location?) {
    location?.let {
        textView.text = location.city + ", " + location.country
    }
}
