class Pedido(numero:Int, val platos:MutableList<Plato>, var estado:String = "pendiente") {
    private val numero = ++constPedido
    companion object {
        var constPedido:Int = 0
    }

    fun agregarPlato(plato: Plato){
        platos.add(plato)
    }

    fun eleminarPlato(nombrePlato: String){
        val platoEliminar = platos.find {nombrePlato == it.nombre }
        if (platoEliminar != null) platos.remove(platoEliminar) else println("Plato no encontrado")
    }
}