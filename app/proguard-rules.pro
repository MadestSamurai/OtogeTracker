# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep data model classes
-keep class com.madsam.otora.data.model.web.** { *; }

# Suppress R8 warnings for kotlinx-serialization
-dontwarn kotlinx.serialization.**

# Keep Moshi JSON adapters
-keep class com.squareup.moshi.** { *; }
-keep @com.squareup.moshi.JsonClass class * { *; }
-keepclassmembers class * {
    @com.squareup.moshi.Json <fields>;
}

# Keep Retrofit service interfaces
-keep interface com.madsam.otora.data.**.api.** { *; }

# Keep data transfer objects (DTOs)
-keep class com.madsam.otora.data.**.model.** { *; }
-keep class com.madsam.otora.data.**.remote.model.** { *; }

# Keep entity classes for Realm
-keep class com.madsam.otora.data.**.local.model.** { *; }