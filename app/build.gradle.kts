plugins {
    alias(libs.plugins.android.application)
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.oceanbyte.reefercontrol"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.oceanbyte.reefercontrol"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Room dependencies
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    // Navigation dependencies
    implementation ("androidx.navigation:navigation-fragment:2.7.7")
    implementation ("androidx.navigation:navigation-ui:2.7.7")
    
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    // For control over item selection of both touch and mouse driven selection
    implementation("androidx.recyclerview:recyclerview-selection:1.2.0")

    implementation ("com.google.android.material:material:1.11.0")

    // Для импорта с Exel
    implementation ("org.apache.poi:poi-ooxml:5.2.3") // Поддержка .xlsx
    implementation ("org.apache.poi:poi:5.2.3")
    implementation ("org.apache.commons:commons-collections4:4.4")
    implementation ("org.apache.xmlbeans:xmlbeans:5.1.1")
    implementation ("org.apache.commons:commons-compress:1.21")
    implementation ("org.apache.commons:commons-math3:3.6.1")

}