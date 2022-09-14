package com.vald3nir.smart_energy.data.dtos

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable

@Serializable
data class GoogleUserDTO(
    val userName: String?,
    val email: String?,
    val profileImageUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
        parcel.writeString(email)
        parcel.writeString(profileImageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GoogleUserDTO> {
        override fun createFromParcel(parcel: Parcel): GoogleUserDTO {
            return GoogleUserDTO(parcel)
        }

        override fun newArray(size: Int): Array<GoogleUserDTO?> {
            return arrayOfNulls(size)
        }
    }
}