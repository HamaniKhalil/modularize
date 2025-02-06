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
            implementation(libs.kotlin.datetime)
        }
    }
}
