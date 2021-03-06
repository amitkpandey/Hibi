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
package com.marcdonald.hibi.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName = "BookEntryRelation",
	primaryKeys = ["bookId", "entryId"],
	foreignKeys = [
		ForeignKey(
			entity = Entry::class,
			parentColumns = ["id"],
			childColumns = ["entryId"],
			onDelete = ForeignKey.CASCADE,
			onUpdate = ForeignKey.CASCADE
		),
		ForeignKey(
			entity = Book::class,
			parentColumns = ["id"],
			childColumns = ["bookId"],
			onDelete = ForeignKey.CASCADE,
			onUpdate = ForeignKey.CASCADE
		)
	],
	indices = [Index(name = "BookEntryRelation_EntryId_Index", value = ["entryId"])]
)
data class BookEntryRelation(
	var bookId: Int,
	var entryId: Int
)