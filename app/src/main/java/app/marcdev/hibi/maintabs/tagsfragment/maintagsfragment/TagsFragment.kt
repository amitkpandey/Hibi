package app.marcdev.hibi.maintabs.tagsfragment.maintagsfragment

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.marcdev.hibi.R
import app.marcdev.hibi.internal.PREF_ENTRY_DIVIDERS
import app.marcdev.hibi.internal.base.ScopedFragment
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import timber.log.Timber


class TagsFragment : ScopedFragment(), KodeinAware {

  // Kodein initialisation
  override val kodein by closestKodein()

  // Viewmodel
  private val viewModelFactory: TagsFragmentViewModelFactory by instance()
  private lateinit var viewModel: TagsFragmentViewModel

  // UI Components
  private lateinit var loadingDisplay: ConstraintLayout
  private lateinit var noResults: ConstraintLayout

  // Recycler view
  private lateinit var recyclerAdapter: TagsRecyclerAdapter

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(TagsFragmentViewModel::class.java)
  }
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    Timber.v("Log: onCreateView: Started")
    val view = inflater.inflate(R.layout.fragment_tags, container, false)

    bindViews(view)
    initRecycler(view)

    return view
  }

  private fun bindViews(view: View) {
    loadingDisplay = view.findViewById(R.id.const_tags_loading)
    noResults = view.findViewById(R.id.const_no_tags)
  }

  private fun initRecycler(view: View) {
    val recycler: RecyclerView = view.findViewById(R.id.recycler_tags)
    this.recyclerAdapter = TagsRecyclerAdapter(requireContext(), requireFragmentManager())
    val layoutManager = LinearLayoutManager(context)
    recycler.adapter = recyclerAdapter
    recycler.layoutManager = layoutManager

    val includeEntryDividers = PreferenceManager.getDefaultSharedPreferences(requireContext()).getBoolean(PREF_ENTRY_DIVIDERS, true)
    if(includeEntryDividers) {
      val dividerItemDecoration = DividerItemDecoration(recycler.context, layoutManager.orientation)
      recycler.addItemDecoration(dividerItemDecoration)
    }

    displayRecyclerData()
  }

  private fun displayRecyclerData() = launch {
    noResults.visibility = View.GONE
    loadingDisplay.visibility = View.VISIBLE

    val displayItems = viewModel.displayItems.await()
    displayItems.observe(this@TagsFragment, Observer { items ->
      recyclerAdapter.updateList(items)
      loadingDisplay.visibility = View.GONE
      if(items.isEmpty())
        noResults.visibility = View.VISIBLE
      else
        noResults.visibility = View.GONE
    })
  }
}