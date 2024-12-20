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
