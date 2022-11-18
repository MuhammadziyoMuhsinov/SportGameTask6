package uz.muhammadziyo.sportgametask6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.muhammadziyo.sportgametask6.databinding.FragmentMenuBinding
import uz.muhammadziyo.sportgametask6.models.Mydata


class FragmentMenu : Fragment() {

     private lateinit var binding:FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        binding.name.setText("Hello ${Mydata.name} !")
        binding.framelayout.setOnClickListener {
            findNavController().navigate(R.id.fragmentQuestion)
        }
        return binding.root
    }


}