package exts

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.kapt(list: List<String>) = addAll(
    configurationName = "kapt",
    list = list
)

fun DependencyHandler.kaptAndroidTest(list: List<String>) = addAll(
    configurationName = "kaptAndroidTest",
    list = list
)

fun DependencyHandler.implementations(list: List<String>) = addAll(
    configurationName = "implementation",
    list = list
)

fun DependencyHandler.androidTestImplementations(list: List<String>) = addAll(
    configurationName = "androidTestImplementation",
    list = list
)

fun DependencyHandler.testImplementations(list: List<String>) = addAll(
    configurationName = "testImplementation",
    list = list
)

private fun DependencyHandler.addAll(
    configurationName: String,
    list: List<String>
) = list.forEach {
    add(configurationName, it)
}
