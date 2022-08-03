package com.example.navigation.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.navigation.REPOS
import com.example.navigation.db.NoteDataBase
import com.example.navigation.db.repositoriy.NoteRealization
import com.example.navigation.model.NoteModel

class StartViewModel(application:Application):AndroidViewModel(application) {
    val context=application


    fun initDataBase(){
        val daoNote=NoteDataBase.getInstance(context).getNoteDao()
        REPOS=NoteRealization(daoNote)
    }
    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOS.allNotes

    }

}