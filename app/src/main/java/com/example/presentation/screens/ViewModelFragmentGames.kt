package com.example.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.app.App
import com.example.model.RestAPI
import com.example.model.entity.Game
import com.example.presentation.screens.rvAfapter.AdaptRV
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ViewModelFragmentGames : ViewModel() {
    private val dispose = CompositeDisposable()
    val adaptRV = AdaptRV()

    @Inject
    lateinit var restAPI: RestAPI

    init {
        App.appComponent.inject(this)
    }

    fun getGames() {
        dispose.add(
            restAPI
                .loadJokes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adaptRV.setJokes(it.list_games as MutableList<Game>)
                }, {})
        )

    }

    fun onDestroy() {
        if (!dispose.isDisposed) dispose.dispose()
    }
}