object Dependencies {

    val fileTree: Map<String, Any>
        get() = mapOf(
            "dir" to "libs",
            "include" to listOf("*.jar")
        )

    val implementations: List<String>
        get() {
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

            return listOf(
                "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion",

                "androidx.appcompat:appcompat:$appCompatVersion",
                "androidx.fragment:fragment-ktx:$fragmentVersion",

                "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion",
                "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion",

                "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion",
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion",

                "com.google.dagger:hilt-android:$hiltVersion",
                "androidx.hilt:hilt-lifecycle-viewmodel:$hiltAndroidVersion",

                "androidx.navigation:navigation-fragment-ktx:$navigationVersion",
                "androidx.navigation:navigation-ui-ktx:$navigationVersion",
                "com.google.android.material:material:$materialVersion",

                "com.squareup.retrofit2:retrofit:$retrofitVersion",
                "com.squareup.okhttp3:logging-interceptor:$retrofitLoggerVersion",

                "org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion",
                "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$serializationConverterVersion"
            )
        }

    val debugImplementations: List<String>
        get() {
            val fragmentTestVersion: String = Versions.FRAGMENT_TEST

            return listOf(
                "androidx.fragment:fragment-testing:$fragmentTestVersion"
            )
        }

    val testImplementations: List<String>
        get() {
            val junitVersion: String = Versions.JUNIT
            val coroutinesVersion: String = Versions.COROUTINES

            return listOf(
                "org.junit.jupiter:junit-jupiter:$junitVersion",
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"
            )
        }

    val androidTestImplementations: List<String>
        get() {
            val testVersion: String = Versions.TEST
            val junitTestVersion: String = Versions.JUNIT_TEST
            val espressoVersion: String = Versions.ESPRESSO

            val hiltVersion: String = Versions.HILT

            return listOf(
                "androidx.test:core-ktx:$testVersion",
                "androidx.test.ext:junit-ktx:$junitTestVersion",
                "androidx.test.espresso:espresso-core:$espressoVersion",

                "com.google.dagger:hilt-android-testing:$hiltVersion",
                "com.google.dagger:hilt-android-compiler:$hiltVersion"
            )
        }
}