plugins {
    id("vald3nir.android.feature")
}

android {
    namespace = "com.vald3nir.onboarding"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // Modules
    implementation(project(":commons"))
    // Google Login
    implementation("com.google.android.gms:play-services-auth:20.7.0")
}