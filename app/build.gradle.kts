plugins {
    id("vald3nir.android.application")
    id("vald3nir.android.hilt")
    id("com.google.firebase.appdistribution")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 34
    namespace = "com.vald3nir.smart_energy"
    defaultConfig {
        applicationId = "com.vald3nir.myapplication"
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":commons"))
    // Modules
//    implementation(project(":features:onboarding"))
}