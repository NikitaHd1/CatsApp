plugins {
    id(Plugins.androidApplication)
    id(Plugins.Kotlin.kotlinAndroid)
    id(Plugins.Kotlin.kotlinAndroidExtensions)
    kotlin("kapt")
    id(Plugins.safeArgs)
}

android {
    compileSdkVersion(AndroidSdk.targetSdkVersion)
    defaultConfig {
        applicationId = Versions.appId
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)

        versionCode = Versions.appVersionCode
        versionName = Versions.appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            buildConfigField("String", "BASE_URL", "\"https://api.thecatapi.com/v1/\"")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"https://api.thecatapi.com/v1/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    // StdLibs
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.ktxCore)
    implementation(Dependencies.constraintLayout)

    // Navigation
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUi)

    // Dagger
    implementation(Dependencies.Dagger.runtime)
    kapt(Dependencies.Dagger.compiler)
    implementation(Dependencies.Dagger.android)
    implementation(Dependencies.Dagger.support)
    kapt(Dependencies.Dagger.processor)

    // Okhttp
    implementation(Dependencies.Network.okHttp)
    implementation(Dependencies.Network.loggingInterceptor)

    // Room
    implementation(Dependencies.Database.Room.runtime)
    kapt(Dependencies.Database.Room.compiler)
    implementation(Dependencies.Database.Room.kotlin)
    implementation(Dependencies.Database.Room.rx)

    // RxJava
    implementation(Dependencies.Rx.java)
    implementation(Dependencies.Rx.android)
    implementation(Dependencies.Rx.kotlin)

    // Glide
    implementation(Dependencies.Glide.core)
    kapt(Dependencies.Glide.processor)
    implementation(Dependencies.Glide.okhttp3)

    compileOnly(Dependencies.Jetbrains.annotations)

    // Retrofit
    implementation(Dependencies.Network.Retrofit.core)
    implementation(Dependencies.Network.Retrofit.rx)
    implementation(Dependencies.Network.Retrofit.converter)

    // Tests
    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testExt)
    androidTestImplementation(TestLibraries.espresso)
    testCompileOnly(Dependencies.Jetbrains.annotations)
}
