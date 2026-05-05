# Casino Java - Lazaro Beas - May 2026
Casino Java is a project aimed to perfect Java fundamentals and prevent AI coding agent atrophy. This project is
structured in a curriculum format and is self paced, meant to be completed over the span of a month. 

# Versions
Java 21.0.11  
Apache Maven 3.9.15

## Milestone 0 - Project Setup:
May 4, 2026: I have created a pom.xml from scratch that has a basic default structure along with 3 dependencies such as
JUnit, Assert, and Maven Surefire Plugin. This was my first time actually creating a pom from scratch and it really
helped me understand the structure of the file. Furthermore, I understand how dependencies are managed and maintained 
in Maven. I also created a .gitignore file which helped me finally grasp how the wildcard endings work and how gitignore
works to not commit unnecessary files. 

The structure of the project has been established along with creating the main driver application file, which is
currently set to print a standard text line. 

## Build & Run
These commands are used to compile and run the maven application.  
`mvn clean verify ` build + test  
`mvn exec:java -Dexec.mainClass="com.lazarobeas.casino.CasinoApplication"` Run the application (won't do anything yet)

## Project Structure
```text
casino-java/
├── .gitignore
├── README.md
├── pom.xml
├── docs/
│   └── adr/
│       ├── 0001-build-tool.md
│       └── 0002-package-layout.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── lazarobeas/
    │               └── casino/
    │                   └── CasinoApplication.java
    └── test/
        └── java/
            └── com/
                └── lazarobeas/
                    └── casino/
                        └── SanityTest.java
```