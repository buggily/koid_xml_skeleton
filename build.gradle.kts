buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        val gradleVersion: String = Versions.GRADLE
        val kotlinVersion: String = Versions.KOTLIN

        val hiltVersion: String = Versions.HILT
        val navigationVersion: String = Versions.NAVIGATION

        classpath("com.android.tools.build:gradle:$gradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")

        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
