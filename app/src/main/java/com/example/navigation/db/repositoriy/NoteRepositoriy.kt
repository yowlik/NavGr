package com.example.navigation.db.repositoriy

import androidx.lifecycle.LiveData
import com.example.navigation.model.NoteModel

interface NoteRepositoriy {
    val allNotes:LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:()->Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:()->Unit)

}