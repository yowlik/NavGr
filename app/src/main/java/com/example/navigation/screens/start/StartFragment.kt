package com.example.navigation.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.APP
import com.example.navigation.R
import com.example.navigation.adapter.NoteAdapter
import com.example.navigation.databinding.FragmentStartBinding
import com.example.navigation.model.NoteModel

// TODO: Rename parameter arguments, choose names that match

class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView:RecyclerView
    lateinit var adapter:NoteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentStartBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel=ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDataBase()
        recyclerView=binding.rvNotes
        adapter= NoteAdapter()
        recyclerView.adapter=adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner,{listNotes->

            adapter.setList(listNotes.asReversed())
        })
        binding.btnNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addnoteFragment)
        }



    }
    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle=Bundle()
            bundle.putSerializable("note",noteModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment,bundle)
        }
    }


}