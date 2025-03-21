import org.gradle.configurationcache.extensions.capitalized

plugins {
    java
}

allprojects {
    apply<JavaPlugin>()

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }

    repositories {
        mavenCentral()
    }

    group = "it.unibo.ise"
}

subprojects {
    sourceSets {
        main {
            resources {
                srcDir("src/main/asl")
            }
        }
    }

    dependencies {
        implementation("io.github.jason-lang:jason-interpreter:3.2.1")
        testImplementation("junit", "junit", "4.13.2")
    }

    file(projectDir).listFiles().filter { it.extension == "mas2j" }.forEach { mas2jFile ->
        tasks.register<JavaExec>("run${mas2jFile.nameWithoutExtension.capitalized()}Mas") {
            group = "run"
            classpath = sourceSets.getByName("main").runtimeClasspath
            mainClass.set("jason.infra.centralised.RunCentralisedMAS")
            args(mas2jFile.path)
            standardInput = System.`in`
            javaLauncher.set(javaToolchains.launcherFor(java.toolchain))
        }
    }
}
