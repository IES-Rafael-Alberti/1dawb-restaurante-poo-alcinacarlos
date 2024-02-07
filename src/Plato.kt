class Plato(
    nombre: String,
    precio: Double,
    tiempoPreparacion: Int,
    val ingredientes: MutableList<String>
) {
    var nombre:String = nombre
        set(value) {
            checkNombre(value)
            field = value
        }
    var precio:Double = precio
        set(value) {
            checkPrecio(value)
            field = value
        }
    var tiempoPreparacion:Int = tiempoPreparacion
        set(value) {
            checkTiempo(value)
            field = value
        }
    init {
        checkPrecio(precio)
        checkTiempo(tiempoPreparacion)
        checkNombre(nombre)
        if (ingredientes.any { it.isEmpty() } || ingredientes.isEmpty() ) {
            throw IllegalArgumentException("Un ingrediente no puede estar vacío o la lista no puede estar vacia")
        }
        }
    private fun checkNombre(name:String){
        require(name.isNotBlank()) {"Nombre no puede estar vacio"}
    }
    private fun checkPrecio(price:Double){
        require(price > 0.0){"Precio tiene que ser mayor que 0"}
    }
    private fun checkTiempo(time:Int){
        require(time >= 1.0){"Tiempo de preparacion tiene que ser mayor o igual a 1"}
    }


    fun agregarIngrediente(ingrediente: String){
        ingrediente.ifBlank { throw IllegalArgumentException("Un ingrediente no puede estar vacío")  }
        ingredientes.add(ingrediente)
    }

    override fun toString(): String {
        return "$nombre ($tiempoPreparacion min.) -> $precio$ (${ingredientes.joinToString( ", ")})"
    }

}