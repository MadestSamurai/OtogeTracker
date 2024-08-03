plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    alias(libs.plugins.compose.compiler)
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "com.madsam.otora"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] = "$projectDir/schemas"
                arguments["room.incremental"] = "true"
                arguments["room.expandProjection"] = "true"
            }
        }
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    defaultConfig {
        namespace = "com.madsam.otora"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Android X
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout.constraintlayout.compose)
    implementation(libs.androidx.material3)
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
    // Vico
    implementation(libs.vico.compose)
    implementation(libs.vico.compose.m3)
    implementation(libs.vico.core)
    implementation(libs.vico.views)
    // BOM
    implementation(platform(libs.kotlin.bom))
    implementation(platform(libs.androidx.compose.compose.bom))
    //Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.themeadapter.material3)

    debugImplementation(libs.androidx.ui.tooling)

    // Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    // optional - RxJava2 support for Room
    implementation(libs.androidx.room.rxjava2)
    // optional - RxJava3 support for Room
    implementation(libs.androidx.room.room.rxjava3)
    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation(libs.androidx.room.room.guava)
    // optional - Test helpers
    testImplementation(libs.androidx.room.room.testing3)
    // optional - Paging 3 Integration
    implementation(libs.androidx.room.paging)

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

    // Jsoup
    implementation(libs.jsoup)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}