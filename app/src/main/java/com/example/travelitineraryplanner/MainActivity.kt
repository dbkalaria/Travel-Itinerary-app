package com.example.travelitineraryplanner

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerDestinations: Spinner
    private lateinit var buttonGenerate: MaterialButton
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerDestinations = findViewById(R.id.spinner_destinations)
        buttonGenerate = findViewById(R.id.button_generate)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        // Set up the Spinner with destinations
        val destinations = arrayOf("Paris", "Rome", "Amsterdam", "Montreal", "Tokyo", "Darjeeling")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, destinations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDestinations.adapter = adapter

        // Set up the Button click listener
        buttonGenerate.setOnClickListener {
            val selectedDestination = spinnerDestinations.selectedItem.toString()
            val itinerary = getItineraryForCity(selectedDestination)
            setupViewPager(itinerary)
        }
    }

    private fun getItineraryForCity(city: String): List<ItineraryItem> {
        return when (city) {
            "Paris" -> listOf(
                ItineraryItem("Day 1", "10:00 AM", "Arrive in Paris"),
                ItineraryItem("Day 1", "11:00 AM", "Visit the Eiffel Tower"),
                ItineraryItem("Day 1", "01:00 PM", "Lunch at Le Jules Verne"),
                ItineraryItem("Day 1", "03:00 PM", "Explore the Louvre Museum"),
                ItineraryItem("Day 1", "06:00 PM", "Dinner at Café de Flore"),
                ItineraryItem("Day 1", "08:00 PM", "Seine River Cruise"),
                ItineraryItem("Day 1", "10:00 PM", "Check-in at Hotel"),
                ItineraryItem("Day 2", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 2", "10:00 AM", "Visit Notre-Dame Cathedral"),
                ItineraryItem("Day 2", "12:00 PM", "Stroll through Montmartre"),
                ItineraryItem("Day 2", "01:00 PM", "Lunch at La Maison Rose"),
                ItineraryItem("Day 2", "03:00 PM", "Visit Sacré-Cœur Basilica"),
                ItineraryItem("Day 2", "06:00 PM", "Dinner at L'Atelier de Joël Robuchon"),
                ItineraryItem("Day 2", "08:00 PM", "Evening walk along the Champs-Élysées"),
                ItineraryItem("Day 3", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 3", "10:00 AM", "Visit the Palace of Versailles"),
                ItineraryItem("Day 3", "01:00 PM", "Lunch at Angelina Paris"),
                ItineraryItem("Day 3", "03:00 PM", "Shopping at Galeries Lafayette"),
                ItineraryItem("Day 3", "06:00 PM", "Dinner at Le Comptoir du Relais"),
                ItineraryItem("Day 3", "08:00 PM", "Depart from Paris")
            )
            "Rome" -> listOf(
                ItineraryItem("Day 1", "10:00 AM", "Arrive in Rome"),
                ItineraryItem("Day 1", "11:00 AM", "Visit the Colosseum"),
                ItineraryItem("Day 1", "01:00 PM", "Lunch at Trattoria Monti"),
                ItineraryItem("Day 1", "03:00 PM", "Explore Roman Forum"),
                ItineraryItem("Day 1", "06:00 PM", "Dinner at Roscioli"),
                ItineraryItem("Day 1", "08:00 PM", "Walk around Piazza Navona"),
                ItineraryItem("Day 1", "10:00 PM", "Check-in at Hotel"),
                ItineraryItem("Day 2", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 2", "10:00 AM", "Visit Vatican Museums"),
                ItineraryItem("Day 2", "12:00 PM", "Visit St. Peter's Basilica"),
                ItineraryItem("Day 2", "01:00 PM", "Lunch at Da Enzo al 29"),
                ItineraryItem("Day 2", "03:00 PM", "Explore Castel Sant'Angelo"),
                ItineraryItem("Day 2", "06:00 PM", "Dinner at La Pergola"),
                ItineraryItem("Day 2", "08:00 PM", "Evening walk at Spanish Steps"),
                ItineraryItem("Day 3", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 3", "10:00 AM", "Visit Trevi Fountain"),
                ItineraryItem("Day 3", "01:00 PM", "Lunch at Osteria da Fortunata"),
                ItineraryItem("Day 3", "03:00 PM", "Shopping at Via del Corso"),
                ItineraryItem("Day 3", "06:00 PM", "Dinner at Armando al Pantheon"),
                ItineraryItem("Day 3", "08:00 PM", "Depart from Rome")
            )
            "Amsterdam" -> listOf(
                ItineraryItem("Day 1", "10:00 AM", "Arrive in Amsterdam"),
                ItineraryItem("Day 1", "11:00 AM", "Visit the Van Gogh Museum"),
                ItineraryItem("Day 1", "01:00 PM", "Lunch at The Pantry"),
                ItineraryItem("Day 1", "03:00 PM", "Explore the Anne Frank House"),
                ItineraryItem("Day 1", "06:00 PM", "Dinner at De Kas"),
                ItineraryItem("Day 1", "08:00 PM", "Canal Cruise"),
                ItineraryItem("Day 1", "10:00 PM", "Check-in at Hotel"),
                ItineraryItem("Day 2", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 2", "10:00 AM", "Visit Rijksmuseum"),
                ItineraryItem("Day 2", "12:00 PM", "Walk around Vondelpark"),
                ItineraryItem("Day 2", "01:00 PM", "Lunch at Café de Jaren"),
                ItineraryItem("Day 2", "03:00 PM", "Visit Heineken Experience"),
                ItineraryItem("Day 2", "06:00 PM", "Dinner at Restaurant Blauw"),
                ItineraryItem("Day 2", "08:00 PM", "Evening at Dam Square"),
                ItineraryItem("Day 3", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 3", "10:00 AM", "Visit the Jordaan neighborhood"),
                ItineraryItem("Day 3", "01:00 PM", "Lunch at Foodhallen"),
                ItineraryItem("Day 3", "03:00 PM", "Shopping at Kalverstraat"),
                ItineraryItem("Day 3", "06:00 PM", "Dinner at Restaurant Daalder"),
                ItineraryItem("Day 3", "08:00 PM", "Depart from Amsterdam")
            )
            "Montreal" -> listOf(
                ItineraryItem("Day 1", "10:00 AM", "Arrive in Montreal"),
                ItineraryItem("Day 1", "11:00 AM", "Visit Old Montreal"),
                ItineraryItem("Day 1", "01:00 PM", "Lunch at Schwartz's Deli"),
                ItineraryItem("Day 1", "03:00 PM", "Explore the Montreal Museum of Fine Arts"),
                ItineraryItem("Day 1", "06:00 PM", "Dinner at Joe Beef"),
                ItineraryItem("Day 1", "08:00 PM", "Walk around Mount Royal"),
                ItineraryItem("Day 1", "10:00 PM", "Check-in at Hotel"),
                ItineraryItem("Day 2", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 2", "10:00 AM", "Visit Notre-Dame Basilica"),
                ItineraryItem("Day 2", "12:00 PM", "Stroll through Plateau Mont-Royal"),
                ItineraryItem("Day 2", "01:00 PM", "Lunch at La Banquise"),
                ItineraryItem("Day 2", "03:00 PM", "Visit the Biosphere"),
                ItineraryItem("Day 2", "06:00 PM", "Dinner at Toqué!"),
                ItineraryItem("Day 2", "08:00 PM", "Evening walk along St. Catherine Street"),
                ItineraryItem("Day 3", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 3", "10:00 AM", "Visit the Montreal Botanical Garden"),
                ItineraryItem("Day 3", "01:00 PM", "Lunch at L'Avenue"),
                ItineraryItem("Day 3", "03:00 PM", "Shopping at Eaton Centre"),
                ItineraryItem("Day 3", "06:00 PM", "Dinner at Au Pied de Cochon"),
                ItineraryItem("Day 3", "08:00 PM", "Depart from Montreal")
            )
            "Tokyo" -> listOf(
                ItineraryItem("Day 1", "10:00 AM", "Arrive in Tokyo"),
                ItineraryItem("Day 1", "11:00 AM", "Visit Sensoji Temple"),
                ItineraryItem("Day 1", "01:00 PM", "Lunch at Ichiran Ramen"),
                ItineraryItem("Day 1", "03:00 PM", "Explore Akihabara"),
                ItineraryItem("Day 1", "06:00 PM", "Dinner at Sukiyabashi Jiro"),
                ItineraryItem("Day 1", "08:00 PM", "Walk around Shibuya"),
                ItineraryItem("Day 1", "10:00 PM", "Check-in at Hotel"),
                ItineraryItem("Day 2", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 2", "10:00 AM", "Visit Meiji Shrine"),
                ItineraryItem("Day 2", "12:00 PM", "Stroll through Yoyogi Park"),
                ItineraryItem("Day 2", "01:00 PM", "Lunch at Tsukiji Fish Market"),
                ItineraryItem("Day 2", "03:00 PM", "Visit Tokyo Tower"),
                ItineraryItem("Day 2", "06:00 PM", "Dinner at Sushi Saito"),
                ItineraryItem("Day 2", "08:00 PM", "Evening at Roppongi Hills"),
                ItineraryItem("Day 3", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 3", "10:00 AM", "Visit the Imperial Palace"),
                ItineraryItem("Day 3", "01:00 PM", "Lunch at Gonpachi"),
                ItineraryItem("Day 3", "03:00 PM", "Shopping at Ginza"),
                ItineraryItem("Day 3", "06:00 PM", "Dinner at Tempura Kondo"),
                ItineraryItem("Day 3", "08:00 PM", "Depart from Tokyo")
            )
            "Darjeeling" -> listOf(
                ItineraryItem("Day 1", "10:00 AM", "Arrive in Darjeeling"),
                ItineraryItem("Day 1", "11:00 AM", "Visit Tiger Hill"),
                ItineraryItem("Day 1", "01:00 PM", "Lunch at Glenary's"),
                ItineraryItem("Day 1", "03:00 PM", "Explore the Darjeeling Himalayan Railway"),
                ItineraryItem("Day 1", "06:00 PM", "Dinner at Keventers"),
                ItineraryItem("Day 1", "08:00 PM", "Walk around Mall Road"),
                ItineraryItem("Day 1", "10:00 PM", "Check-in at Hotel"),
                ItineraryItem("Day 2", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 2", "10:00 AM", "Visit the Peace Pagoda"),
                ItineraryItem("Day 2", "12:00 PM", "Explore the Himalayan Mountaineering Institute"),
                ItineraryItem("Day 2", "01:00 PM", "Lunch at Kunga Restaurant"),
                ItineraryItem("Day 2", "03:00 PM", "Visit Padmaja Naidu Himalayan Zoological Park"),
                ItineraryItem("Day 2", "06:00 PM", "Dinner at Sonam's Kitchen"),
                ItineraryItem("Day 2", "08:00 PM", "Evening walk at Nightingale Park"),
                ItineraryItem("Day 3", "09:00 AM", "Breakfast at the hotel"),
                ItineraryItem("Day 3", "10:00 AM", "Visit the Batasia Loop"),
                ItineraryItem("Day 3", "01:00 PM", "Lunch at Penang Restaurant"),
                ItineraryItem("Day 3", "03:00 PM", "Shopping at Chowrasta"),
                ItineraryItem("Day 3", "06:00 PM", "Dinner at Park Restaurant"),
                ItineraryItem("Day 3", "08:00 PM", "Depart from Darjeeling")
            )
            else -> listOf()
        }
    }

    private fun setupViewPager(itinerary: List<ItineraryItem>) {
        val day1 = itinerary.filter { it.day == "Day 1" } as ArrayList<ItineraryItem>
        val day2 = itinerary.filter { it.day == "Day 2" } as ArrayList<ItineraryItem>
        val day3 = itinerary.filter { it.day == "Day 3" } as ArrayList<ItineraryItem>

        val fragments = listOf(
            ItineraryFragment.newInstance(day1),
            ItineraryFragment.newInstance(day2),
            ItineraryFragment.newInstance(day3)
        )

        val adapter = ViewPagerAdapter(this, fragments)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Day ${position + 1}"
        }.attach()
    }
}
