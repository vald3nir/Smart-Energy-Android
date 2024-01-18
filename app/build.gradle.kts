import java.io.FileInputStream
import java.util.Properties

plugins {
    id("vald3nir.android.application")
    id("com.google.firebase.appdistribution")
    id("com.google.gms.google-services")
}

val keystorePropertiesFile = rootProject.file("toolkit/auth/keyStore.properties")
val keystoreProperties = Properties()
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android {
    signingConfigs {
        getByName("debug") {
            keyAlias = keystoreProperties.getProperty("keyAlias")
            keyPassword = keystoreProperties.getProperty("keyPassword")
            storeFile = file(keystoreProperties.getProperty("storeFile"))
            storePassword = keystoreProperties.getProperty("storePassword")
        }
        create("release") {
            keyAlias = keystoreProperties.getProperty("keyAlias")
            keyPassword = keystoreProperties.getProperty("keyPassword")
            storeFile = file(keystoreProperties.getProperty("storeFile"))
            storePassword = keystoreProperties.getProperty("storePassword")
        }
    }
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