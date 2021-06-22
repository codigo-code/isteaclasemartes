package edu.istea.model

import android.os.Parcelable
import android.widget.ImageView
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Helado(val nombre: String, val foto: Int) : Parcelable