/*
 * Copyright 2020 Marc Donald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.marcdonald.hibi.data.repository

import androidx.lifecycle.LiveData
import com.marcdonald.hibi.data.database.NumberAndDateObject
import com.marcdonald.hibi.data.database.NumberAndIdObject
import com.marcdonald.hibi.data.entity.NewWord

interface NewWordRepository {

	suspend fun addNewWord(newWord: NewWord)

	suspend fun getNewWord(id: Int): NewWord

	suspend fun deleteNewWord(id: Int)

	fun getNewWordsByEntryId(entryId: Int): LiveData<List<NewWord>>

	suspend fun getNewWordCountByEntryId(entryId: Int): Int

	fun getNewWordCountByEntryIdLD(entryId: Int): LiveData<Int>

	val newWordCount: LiveData<Int>

	suspend fun getMostNewWordsInOneDay(): NumberAndDateObject

	suspend fun getMostNewWordsInOneEntry(): NumberAndIdObject
}