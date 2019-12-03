package com.example.menusample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

    private var _menuList: MutableList<MutableMap<String, Any>>? = null
    private val FROM = arrayOf("name", "price")
    private val TO = intArrayOf(R.id.tvMenuName, R.id.tvMenuPrice)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun createTeishokuList(): MutableList<MutableMap<String, Any>> {
            val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

            var menu = mutableMapOf("name" to "唐揚げ定食", "price" to 800, "desc" to "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Aまよ定食", "price" to 300, "desc" to "マヨネーズオンリーA。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Bまよ定食", "price" to 330, "desc" to "マヨネーズオンリーB。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Cまよ定食", "price" to 400, "desc" to "マヨネーズオンリーC。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Dまよ定食", "price" to 450, "desc" to "マヨネーズオンリーD。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Eまよ定食", "price" to 490, "desc" to "マヨネーズオンリーE。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Fまよ定食", "price" to 500, "desc" to "マヨネーズオンリーF。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Gまよ定食", "price" to 600, "desc" to "マヨネーズオンリーG。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Hまよ定食", "price" to 3400, "desc" to "マヨネーズオンリーH。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Iまよ定食", "price" to 410, "desc" to "マヨネーズオンリーI。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Jまよ定食", "price" to 200, "desc" to "マヨネーズオンリーJ。")
            menuList.add(menu)

            menu = mutableMapOf("name" to "Kまよ定食", "price" to 150, "desc" to "マヨネーズオンリーK。")
            menuList.add(menu)


            return menuList

        }

        _menuList = createTeishokuList()
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        val adapter = SimpleAdapter(applicationContext, _menuList, R.layout.row, FROM, TO)
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>
            val menuName = item["name"] as String
            val menuPrice = item["price"] as Int

            val intent = Intent(applicationContext, MenuThanksActivity::class.java)

            intent.putExtra("menuName", menuName)
            intent.putExtra("menuPrice", "${menuPrice}円")
            startActivity(intent)

        }
    }
}
