plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId  = "com.svetlana.learn.daggerwithrozov"
        minSdk = 30
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinCompile::class).all{
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjvm-default=compatibility")
        }
    }
}

val daggerVersion = "2.36"
val retrofitVersion = "2.9.0"
val archComponents = "2.5.0-beta01"

dependencies {

    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0-beta01")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.0-beta01")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.5.0-beta01")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0-beta01")

    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation("androidx.activity:activity-ktx:1.4.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.4.6")

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}