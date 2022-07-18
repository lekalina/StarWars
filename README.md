# STAR WARS
![Run lints and compile](https://github.com/lekalina/starwars/workflows/Run%20lints%20and%20compile/badge.svg)

## Architecture
The architecture pattern is base on the **Model-View-ViewModel (MVVM)** Pattern where there are 3 layers within the application:
- Data Layer: the data sources and repos related to data persistence, REST calls, etc.
- Domain Layer: high-level abstractions and use cases which contain the applications business logic & domain rules
- Presentation (UI) Layer: all functionality related to the user interface (activities, views, viewModels, etc)

## Core Libraries
The main libraries used in this application include:
- [Android Architecture Components - Jetpack](https://developer.android.com/topic/libraries/architecture):
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), life cycle aware components.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), mvvm architecture component.
    - [Compose](https://developer.android.com/compose), toolkit for native UI.
    - [Android Navigation Component](https://developer.android.com/jetpack/compose/navigation), navigation for compose.
    - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android), dependency injection.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html), asynchronous programming.
- [OkHttp](https://square.github.io/okhttp/) and [Retrofit](https://square.github.io/retrofit/), network communication.

### Contributors
This project was created by:
* [Rebecca Santoro](http://github.com/lekalina)

### Contributing
1. Fork it
2. Create your feature branch (git checkout -b my_new_feature)
3. Commit your changes (git commit -m 'Add some feature')
4. Push your branch (git push --set-upstream origin my_new_feature)
5. Create a new Pull Request
