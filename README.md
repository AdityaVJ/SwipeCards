# SwipeCards
This app fetches JSON data from an API and displays it in a swipable card design.

## Overview

This app uses the MVVM architecture pattern along with RxJava and Retrofit to manage network calls. The separation of concerns has been taken care of by using Viewmodels where ever required.

The app implements the Viewpager and the relevant adapter to create a swipable card layout. No unofficial/third-party libraries have been used for the task and it makes use of the android official libraries for the same.

Interceptor has been used along with retrofit in order to fix malformed JSON received from the API.

A progress tracker has also been added to track the progress as the cards are swiped.

## How to use? 

Build and install the apk of the app on an Android device with API level no lower than 23. The app does not require any login to work. Launch the app using the icon and wait for the app to load the cards. In case of a network failure or any other error, a toast will display the error message and the screen will show a message that states that loading the cards has been unsuccessful.

Upon restoring the network or fixing the error, you can reload the card by swiping down on the screen from the top. The cards can be navigated in both left and right directions using either swipe gestures or card navigation buttons. The cards can be reset using the reset button at the center.

## Keywords

Kotlin, RxJava, Retrofit, MVVM, Interceptor.
