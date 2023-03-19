package com.example.mymarvelapp.model.db

import kotlinx.coroutines.flow.Flow

class CollectionDbRepoImplementation(
    private val characterDao: CharacterDao,
    private val noteDao: NoteDao
) : CollectionDbRepo {

    override suspend fun getCharactersFromRepo(): Flow<List<DbCharacter>> =
        characterDao.getCharacters()

    override suspend fun getCharacterFromRepo(characterId: Int): Flow<DbCharacter> =
        characterDao.getCharacter(characterId = characterId)

    override suspend fun addCharacterToRepo(character: DbCharacter) =
        characterDao.addCharacter(character = character)

    override suspend fun updateCharacterInRepo(character: DbCharacter) =
        characterDao.updateCharacter(character = character)

    override suspend fun deleteCharacterFromRepo(character: DbCharacter) =
        characterDao.deleteCharacter(character = character)

    override suspend fun getAllNotes(): Flow<List<DbNote>> = noteDao.getAllNotes()

    override suspend fun getNotesFromRepo(characterId: Int): Flow<List<DbNote>> =
        noteDao.getNotes(characterId = characterId)

    override suspend fun addNoteToRepo(note: DbNote) = noteDao.addNote(note = note)

    override suspend fun updateNoteInRepo(note: DbNote) = noteDao.updateNote(note = note)

    override suspend fun deleteNoteFromRepo(note: DbNote) = noteDao.deleteNote(note = note)

    override suspend fun deleteAllNotes(character: DbCharacter) =
        noteDao.deleteAllNotes(characterId = character.id)
}