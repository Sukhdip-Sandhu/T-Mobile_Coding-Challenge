# T-Mobile-Coding-Challenge
Simple application that displays home page feed data from REST API. 

## [Design](https://www.figma.com/file/6jOPuZS6nksXG9GMWcH9Jx/T-Mobile-Coding-Challenge?node-id=0%3A1)
I started by mocking the UI in Figma quickly just so I can get an overview of what kind of data I am working with, and what the final design will look like.

## Tech Stack
✅ Kotlin + MVVM Architecture

✅ Hilt Dependancy Injection

✅ Room Database for Offline Caching (NetworkBoundResource)

✅ Coroutines, LiveData + Flow

✅ Retrofit, OkHttp for Network Layer

## Assumptions / Design Decisions
The specifications asked for
> 5.	The view(s) which have image should set the height dynamically based on image resolution in the API response.

In my solution I do not use the API response for the image sizing. Instead, I ensure the image fills the width of the screen and the height is adjusted accordingly. The aspect ratio of the image remains intact which is why I deemed this solution acceptable.

---
I also opted to keep the RecyclerView simple and only have one view type for each of the different card_type states. Given more time I would have explored multiple viewtypes.
