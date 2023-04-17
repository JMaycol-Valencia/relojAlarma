package com.example.relojalarma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

//    lateinit var horaPrincipal: TextClock
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        horaPrincipal = findViewById(R.id.idhora_principal)
//        horaPrincipal.format12Hour = "HH:mm:ss a"
        /* DE LA SIG FORMA PODEMOS AGREGAR NUESTRAS FUNCIONES A NUESTROS BOTONES
        val btnColor : Button = findViewById(R.id.btn_color)
        val txtPrincipal : TextView = findViewById(R.id.idtext_principal)

        btnColor.setOnClickListener{
            txtPrincipal.setTextColor(android.graphics.Color.MAGENTA)
        }
        */

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MenuFragment(), "Menu")
        adapter.addFragment(AlarmFragment(), "Alarmas")
        adapter.addFragment(TemporizadorFragment(), "Cronometro")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    fun cambiarColor(view: View){
        val txtPrincipal : TextView = findViewById(R.id.idtext_principal)
        txtPrincipal.setTextColor(android.graphics.Color.GREEN)

        Toast.makeText(applicationContext, "Cambio de color Exitoso", Toast.LENGTH_LONG).show()
    }

    fun menuNavigation(view: View) {
        val intent = Intent(this, ActivityAlarm::class.java)
        startActivity(intent)
    }

    class ViewPagerAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val fragmentList = mutableListOf<Fragment>()
        private val titleList = mutableListOf<String>()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }
    }
}