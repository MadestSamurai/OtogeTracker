plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.navigation.safe.args)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.objectbox)
}

android {
    namespace = "com.madsam.otora"
    compileSdk = 36
    
    defaultConfig {
        applicationId = "com.madsam.otora"
        minSdk = 27
        targetSdk = 36
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
    
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}

// 解决 ObjectBox 依赖冲突
configurations {
    all {
        resolutionStrategy {
            eachDependency {
                if (requested.group == "io.objectbox" && requested.name == "objectbox-android") {
                    // 在debug配置中，用objectbox-android-objectbrowser替代objectbox-android
                    if (name.contains("debug", ignoreCase = true)) {
                        useTarget("io.objectbox:objectbox-android-objectbrowser:${requested.version}")
                        because("objectbox-android-objectbrowser包含完整的Android支持+Admin工具")
                    }
                }
            }
        }
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
    implementation(libs.androidx.datastore.preferences)

    // Glance
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

    // DateTimePicker
    implementation(libs.composedatepicker)

    // BOM
    implementation(platform(libs.kotlin.bom))
    implementation(platform(libs.androidx.compose.compose.bom))
    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.themeadapter.material3)
    // Material Icons Extended (解决第三方库依赖问题)
    implementation(libs.androidx.compose.material.icons.extended)
    // Compose Screenshot
    implementation(libs.shreyaspatil.capturable)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.ui.android)
    // Compose Shimmer
    implementation(libs.compose.shimmer)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.compose.animation)

    debugImplementation(libs.androidx.ui.tooling)

    // ObjectBox
    implementation(libs.objectbox.kotlin)
    implementation(libs.objectbox.android)
    debugImplementation(libs.objectbox.android.objectbrowser)

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
    
    // Ksoup (Kotlin HTML parser)
    implementation(libs.ksoup)
}