package com.example.helpdesk


import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.helpdesk.databinding.FragmentRepairBinding
import com.example.helpdesk.databinding.FragmentStartMainBinding
import java.util.*



/**
 * A simple [Fragment] subclass.
 */
class Repair : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRepairBinding>(inflater,
            R.layout.fragment_repair,container,false)
        binding.btnReport.setOnClickListener { view->
            view.findNavController().navigate(RepairDirections.actionRepairToReport3())
        }
        val args = RepairArgs.fromBundle(arguments!!)
        Toast.makeText(context, "StringRequester: ${args.StringRequester}, StringTitle: ${args.StringTitle},StringDesciption: ${args.StringDesciption}", Toast.LENGTH_LONG).show()

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun getShareIntent() : Intent {
        val args = RepairArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.StringRequester, args.StringTitle,args.StringDesciption))
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // check if the activity resolves
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


}
