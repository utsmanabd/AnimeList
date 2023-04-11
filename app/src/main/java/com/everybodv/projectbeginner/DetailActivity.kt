package com.everybodv.projectbeginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.everybodv.projectbeginner.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Anime>("DATA")

        binding.tvDetailTitle.text = data?.name
        binding.tvDetailRating.text = data?.rating
        binding.tvDetailGenre.text = data?.genres
        binding.tvDetailDescription.text = data?.description
        Glide
            .with(this)
            .load(data?.photo.toString())
            .into(binding.tvDetailPhoto)
        binding.tvDetailStatus.text = data?.status
        binding.tvDetailEpisode.text = data?.episode

        val share = data?.photo.toString()
        binding.tvDetailShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, share)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}