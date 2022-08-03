package com.example.navigation.db.repositoriy

import androidx.lifecycle.LiveData
import com.example.navigation.db.dao.NoteDao
import com.example.navigation.model.NoteModel

class NoteRealization(private val noteDao: NoteDao):NoteRepositoriy {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }

}