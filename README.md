[![Twitter Follow](https://img.shields.io/twitter/follow/ngoanh2n.svg?style=social)](https://twitter.com/ngoanh2n)
[![GitHub followers](https://img.shields.io/github/followers/ngoanh2n.svg?style=social&label=Follow&maxAge=2592000)](https://github.com/ngoanh2n?tab=followers)
[![GitHub forks](https://img.shields.io/github/forks/ngoanh2n/selenide-testng-cucumber-example.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/ngoanh2n/selenide-testng-cucumber-example/network/members/)
[![GitHub stars](https://img.shields.io/github/stars/ngoanh2n/selenide-testng-cucumber-example.svg?style=social&label=Star&maxAge=2592000)](https://github.com/ngoanh2n/selenide-testng-cucumber-example/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/ngoanh2n/selenide-testng-cucumber-example.svg?style=social&label=Watch&maxAge=2592000)](https://github.com/ngoanh2n/selenide-testng-cucumber-example/watchers/)

[![License: MIT](https://img.shields.io/badge/License-MIT-blueviolet.svg)](https://opensource.org/licenses/MIT)
[![badge-jdk](https://img.shields.io/badge/jdk-8-blue.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![Build Status](https://travis-ci.org/ngoanh2n/selenide-testng-cucumber-example.svg?branch=master)](https://travis-ci.org/ngoanh2n/selenide-testng-cucumber-example)

# Selenide, TestNG, Cucumber Example

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [**Environment**](#environment)
- [**Frameworks/Libraries**](#frameworkslibraries)
- [**Project Structure**](#project-structure)
- [**How To Use**](#how-to-use)
  - [**Clone Repository**](#clone-repository)
  - [**Configuration Files**](#configuration-files)
  - [**Run Tests With Gradle**](#run-tests-with-gradle)
    - [**Perform On Browsers**](#perform-on-browsers)
    - [**Filter Tests**](#filter-tests)
    - [**Filter Tags**](#filter-tags)
  - [**Reports**](#reports)
    - [**Cucumber**](#cucumber)
    - [**Cucumber Reporting**](#cucumber-reporting)
    - [**Test Command Logs**](#test-command-logs)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## **Environment**
> **Platform**: <em>macOS Mojave</em><br/>
> **IDE**: <em>IntelliJ IDEA 2019.3.1 (Community Edition)</em><br/>
> **Java**: <em>1.8.0_211</em><br/>
> **Gradle**: <em>6.1.1</em><br/>

## **Frameworks/Libraries**
> **Selenide**: <em>5.6.1 - Web Driver</em><br/>
> **TestNG**: <em>7.1.0 - Testing Framework</em><br/>
> **Cucumber**: <em>5.0.0 - Behavior Driven Development (BDD) Tool</em><br/>
> **Cucumber Reporting**: <em>0.1.16 - Generating Reports From CucumberTestReport.json For Gradle</em><br/>

## **Project Structure**
```
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── images
│   └── **/*.png
├── src/test
│   ├── java/com/github/ngoanh2n
│   │   ├── common
│   │   │   ├── BasePage.java
│   │   │   ├── BaseTest.java
│   │   │   └── ScenarioHooks.java
│   │   ├── pages
│   │   │   ├── HomePage.java
│   │   │   └── LoginPage.java
│   │   ├── scenarios
│   │   │   └── ExampleTest.java
│   │   └── steps
│   │       ├── HomePageStepsDefinition.java
│   │       └── LoginPageStepsDefinition.java
│   └── resources
│       ├── com/github/ngoanh2n/features
│       │   ├── home
│       │   │   ├── welcome-title.feature
│       │   └── login
│       │       ├── login-failure.feature
│       │       └── login-success.feature
│       ├── log4j.properties
│       └── selenide.properties
├── .gitignore
├── .travis.yml
├── LICENSE
├── README.md
├── build.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle
```

## **How To Use**
### **Clone Repository**
> `$ git clone https://github.com/ngoanh2n/selenide-testng-cucumber-example.git`

### **Configuration Files**
You can change values for your case.

1. [log4j.properties](src/test/resources/log4j.properties)<br/>
    > Configuring log4j involves assigning the Level, defining Appender, and specifying Layout objects in a configuration file.
2. [selenide.properties](src/test/resources/selenide.properties)<br/>
    > Configuration settings for Selenide default browser. Settings can be set either via system property or programmatically.

### **Run Tests With Gradle**
> `./gradlew clean test`<br/>

#### **Perform On Browsers**
- chrome
- firefox
- ie
- edge
- htmlunit
- phantomjs
- safari

> If run safari, you must enable the 'Allow Remote Automation' option in Safari's Develop menu to control Safari via WebDriver.

Able to select browser by passing system property `selenide.browser`<br/>
> `./gradlew clean test -Dselenide.browser=firefox`

#### **Filter Tests**
You can filter tests by using option `--tests`<br/>
Giving values can be `TestPackage`, `TestClass`, `TestMethod`
> `./gradlew clean test -Dselenide.browser=firefox --tests ExampleTest`

#### **Filter Tags**
Choose feature files to run by passing system property `cucumber.filter.tags`<br/>
> `./gradlew clean test -Dcucumber.filter.tags="TAG_EXPRESSION"`<br/>

Available tags in project's features:
- `@Client`, `@Home`, `@HomeWelcome` tagged in feature [welcome-title.feature](src/test/resources/com/github/ngoanh2n/features/home/welcome-title.feature)
- `@Client`, `@Login`, `@LoginSuccess` tagged in feature [login-success.feature](src/test/resources/com/github/ngoanh2n/features/login/login-success.feature)
- `@Client`, `@Login`, `@LoginFailure` tagged in feature [login-failure.feature](src/test/resources/com/github/ngoanh2n/features/login/login-failure.feature)

A tag expression is an infix boolean expression. Below are some examples:

| Tag Expression               | Description            | Features Filtered |
| :--------------------------- | :--------------------- | :---------------- |
| `@Client` | Features tagged with `@Client` | [welcome-title](src/test/resources/com/github/ngoanh2n/features/home/welcome-title.feature),<br/> [login-success](src/test/resources/com/github/ngoanh2n/features/login/login-success.feature),<br/> [login-failure](src/test/resources/com/github/ngoanh2n/features/login/login-failure.feature) |
| `@Login or @HomeWelcome` | Features tagged with either `@Login` or `@HomeWelcome` | [welcome-title](src/test/resources/com/github/ngoanh2n/features/home/welcome-title.feature),<br/> [login-success](src/test/resources/com/github/ngoanh2n/features/login/login-success.feature),<br/> [login-failure](src/test/resources/com/github/ngoanh2n/features/login/login-failure.feature) |
| `@Login and @LoginFailure` | Features tagged with both `@Login` and `@LoginFailure` | [login-failure](src/test/resources/com/github/ngoanh2n/features/login/login-failure.feature) |
| `@Client and not @Login` | Features tagged with `@Client` that aren’t also tagged with `@Login` | [welcome-title](src/test/resources/com/github/ngoanh2n/features/home/welcome-title.feature) |


For even more advanced tag expressions you can use parenthesis for clarity, or to change operator precedence:
> `(@Login or @Home) and (not @LoginFailure)` -> [welcome-title](src/test/resources/com/github/ngoanh2n/features/home/welcome-title.feature), [login-success](src/test/resources/com/github/ngoanh2n/features/login/login-success.feature)

### **Reports**
#### **Cucumber**
<em>`Note`: After test command finished, results are generated at `selenide-testng-cucumber-example/build/cucumber-reports`</em><br/>

Open file `selenide-testng-cucumber-example/build/cucumber-reports/cucumber-pretty/index.html`, you can see:<br/>
![](images/cucumber-reports.png?raw=true)

#### **Cucumber Reporting**
<em>`Note`: After test command finished, results are generated by `gradle-cucumber-reporting` plugin at `selenide-testng-cucumber-example/build/cucumber-html-reports`</em><br/>

Open file `gradle-cucumber-reporting` plugin at `selenide-testng-cucumber-example/build/cucumber-html-reports/overview-tags.html`, you can see:<br/>

![](images/cucumber-html-reports-tags.png?raw=true)<br/>

![](images/cucumber-html-reports-features.png?raw=true)<br/>

![](images/cucumber-html-reports-tag-details.png?raw=true)<br/>

#### **Test Command Logs**
![](images/cucumber-test-command-logs.png?raw=true)<br/>
