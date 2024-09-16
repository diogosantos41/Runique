plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.dscoding.analytics.presentation"
}

dependencies {

    implementation(projects.analytics.domain)
}