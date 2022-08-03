package com.example.navigation.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigation.REPOS
import com.example.navigation.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel:ViewModel() {
    fun insert(noteModel: NoteModel, onSuccess:()->Unit)=
        viewModelScope.launch(Dispatchers.IO) {
            REPOS.insertNote(noteModel){
                onSuccess()
            }

        }

}