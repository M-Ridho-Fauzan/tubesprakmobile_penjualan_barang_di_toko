package id.ac.unpas.tubesprakmobile_penjualan_barang_di_toko.ui.screens

sealed class NavScreen(val route: String) {
    object Home : NavScreen("home")
    object Add : NavScreen("add")
    object Edit : NavScreen("edit") {
        const val routeWithArgument: String = "edit/{id}"
        const val argument0 : String = "id"
    }
    object List : NavScreen("list")

    object Checkout : NavScreen("checkout")

    object Chart : NavScreen("chart")

    object Login : NavScreen("login")
}