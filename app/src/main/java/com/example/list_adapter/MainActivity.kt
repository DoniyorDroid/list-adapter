package com.example.list_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.list_adapter.adapter.PersonAdapter
import com.example.list_adapter.databinding.ActivityMainBinding
import com.example.list_adapter.model.Person

class MainActivity : AppCompatActivity() {
    lateinit var list: ArrayList<Person>
    lateinit var adapter: PersonAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        initData()
        
        adapter = PersonAdapter(object : PersonAdapter.OnClick {
            override fun onClickListener(person: Person, position: Int) {
                list.remove(person)
                adapter.submitList(list.toMutableList())
            }
        })
        adapter.submitList(list.toMutableList())
        binding.rv.adapter = adapter

    }

    private fun initData() {
        for (i in 0 until 100) {
            list.add(Person(i, "Item Name $i", "Item Number $i"))
        }
    }
}