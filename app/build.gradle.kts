plugins {
    id("com.android.application")

    kotlin("android")
    kotlin("kapt")

    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    compileSdkVersion(Build.Versions.COMPILE_SDK)

    defaultConfig {
        applicationId = Build.APPLICATION_ID

        targetSdkVersion(Build.Versions.TARGET_SDK)
        minSdkVersion(Build.Versions.MIN_SDK)

        versionCode = Build.Versions.CODE
        versionName = Build.Versions.NAME

        testInstrumentationRunner = Build.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)

            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
}

dependencies {
    implementation(fileTree(Dependencies.fileTree))

    val hiltVersion: String = Versions.HILT
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:$hiltVersion")

    implementation(Dependencies.implementations)
    debugImplementation(Dependencies.debugImplementations)
    testImplementation(Dependencies.testImplementations)
    androidTestImplementation(Dependencies.androidTestImplementations)
}
