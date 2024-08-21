plugins {
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {
    androidLibrary {
        namespace = "com.example.shared"
        compileSdk = 34
        minSdk = 24

        withAndroidTestOnJvmBuilder {
            compilationName = "unitTest"
            defaultSourceSetName = "androidUnitTest"
        }

        withAndroidTestOnDeviceBuilder {
            compilationName = "instrumentedTest"
            defaultSourceSetName = "androidInstrumentedTest"
            sourceSetTreeName = "test"
        }
    }
    sourceSets {
        getByName("androidMain") {
            dependencies {
                // put your android target dependencies here
            }
        }
        getByName("androidInstrumentedTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.junit)
            }
        }
        commonMain {
            dependencies {
                // put your common multiplatform dependencies here
            }
        }
        commonTest {
            dependencies {
                implementation(libs.junit)
            }
        }
    }
}