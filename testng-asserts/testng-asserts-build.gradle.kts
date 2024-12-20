plugins {
    id("testng.java-library")
    id("maven-publish")
}

group = "org.testng" 
version = "7.8.0"
description = "TestNG Assertions Library"

dependencies {
    implementation(projects.testngCollections) {
        because("Lists.newArrayList")
    }

    testImplementation("org.testng:testng:7.3.0") {
        because("we need testng to test assertions")
    }
    testImplementation(projects.testngTestKit)
}



publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                name = "TestNG Assertions"
                description = "Assertions library for TestNG"
                url = "https://testng.org"
                licenses {
                    license {
                        name = "Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "testng-developers"
                        name = "TestNG Developers"
                        email = "testng-dev@googlegroups.com"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/testng-team/testng.git"
                    developerConnection = "scm:git:ssh://git@github.com/testng-team/testng.git"
                    url = "https://github.com/testng-team/testng"
                }
            }
        }
    }
