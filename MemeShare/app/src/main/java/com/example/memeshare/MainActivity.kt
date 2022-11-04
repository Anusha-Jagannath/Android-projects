package com.example.memeshare

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class MainActivity : AppCompatActivity() {
    private lateinit var shareButton: Button
    private lateinit var nextButton: Button
    private lateinit var memeImage: ImageView
    private lateinit var loader: ProgressBar
    private var currentUrl: String ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shareButton = findViewById(R.id.shareButton)
        nextButton = findViewById(R.id.nextButton)
        memeImage = findViewById(R.id.memeImage)
        loader = findViewById(R.id.progressbar)
        loadMeme()
        listeners()
    }

    private fun loadMeme() {
        loader.visibility = View.VISIBLE
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            { response ->
                Log.d("sucess","response")
                currentUrl = response.getString("url")
                Glide.with(this).load(currentUrl).listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        loader.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        loader.visibility = View.GONE
                        return false
                    }

                }).into(memeImage)
            },
            {
                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_SHORT).show()
            })
            queue.add(jsonObjectRequest)

    }

    private fun listeners() {
        shareButton.setOnClickListener {
            Toast.makeText(this@MainActivity,"clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,"Hey checkout this meme from Reddit $currentUrl")
            val chooser = Intent.createChooser(intent,"Share this meme using..")
            startActivity(chooser)

        }
        nextButton.setOnClickListener {
            loadMeme()
        }
    }
}