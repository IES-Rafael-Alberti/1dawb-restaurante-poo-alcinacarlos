class Pedido(numero:Int = 0, val platos:MutableList<Plato> = mutableListOf<Plato>(), var estado:String = "pendiente") {
    val numero = ++constPedido
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

    fun calcularPrecio():Double{
        var totalPrecio = 0.0
        platos.forEach { totalPrecio += it.precio }
        return totalPrecio
    }
    fun calcularTiempo():Int{
        return platos.sumOf { it.tiempoPreparacion }
    }

    override fun toString(): String {
        var resultado = ""
        platos.forEach { resultado+=it.toString() + "\n" }
        resultado+="Estado: $estado \n"
        return resultado
    }
}