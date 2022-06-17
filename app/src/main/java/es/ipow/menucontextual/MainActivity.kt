package es.ipow.menucontextual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creamos menú contextual sobre un elemento EditText
        val vista = findViewById<TextView>(R.id.tvHelloWorld)
        registerForContextMenu(vista)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.tvHelloWorld) {
              // Crear menú progrmáticamente
//            menu?.setHeaderTitle("Menú contextual")
//            menu?.add(0, Menu.FIRST, Menu.NONE, "Copy")?.setIcon(R.drawable.copy_icon)
//            menu?.add(0, Menu.FIRST+1, Menu.NONE, "Delete")?.isCheckable = true
//            menu?.add(0, Menu.FIRST+2, Menu.NONE, "Paste")?.setShortcut('3','3')
//            val sub = menu?.addSubMenu("Título Submenú")
//            sub?.add("Elemento Submenú")
            // Cargar menú desde un recurso
            menuInflater.inflate(R.menu.contextual_menu, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        when (item.itemId) {
            R.id.elemento01 -> Toast.makeText(this, "Elemento 1", Toast.LENGTH_SHORT).show()
            R.id.elemento02 -> Toast.makeText(this, "Elemento 2", Toast.LENGTH_SHORT).show()
            R.id.elemento05 -> Toast.makeText(this, "Elemento 5", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}