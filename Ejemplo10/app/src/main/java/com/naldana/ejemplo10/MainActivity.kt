package com.naldana.ejemplo10

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var twoPane =  false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO (9) Se asigna a la actividad la barra personalizada
        setSupportActionBar(toolbar)


        // TODO (10) Click Listener para el boton flotante
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        // TODO (11) Permite administrar el DrawerLayout y el ActionBar
        // TODO (11.1) Implementa las caracteristicas recomendas
        // TODO (11.2) Un DrawerLayout (drawer_layout)
        // TODO (11.3) Un lugar donde dibujar el indicador de apertura (la toolbar)
        // TODO (11.4) Una String que describe el estado de apertura
        // TODO (11.5) Una String que describe el estado cierre
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        // TODO (12) Con el Listener Creado se asigna al  DrawerLayout
        drawer_layout.addDrawerListener(toggle)


        // TODO(13) Se sincroniza el estado del menu con el LISTENER
        toggle.syncState()

        // TODO (14) Se configura el listener del menu que aparece en la barra lateral
        // TODO (14.1) Es necesario implementar la inteface {{@NavigationView.OnNavigationItemSelectedListener}}
        nav_view.setNavigationItemSelectedListener(this)

        // TODO (20) Para saber si estamos en modo dos paneles
        if (fragment_content != null ){
            twoPane =  true
        }


        /*
         * TODO (Instrucciones)Luego de leer todos los comentarios añada la implementación de RecyclerViewAdapter
         * Y la obtencion de datos para el API de Monedas
         */
    }


    // TODO (16) Para poder tener un comportamiento Predecible
    // TODO (16.1) Cuando se presione el boton back y el menu este abierto cerralo
    // TODO (16.2) De lo contrario hacer la accion predeterminada
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    // TODO (17) LLena el menu que esta en la barra. El de tres puntos a la derecha
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // TODO (18) Atiende el click del menu de la barra
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    // TODO (14.2) Funcion que recibe el ID del elemento tocado
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            // TODO (14.3) Los Id solo los que estan escritos en el archivo de MENU
            R.id.nav_camera -> {

            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        // TODO (15) Cuando se da click a un opcion del menu se cierra de manera automatica
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
