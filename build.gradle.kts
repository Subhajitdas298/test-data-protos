plugins {
    java
    `maven-publish`
    id("com.google.protobuf") version "0.9.4"
}

group = "com.github.subhajitdas298"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
    withSourcesJar()
    withJavadocJar()
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name.set("test-data-protos")
                description.set("Java protobuf definitions for test-data-protos")
                url.set("https://github.com/Subhajitdas298/test-data-protos")
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Subhajitdas298/test-data-protos")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
