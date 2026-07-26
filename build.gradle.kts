plugins {
    java
    id("com.google.protobuf") version "0.9.4"
}

group = "com.github.subhajitdas298"
version = "1.0.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val protobufVersion = "4.31.1"

dependencies {
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }
}

sourceSets {
    main {
        proto {
            srcDir("proto")
        }
    }
}
