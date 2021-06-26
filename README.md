# Project 2 - *Flixster*

**Flixster** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **21** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **scroll through current movies** from the Movie Database API
* [x] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
* [x] For each movie displayed, user can see the following details:
  * [x] Title, Poster Image, Overview (Portrait mode)
  * [x] Title, Backdrop Image, Overview (Landscape mode)
* [x] Allow user to view details of the movie including ratings within a separate activity

The following **stretch** features are implemented:

* [x] Improved the user interface by experimenting with styling and coloring.
    * Created a dark mode color scheme 
    * Experimented with margins and other formatting
    * Fixed ViewHolders to be equally sized regardless of movies' overview length
    * Implemented a black background with the YouTube video centered vertically for viewing in portrait mode (when not full screen)
* [x] Apply rounded corners for the poster or background images using [Glide transformations](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#transformations)
* [x] Apply the popular [View Binding annotation library](http://guides.codepath.org/android/Reducing-View-Boilerplate-with-ViewBinding) to reduce boilerplate code.
* [x] Allow video trailers to be played in full-screen using the YouTubePlayerView from the details screen.

The following **additional** features are implemented:

* [x] Added 'Read More...' button and YouTube play button

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/sophiatxiang/Flixster/blob/master/flixster_portrait_bonus_1.gif' width='' alt='Video Walkthrough' />
<img src='https://github.com/sophiatxiang/Flixster/blob/master/flixster_landscape_bonus.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIFs created with [Kap](https://getkap.co/).

## Notes

Describe any challenges encountered while building the app:
- Initially a bit confused on how to access/use APIs and YouTubePlayerView
- Didn't know what view binding was- did a good amount of research to understand

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [2021] [Sophia Xiang]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
