package com.example.helpdesk


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.helpdesk.databinding.FragmentStartMainBinding

/**
 * A simple [Fragment] subclass.
 */
class StartMain : Fragment() {
    val Desciption = MutableLiveData<String>()
    // The current score
    val Title = MutableLiveData<String>()
    val Requester = MutableLiveData<String>()



    private lateinit var viewModel: GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentStartMainBinding>(inflater,
            R.layout.fragment_start_main,container,false)

        binding.btnStrart.setOnClickListener { view->
            view.findNavController().navigate(StartMainDirections.actionStartMain5ToRepair("55","55","55"))
        }

        Log.i("GameFragment", "Called ViewModelProviders.of")

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }




}
