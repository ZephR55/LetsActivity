package com.bekiraydemir.letsactivity.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bekiraydemir.letsactivity.R
import com.bekiraydemir.letsactivity.databinding.FragmentHomeBinding
import com.bekiraydemir.letsactivity.model.Books
import com.bekiraydemir.letsactivity.model.Movies
import com.bekiraydemir.letsactivity.model.Musics
import com.bekiraydemir.letsactivity.retrofit.ApiClient
import com.bekiraydemir.letsactivity.retrofit.ApiResponse
import com.bekiraydemir.letsactivity.retrofit.PostService
import com.bekiraydemir.letsactivity.ui.home.adapters.BookAdapter
import com.bekiraydemir.letsactivity.ui.home.adapters.MovieAdapter
import com.bekiraydemir.letsactivity.ui.home.adapters.MusicAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private lateinit var movieList: ArrayList<Movies>
    private lateinit var musicList: ArrayList<Musics>
    private lateinit var bookList: ArrayList<Books>
    lateinit var postService: PostService


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        showMusicList()

        showBookList()

        postService = ApiClient.getClient().create(PostService::class.java)
        var post = postService.listPost()
        post.enqueue(object : Callback<ApiResponse>{


            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if(response.isSuccessful){
                    lateinit var postList: ArrayList<Movies>
                    Log.e("DATA",response.body().toString())
                    response.body()?.results?.forEach {
                        postList.add(
                            Movies(
                                moviename = it.originalTitle.toString(),
                                releasedate = it.releaseDate.toString(),
                                image =  "https://image.tmdb.org/t/p/w342"+it.posterPath,
                                category = "",
                            )
                        )
                    }
                    response.body()?.results?.get(0)?.originalTitle?.let { Toast.makeText(context, it, Toast.LENGTH_SHORT).show()}
                        showMovieList(postList)
                }
                else {
                    Toast.makeText(requireContext(), call.toString(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(requireContext(), t.message.toString(), Toast.LENGTH_LONG).show()
            }

        })

        return binding.root


        }


    private fun showMovieList(postList: ArrayList<Movies>) {
        movieList = ArrayList()




        //Data
        /*
        val ironman = Movies("IronMan", "May 2,2008", R.drawable.ironman1, "Movie")
        val hulk = Movies("Hulk", "June 13,2008", R.drawable.hulk1, "Movie")
        val walle = Movies("Wall-E", "September 25,2008", R.drawable.walle, "Movie")
        val monsterinc = Movies("MonstersInc.", "January 31,2002", R.drawable.monstersinc, "Movie")
        val interstellar =
            Movies("Interstellar", "November 6,2014", R.drawable.interstellar, "Movie")
        val avengers = Movies("Avengers", "April 26,2012", R.drawable.avengers1, "Movie")


        movieList.add(ironman)
        movieList.add(hulk)
        movieList.add(walle)
        movieList.add(monsterinc)
        movieList.add(interstellar)
        movieList.add(avengers)
        */



        val movieAdapter = MovieAdapter(requireContext(),postList) { position ->// Onclick Fonksiyonu
             val movie = postList[position]
             val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
              movie )
            findNavController().navigate(action)
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
        }


        val horizontalLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recycler.setLayoutManager(horizontalLayoutManager)
        binding.recycler.adapter = movieAdapter


    }

    private fun showMusicList() {

        musicList = ArrayList<Musics>()


        //Data
        val goldenhour = Musics("Golden Hour", "JVKE", R.drawable.goldenhourjvke, "Music")
        val bones = Musics("Bones", "Imagine Dragons", R.drawable.bonesimaginedragons, "Music")
        val dangerously =
            Musics("Dangerously", "Charlie Puth", R.drawable.charlieputhdangerously, "Music")
        val faded = Musics("Faded", "Alan Walker", R.drawable.fadedalanwalker, "Music")
        val hollywood = Musics("Mrs.Hollywood", "Go-Jo", R.drawable.gojomrshollywood, "Music")
        val isis = Musics("Isis", "Joyner Lucas", R.drawable.isisjoynerlucas, "Music")
        val shapeofyou =
            Musics("Shape of You", "Ed Sheeran", R.drawable.shapeofyouedsheeran, "Music")
        val nights = Musics("The Nights", "Avicii", R.drawable.thenightsavicii, "Music")
        val zedd = Musics("Stay", "Zedd", R.drawable.zeddstay, "Music")

        musicList.add(goldenhour)
        musicList.add(bones)
        musicList.add(dangerously)
        musicList.add(faded)
        musicList.add(hollywood)
        musicList.add(isis)
        musicList.add(shapeofyou)
        musicList.add(nights)
        musicList.add(zedd)

        val musicAdapter = MusicAdapter(musicList) {position ->
            val musics = musicList[position]
            val action = HomeFragmentDirections.actionHomeFragmentToMusicDetailsFragment(musics)
            findNavController().navigate(action)
        }
        val horizontalLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recycler2.setLayoutManager(horizontalLayoutManager)
        binding.recycler2.adapter = musicAdapter




    }

    fun showBookList() {


        bookList = ArrayList<Books>()


        //Data
        val icimizdekiseytan =
            Books("Icimizdeki Seytan", "Sabahattin Ali", R.drawable.icimizdekiseytan, "Book")
        val korluk = Books("Korluk", "Jose Saramago", R.drawable.korlukjosesaramago, "Book")
        val kuyucakliyusuf =
            Books("Kuyucakli Yusuf", "Sabahattin Ali", R.drawable.kuyucakliyusuf, "Book")
        val lordoftherings =
            Books("Lord Of The Rings", "J.R.R Tolkien", R.drawable.lordoftheringsjrrtolkien, "Book")
        val piamater = Books("Pia Mater", "Serkan Karaismailoglu", R.drawable.piamater, "Book")
        val sekerportakali =
            Books("Seker Portakali", "José Mauro", R.drawable.sekerportakalijosemauro, "Book")

        bookList.add(icimizdekiseytan)
        bookList.add(korluk)
        bookList.add(kuyucakliyusuf)
        bookList.add(lordoftherings)
        bookList.add(piamater)
        bookList.add(sekerportakali)

        val bookAdapter = BookAdapter(bookList) {position ->
            val books = bookList[position]
            val action = HomeFragmentDirections.actionHomeFragmentToBookDetailsFragment(books
            )
            findNavController().navigate(action)
    }
        val horizontalLayoutManagaer =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recycler3.setLayoutManager(horizontalLayoutManagaer)
        binding.recycler3.adapter = bookAdapter






    }
}



