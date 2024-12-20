plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.realm.kotlin)
    alias(libs.plugins.compose.compiler)
}

android {
    compileSdk = 35
    defaultConfig {
        applicationId = "com.madsam.otora"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release").configure {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    defaultConfig {
        namespace = "com.madsam.otora"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
}

dependencies {
    // Android X
    implementation(libs.androidx.constraintlayout.constraintlayout.compose)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.foundation)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.core.splashscreen)

    //Glance
    implementation(libs.androidx.glance.appwidget)
    // For interop APIs with Material 3
    implementation(libs.androidx.glance.material3)

    // Coil Image Loader
    implementation(libs.coil.kt.coil.compose)
    implementation(libs.coil.kt.coil.svg)
    implementation(libs.coil.gif)

    // Vico Graph
    implementation(libs.vico.compose)
    implementation(libs.vico.compose.m3)
    implementation(libs.vico.core)
    implementation(libs.vico.views)

    // BOM
    implementation(platform(libs.kotlin.bom))
    implementation(platform(libs.androidx.compose.compose.bom))
    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.themeadapter.material3)
    // Compose Screenshot
    implementation(libs.shreyaspatil.capturable)

    debugImplementation(libs.androidx.ui.tooling)

    // Realm
    implementation(libs.realm.library.base)

    // Moshi
    implementation(libs.moshi.kotlin)

    // Retrofit
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.adapter.rxjava)
    implementation(libs.squareup.converter.moshi)

    // UtilCode
    implementation(libs.utilcode)

    // JSoup
    implementation(libs.jsoup)
}