plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
}

version = "1.0-SNAPSHOT"

kotlin {
    android()

    jvm("desktop")

    ios()
    iosSimulatorArm64()

    js(IR) {
        browser()
    }
    wasm {
        browser()
    }

    // TODO: uncomment. Commented to simplify running other targets on machines w/o the env cocoapods setup
//    cocoapods {
//        summary = "Shared code for the sample"
//        homepage = "https://github.com/JetBrains/compose-jb"
//        ios.deploymentTarget = "14.1"
//        podfile = project.file("../iosApp/Podfile")
//        framework {
//            baseName = "shared"
//            isStatic = true
//        }
//        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
//    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)
                implementation("org.jetbrains.compose.components:components-resources:1.3.0-dev-wasm-02")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.5.1")
                implementation("androidx.core:core-ktx:1.8.0")
            }
        }
        val iosMain by getting
        val iosTest by getting
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Test by getting {
            dependsOn(iosTest)
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
            }
        }

        val jsWasmMain by creating {
            dependsOn(commonMain)
        }

        val jsMain by getting {
            dependsOn(jsWasmMain)
        }
        val wasmMain by getting {
            dependsOn(jsWasmMain)
        }
    }
}

project.afterEvaluate {
    //Disable jsWasmMain intermediate sourceset compilation
    tasks.named("compileJsWasmMainKotlinMetadata") {
        enabled = false
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res", "src/commonMain/resources")
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
