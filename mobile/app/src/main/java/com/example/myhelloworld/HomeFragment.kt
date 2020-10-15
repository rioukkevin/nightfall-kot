package com.example.myhelloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myhelloworld.model.User
import com.example.myhelloworld.repository.Repository

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val user : User = Repository.getUser()
        val ranking = Repository.getRanking()

        return inflater.inflate(R.layout.fragment_home,container,false)

    }
}
