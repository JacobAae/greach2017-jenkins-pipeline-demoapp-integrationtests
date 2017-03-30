#!/usr/bin/env groovy

node {
    stage "checkout"
        checkout scm

    stage 'Clean'
            sh "./gradlew clean"

    stage 'Run Integration Tests'
        try{
            sh "./gradlew check"
            step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/*.xml'])
        } catch( Exception e) {
            currentBuild.result = "FAILURE"
            // Should send mail etc...
            step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/*.xml'])
            throw e
        }
}
