#!/bin/bash

function die {
    echo $1
    exit 1
}

app_filename="/Users/sonny/Desktop/MyApp.ipa"


appium --platform-version "9.2.1" --platform-name "iOS" --app "/Users/sonny/Desktop/iBudgeter.ipa" --udid "ec53ad567743739420a5d29cfb057a16813469ca" --show-ios-log --default-device

