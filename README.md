#Buck Tracker Appium Test
#### Sample test of iOS app using Appium and AWS Device Farm

This Repo contains sample test files to be packaged and run on the AWS Device Farm. Instructions for installing Appium can be found in the [Getting Started Guide](http://appium.io/slate/en/tutorial/android.html?java#getting-started-with-appium). 

## Running Locally

You will need to be on a Mac with an Apple Developer Account and have Eclipse, Appium, XCode, and Maven installed to run this test. Also, install a TestNG plugin in Eclipse so you can run the test. Before you start, be sure to connect your device or start an emulator.

1.  Visit the [Buck Tracker](https://github.com/hkalexling/Buck_Tracker) repo and download it.
2.  Open the project in XCode, build it, and run it on the device you will be testing on.
3.  In XCode, select **Product** > **Archive**. Click **Export** and then **Save for iOS App Store Deployment**. Select the location to save the **.ipa** file and keep note of its path.
4.  Open the terminal and enter the command **instruments -s devices**. There will be list of devices in the format **[DeviceName] [DeviceVersion] [id]**.
5.  Find your connected or emulated device you will be testing on and take note of the name, id, and version.
6.  Open *start-appium-ios.sh* and update the **--udid**, **-app**, and **--platform-version** attributes.
7.  Download and import the project into Eclipse.
8.  Open **MyAppTestBase.java** and set the **deviceName** capability in the *setUpAppium()* method
9.  Right click on the project and click Maven > Update.
10.  In the terminal, CD into the project and start the Appium server by running the command **./start-appium-ios.sh**
11.  Open the file **MainStoryboardTest.java**, right click > Run As > TestNG Test

If the tests do not run then verify 

-  the app is installed on the device.
-  xcode is open and connected to the device/emulator.
-  The **start-appium-ios.sh** file is configured correctly.

If the tests continue not to run restart your phone and xcode and start again.

## Packaging and Running

To run the tests on Device Farm they must first be packaged.

1.  Cd into the project and run the command **mvn clean package -DskipTests=true**
2.  Open the folder **target** and verify the **zip-with-dependencies.zip** file exists.
3.  Login to Device Farm and create a new Project and Run.
4.  Upload the **.ipa** file that was exported.
5.  Select the TestNG type and upload the **zip-with-dependencies.zip**.

If the tests upload successfully but do not run then verify that the ***-tests.jar**	 contains all the test files. To inspect the jar enter the following in the projects folder:

    jar tf target/InstagramAppiumTest-0.0.1-SNAPSHOT-tests.jar 
    
