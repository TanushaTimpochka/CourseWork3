package com.example.myapplication

class Package (id: Int, name: String, save: Boolean) {
    val id = id
    val name = name
    val save = save
}


object PackageRepository {
    val packages = listOf(
        Package(0, "Без упаковки", true),
        Package(1, "Целофановый пакет", false),
        Package(2, "Пластиковая бутылка", false),
        Package(3, "Тэтрапак", false),
        Package(4, "Стеклянная бутылка", false),
        Package(5, "Картонная упаковка", false),
        Package(6, "Пластиковая форма", false),
        Package(7, "Смешанная упаковка", false),
        Package(8, "Металлическая банка", false),
        Package(9, "Алюминиевая фольга", false),
        Package(10, "Деревянная коробка", false),
        Package(11, "Холщовый мешок", true),
        Package(12, "Крафт-пакет", false),
        Package(13, "Бумажный стакан", false),
        Package(14, "Биопакет", false),
        Package(15, "Плетеная корзина", false),
        Package(16, "Шоппер", true),
        Package(17, "Контейнер свой", true),
        Package(18, "Своя бутылка", true),
    )
}
