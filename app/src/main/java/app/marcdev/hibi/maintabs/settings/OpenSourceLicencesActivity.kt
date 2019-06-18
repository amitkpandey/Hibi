package app.marcdev.hibi.maintabs.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import app.marcdev.hibi.R
import app.marcdev.hibi.internal.base.HibiActivity
import app.marcdev.hibi.uicomponents.views.LicenseDisplay

class OpenSourceLicencesActivity : HibiActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_oss)
    bindViews()
  }

  private fun bindViews() {
    val toolbarTitle: TextView = findViewById(R.id.txt_back_toolbar_title)
    toolbarTitle.text = resources.getString(R.string.open_source_licenses)

    val toolbarBackButton: ImageView = findViewById(R.id.img_back_toolbar_back)
    toolbarBackButton.setOnClickListener(backClickListener)

    val timber: LicenseDisplay = findViewById(R.id.license_timber)
    timber.setOnClickListener(openURLClickListener("https://github.com/JakeWharton/timber"))

    val kodein: LicenseDisplay = findViewById(R.id.license_kodein)
    kodein.setOnClickListener(openURLClickListener("https://github.com/Kodein-Framework/Kodein-DI"))

    val retrofit: LicenseDisplay = findViewById(R.id.license_retrofit)
    retrofit.setOnClickListener(openURLClickListener("https://github.com/square/retrofit"))

    val gson: LicenseDisplay = findViewById(R.id.license_gson)
    gson.setOnClickListener(openURLClickListener("https://github.com/google/gson"))

    val androidFilePicker: LicenseDisplay = findViewById(R.id.license_android_file_picker)
    androidFilePicker.setOnClickListener(openURLClickListener("https://github.com/DroidNinja/Android-FilePicker"))

    val mplus: LicenseDisplay = findViewById(R.id.license_mplus)
    mplus.setOnClickListener(openURLClickListener("https://fonts.google.com/specimen/M+PLUS+Rounded+1c"))

    val openSans: LicenseDisplay = findViewById(R.id.license_open_sans)
    openSans.setOnClickListener(openURLClickListener("https://fonts.google.com/specimen/Open+Sans"))

    val googleMaterialIcons: LicenseDisplay = findViewById(R.id.license_google_material_icons)
    googleMaterialIcons.setOnClickListener(openURLClickListener("https://material.io/tools/icons/"))

    val materialIcons: LicenseDisplay = findViewById(R.id.license_material_icons)
    materialIcons.setOnClickListener(openURLClickListener("https://materialdesignicons.com/"))

    val glide: LicenseDisplay = findViewById(R.id.license_glide)
    glide.setOnClickListener(openURLClickListener("https://github.com/bumptech/glide"))
  }

  private val backClickListener = View.OnClickListener {
    onBackPressed()
  }

  private fun openURLClickListener(url: String): View.OnClickListener {
    return View.OnClickListener {
      val uriUrl = Uri.parse(url)
      val launchBrowser = Intent(Intent.ACTION_VIEW)
      launchBrowser.data = uriUrl
      startActivity(launchBrowser)
    }
  }
}