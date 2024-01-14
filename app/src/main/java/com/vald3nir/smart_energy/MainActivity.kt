package com.vald3nir.smart_energy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vald3nir.commons.views.BaseActivity


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showLoading(true)


//        val test : Float? = "123".toFloatValueNullable()

    }
}