package com.example.youtubemirlan.ui.video

import android.widget.Toast
import com.example.youtubemirlan.core.ui.BaseActivity
import com.example.youtubemirlan.core.ui.BaseViewModel
import com.example.youtubemirlan.databinding.ActivityVideoListsBinding
import com.example.youtubemirlan.ui.playlist.PlaylistActivity

class VideoListsActivity(override val viewModel: BaseViewModel) : BaseActivity<ActivityVideoListsBinding, BaseViewModel>() {
    override fun inflateViewBinding(): ActivityVideoListsBinding {
        return ActivityVideoListsBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        super.initListener()
        val result = intent.getStringExtra(PlaylistActivity.ID)
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }
}