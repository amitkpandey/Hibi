package app.marcdev.hibi.data.repository

import androidx.lifecycle.LiveData
import app.marcdev.hibi.data.entity.EntryImage

interface EntryImageRepository {

  suspend fun addEntryImage(entryImage: EntryImage)

  suspend fun deleteEntryImage(entryImage: EntryImage)

  fun getImagesForEntry(entryId: Int): LiveData<List<EntryImage>>

  suspend fun countUsesOfImage(imageName: String): Int
}