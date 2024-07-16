package com.example.travelitineraryplanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItineraryFragment : Fragment() {

    private lateinit var recyclerViewItinerary: RecyclerView
    private lateinit var itineraryAdapter: ItineraryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_itinerary, container, false)

        recyclerViewItinerary = view.findViewById(R.id.recyclerViewItinerary)
        recyclerViewItinerary.layoutManager = LinearLayoutManager(context)

        val itineraryItems = arguments?.getParcelableArrayList<ItineraryItem>("itineraryItems") ?: arrayListOf()

        itineraryAdapter = ItineraryAdapter(itineraryItems)
        recyclerViewItinerary.adapter = itineraryAdapter

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(itineraryItems: ArrayList<ItineraryItem>) =
            ItineraryFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList("itineraryItems", itineraryItems)
                }
            }
    }
}
