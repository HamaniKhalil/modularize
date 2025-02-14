plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
}
kotlin {

    jvm()

    sourceSets {
        sourceSets.commonMain {
            kotlin.srcDir("src/commonMain")
        }

        commonMain.dependencies {
            implementation(projects.domain)

            implementation(libs.kotlin.datetime)
        }
    }
}
