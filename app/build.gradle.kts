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
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}

dependencies {
    val fileTree: Map<String, Any> = mapOf(
        "dir" to "libs",
        "include" to listOf("*.jar")
    )

    val kotlinVersion: String = Versions.KOTLIN
    val appCompatVersion: String = Versions.APP_COMPAT
    val fragmentVersion: String = Versions.FRAGMENT

    val lifecycleVersion: String = Versions.LIFECYCLE
    val coroutinesVersion: String = Versions.COROUTINES

    val hiltVersion: String = Versions.HILT
    val hiltAndroidVersion: String = Versions.HILT_ANDROID

    val navigationVersion: String = Versions.NAVIGATION
    val materialVersion: String = Versions.MATERIAL

    val retrofitVersion: String = Versions.RETROFIT
    val retrofitLoggerVersion: String = Versions.RETROFIT_LOGGER

    val serializationVersion: String = Versions.SERIALIZATION
    val serializationConverterVersion: String = Versions.SERIALIZATION_CONVERTER

    val fragmentTestVersion: String = Versions.FRAGMENT_TEST
    val junitVersion: String = Versions.JUNIT

    val testVersion: String = Versions.TEST
    val junitTestVersion: String = Versions.JUNIT_TEST
    val espressoVersion: String = Versions.ESPRESSO

    implementation(fileTree(fileTree))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:$hiltAndroidVersion")

    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    implementation("com.google.android.material:material:$materialVersion")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$retrofitLoggerVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$serializationConverterVersion")

    debugImplementation("androidx.fragment:fragment-testing:$fragmentTestVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")

    androidTestImplementation("androidx.test:core-ktx:$testVersion")
    androidTestImplementation("androidx.test.ext:junit-ktx:$junitTestVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")

    androidTestImplementation("com.google.dagger:hilt-android-testing:$hiltVersion")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:$hiltVersion")
}
