package com.example.youtubemirlan.ui.playlist

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubemirlan.ui.playlist.adapter.PlaylistAdapter
import com.example.youtubemirlan.core.ui.BaseActivity
import com.example.youtubemirlan.core.ui.BaseViewModel
import com.example.youtubemirlan.data.model.Item
import com.example.youtubemirlan.ui.video.VideoListsActivity
import com.example.youtubemirlan.databinding.ActivityPlaylistBinding


class PlaylistActivity() : BaseActivity<ActivityPlaylistBinding, BaseViewModel>() {

    private  var adapter= PlaylistAdapter(this::onClick)

    private fun onClick(item: Item) {
        val intent = Intent(this@PlaylistActivity, VideoListsActivity::class.java)
        intent.putExtra(ID, item.snippet.title)
        Toast.makeText(this, item.snippet.title, Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initViewModel() {

        viewModel.playlists().observe(this) {
            binding.recyclerView.adapter = adapter

            adapter.setList(it.items)
            Toast.makeText(this, it.kind, Toast.LENGTH_SHORT).show()
        }
    }

    override fun inflateViewBinding(): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    companion object {
        const val ID = "id"
    }
}