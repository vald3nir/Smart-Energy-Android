plugins {
    id("vald3nir.android.application")
    id("com.google.firebase.appdistribution")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.vald3nir.smart_energy"
    defaultConfig {
        applicationId = "com.vald3nir.smart_energy"
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        debug {
//            applicationIdSuffix = ".debug"
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
    // Modules
    implementation(project(":commons"))
    implementation(project(":features:home"))
    implementation(project(":features:onboarding"))
}