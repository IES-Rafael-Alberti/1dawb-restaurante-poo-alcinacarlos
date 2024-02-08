class Mesa(val numero:Int, capacidad:Int, var estado:String = "libre", val pedidos:MutableList<Pedido> = mutableListOf<Pedido>() ) {
    val capacidad:Int = capacidad
    init {
        require(capacidad in 1..6){"Solo existen mesas de 1 a 6 comensales"}
    }
    fun ocuparMesa(){
        if (estado == "libre") estado = "ocupada"
    }
    fun ocuparReserva(){
        if (estado == "reservada") estado = "ocupada"
    }
    fun liberarMesa(){
        estado = "libre"
    }
    fun agregarPedido(Pedido:Pedido){
        pedidos.add(Pedido)
    }

    override fun toString(): String {
        var resultado = "Mesa $numero: $estado \n"
        for (pedido in pedidos){
            resultado += pedido.toString()
        }
        return resultado
    }

}