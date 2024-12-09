package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class IdeaList : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_idea_list, container, false)
        val ideaList: RecyclerView = view.findViewById(R.id.ideaList)
        val ideas = ArrayList<IdeaItem>()

        ideas.add(IdeaItem(0, "Откажитесь от пластиковых бутылок", "Используйте собственную бутылку вместо этого. Вы можете набрать ее дома и пть в дороге и на тренировке, а дома используйте чашки. В магазинах очень много стильных бутылок для воды которыми можно пользоваться очень долго"))
        ideas.add(IdeaItem(1, "Скажите «нет» пластиковым пакетам", "Возьмите за привычку носить с собой многоразовые сумки и авоськи для покупок. Откажитесь от пластиковых пакетов, которые предлагаются в магазинах, и замените их на более экологичные варианты."))
        ideas.add(IdeaItem(2, "Сортируйте отходы", "Найдите на карте города куда можно сдать пластик, стекло, картон, батарейки, собирайте их дома в контейнер и регулярно отвозите на переработку."))
        ideas.add(IdeaItem(3, "Используйте натуральные чистящие средства", "Перейдите на натуральные и самодельные чистящие средства, которые не содержат вредных химикатов. Они не только безопаснее для вашего здоровья и окружающей среды, но и зачастую дешевле. Например, уксус и сода — это отличные средства для чистки."))



        ideaList.layoutManager = LinearLayoutManager(requireContext())
        ideaList.adapter = IdeaItemAdapter(ideas, requireContext())


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ShoppingList()
    }
}