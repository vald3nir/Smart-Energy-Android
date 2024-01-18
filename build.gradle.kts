buildscript {
    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.google.services)
        classpath(libs.firebase.appdistribution.gradle)
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.application) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.safeNavigator) apply false
    alias(libs.plugins.serialization) apply false
}