group = "com.plms"
version = "0.01"

plugins {
    id("application")
	id("org.openjfx.javafxplugin") version "0.1.0" 
}

javafx {
		version = "21.0.5"
		modules = listOf("javafx.controls", "javafx.fxml")
}

repositories {
    mavenCentral()
}

dependencies {
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass.set("com.plms.Main")
}

tasks.named<JavaExec>("run") {
		standardInput = System.`in` // allow terminal input
}
