package com.example.injection

import com.example.presentation.screens.ViewModelFragmentGames
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(viewModelFragmentGames: ViewModelFragmentGames)
}