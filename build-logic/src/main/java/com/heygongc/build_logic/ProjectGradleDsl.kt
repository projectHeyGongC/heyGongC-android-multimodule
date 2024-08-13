package com.heygongc.build_logic

import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import java.util.Optional

internal fun <T : Any> DependencyHandlerScope.implementation(
    dependencyNotation: Optional<org.gradle.api.provider.Provider<T>>
) {
    implementation(dependencyNotation.get())
}

internal fun DependencyHandlerScope.implementation(
    dependencyNotation: Any
) {
    dependencies.add("implementation", dependencyNotation)
}

internal fun DependencyHandlerScope.ksp(
    dependencyNotation: Any
) {
    dependencies.add("ksp", dependencyNotation)
}

internal fun <T : Any> DependencyHandlerScope.ksp(
    dependencyNotation: Optional<Provider<T>>
) {
    ksp(dependencyNotation.get())
}