package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this),
            object : CatAdapter.OnClickListener {
                override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pasang adapter & layout manager
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Pasang swipe-to-delete ke RecyclerView
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Tambahkan data ke adapter
            catAdapter.setData(
                listOf(
                    CatModel(
                        Gender.Male,
                        CatBreed.BalineseJavanese,
                        "Fred",
                        "Silent and deadly",
                        "https://cdn2.thecatapi.com/images/7dj.jpg"
                    ),
                    CatModel(
                        Gender.Female,
                        CatBreed.ExoticShorthair,
                        "Wilma",
                        "Cuddly assassin",
                        "https://cdn2.thecatapi.com/images/egv.jpg"
                    ),
                    CatModel(
                        Gender.Unknown,
                        CatBreed.AmericanCurl,
                        "Curious George",
                        "Award winning investigator",
                        "https://cdn2.thecatapi.com/images/bar.jpg"
                    ),
                    CatModel(
                        Gender.Female,
                        CatBreed.BalineseJavanese,
                        "Luna",
                        "Playful and curious",
                        "https://cdn2.thecatapi.com/images/bpc.jpg"
                    ),
                    CatModel(
                        Gender.Male,
                        CatBreed.ExoticShorthair,
                        "Simba",
                        "Brave little king",
                        "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                    ),
                    CatModel(
                        Gender.Unknown,
                        CatBreed.AmericanCurl,
                        "Shadow",
                        "Loves to hide",
                        "https://cdn2.thecatapi.com/images/9oo.jpg"
                    ),
                    CatModel(
                        Gender.Female,
                        CatBreed.ExoticShorthair,
                        "Misty",
                        "Soft and cuddly",
                        "https://cdn2.thecatapi.com/images/6qi.jpg"
                    ),
                    CatModel(
                        Gender.Male,
                        CatBreed.BalineseJavanese,
                        "Leo",
                        "Loves to climb trees",
                        "https://cdn2.thecatapi.com/images/8q3.jpg"
                    ),
                    CatModel(
                        Gender.Unknown,
                        CatBreed.AmericanCurl,
                        "Snowy",
                        "White as snow",
                        "https://cdn2.thecatapi.com/images/c9f.jpg"
                    ),
                    CatModel(
                        Gender.Female,
                        CatBreed.ExoticShorthair,
                        "Nala",
                        "Queen of the house",
                        "https://cdn2.thecatapi.com/images/8f8.jpg"
                    )
                )
            )



    }

    // Pop-up dialog saat item diklik
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
