class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {
        val xd: Mesa? = buscarMesa(numeroMesa)
        if (xd != null && xd.estado == "ocupada"){
            xd.pedidos.add(pedido)
        }
    }

    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        if (numeroPedido == null) {
            buscarMesa(numeroMesa)?.pedidos?.last()!!.estado = "servido"
        }else{
            mesas.find { numeroMesa == it.numero }?.pedidos!!.find { numeroPedido == it.numero }?.estado = "servido"
        }
    }

    fun cerrarMesa(numeroMesa: Int) {
        val mesa = buscarMesa(numeroMesa)
        if (mesa != null && mesa.pedidos.all {it.estado == "servido"}) mesa.liberarMesa()

    }

    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }
    private fun buscarMesa(numeroMesa: Int):Mesa?{
        return mesas.find { numeroMesa == it.numero }
    }
    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}