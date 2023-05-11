package com.example.youtubemirlan.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubemirlan.BuildConfig
import com.example.youtubemirlan.data.model.PlayLists
import com.example.youtubemirlan.core.network.RetrofitClient
import com.example.youtubemirlan.core.ui.BaseViewModel
import com.example.youtubemirlan.data.remote.ApiService
import retrofit2.Call
import retrofit2.Response

class PlaylistViewModel: BaseViewModel() {

    private val apiService: ApiService = RetrofitClient.create()

    fun playlists(): LiveData<PlayLists> {
        return getPlayLists()
    }

    private fun getPlayLists(): LiveData<PlayLists> {
        val data = MutableLiveData<PlayLists>()
        apiService.getPlayLists(BuildConfig.API_KEY,"contentDetails","UCWOA1ZGywLbqmigxE4Qlvuw")
            .enqueue(object: retrofit2.Callback<PlayLists>{
                override fun onResponse(call: Call<PlayLists>, response: Response<PlayLists>) {
                    if (response.isSuccessful){
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<PlayLists>, t: Throwable) {
                    print(t.stackTrace)
                    //404 - not found, 401 - token invalid, 403 - access denied
                }
            })
        return data
    }
}