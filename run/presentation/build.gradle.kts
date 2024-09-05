plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.dscoding.run.presentation"
}

dependencies {

    implementation(libs.coil.compose)
    implementation(libs.google.android.gms.play.services.location)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.run.domain)
}