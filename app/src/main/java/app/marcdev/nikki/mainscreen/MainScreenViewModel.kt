package app.marcdev.nikki.mainscreen

import androidx.lifecycle.ViewModel
import app.marcdev.nikki.data.repository.EntryRepository
import app.marcdev.nikki.internal.lazyDeferred

class MainScreenViewModel(private val entryRepository: EntryRepository) : ViewModel() {

  val allEntries by lazyDeferred {
    entryRepository.getAllEntries()
  }
}