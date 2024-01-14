plugins {
    id("vald3nir.android.feature")
    alias(libs.plugins.kotlin)
}

android {
    namespace = "com.vald3nir.commons"
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
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
}

dependencies {
    // Modules
    implementation(project(mapOf("path" to ":toolkit:core")))
//    implementation(project(":toolkit:core"))
}