package com.example.mymarvelapp.model.db

import kotlinx.coroutines.flow.Flow

class CollectionDbRepoImplementation(private val characterDao: CharacterDao) : CollectionDbRepo {

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
}