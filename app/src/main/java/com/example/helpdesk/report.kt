package com.example.helpdesk


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.helpdesk.databinding.FragmentReportBinding
import com.example.helpdesk.databinding.FragmentStartMainBinding
import kotlinx.android.synthetic.main.fragment_report.*

/**
 * A simple [Fragment] subclass.
 */
class report : Fragment() {
    // The current word




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentReportBinding>(inflater,
            R.layout.fragment_report,container,false)
        binding.btnReport1.setOnClickListener { view->
            view.findNavController().navigate(reportDirections.actionReport3ToRepair(txt_requester.toString(),txt_title.toString(),txt_desciption.toString()))
        }

        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // check if the activity resolves
        inflater?.inflate(R.menu.winner_menu,menu)

        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,"Share")
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }






}
