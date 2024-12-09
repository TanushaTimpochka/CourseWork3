package com.example.myapplication

class Package (id: Int, name: String) {
    val id = id
    val name = name
}

object PackageRepository {
    val packages = listOf(
        Package(0, "Без упаковки"),
        Package(1, "Целофановый пакет"),
        Package(2, "Пластиковая бутылка"),
        Package(3, "Тэтрапак"),
        Package(4, "Стеклянная бутылка"),
        Package(5, "Картонная упаковка"),
        Package(6, "Пластиковая форма"),
        Package(7, "Смешанная упаковка"),
        Package(8, "Металлическая банка"),
        Package(9, "Алюминиевая фольга"),
        Package(10, "Деревянная коробка"),
        Package(11, "Холщовый мешок"),
        Package(12, "Крафт-пакет"),
        Package(13, "Бумажный стакан"),
        Package(14, "Биопакет"),
        Package(15, "Плетеная корзина")
    )
}
